package com.group3.parknshop.common.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import com.group3.parknshop.common.dao.interfaces.BaseDao;
import com.group3.parknshop.common.page.Page;
import com.group3.parknshop.common.utils.ReflectionUtils;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	
	/**  
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging  
     */ 
    private Class<T> clazz;
    
    @Resource(name="sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    } 

  //  private Class<T> entityClass = ClassUtils.getSuperClassGenricType(this.getClass());
    
    /**  
     * Constructor that takes in a class to see which type of entity to persist  
     * @param persistentClass the class type you'd like to persist  
     */ 
/*    public BaseDaoImpl() {  
       // this.persistentClass = entityClass;  
    	ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
    	clazz = (Class<T>) type.getActualTypeArguments()[0];  
    	System.out.println("DAO����ʵʵ�����ǣ�" + this.clazz.getName()); 
    }  */
 
    /**  
     * {@inheritDoc}  
     */ 
    public List<T> getAll() {  
        return super.getHibernateTemplate().loadAll(this.clazz);  
    }  
      
    /**  
     * {@inheritDoc}  
     */ 
    @SuppressWarnings("unchecked")  
    public List<T> getAllDistinct() {  
        Collection result = new LinkedHashSet(getAll());  
        return new ArrayList(result);  
    }  
      
    /**  
     * {@inheritDoc}  
     */ 
    public T get(Integer id) {  
        T entity = super.getHibernateTemplate().get(this.clazz, id);  
        return entity;  
    }  
 
    /**  
     * {@inheritDoc}  
     */ 
    public boolean exists(Integer id) {  
        T entity = super.getHibernateTemplate().get(this.clazz, id);  
        return entity != null;  
    }  
 
    /**  
     * {@inheritDoc}  
     */ 
    public T save(T object) {  
        return super.getHibernateTemplate().merge(object);  
    }  
 
    /**  
     * {@inheritDoc}  
     */ 
    public void remove(Integer id) {  
        super.getHibernateTemplate().delete(this.get(id));  
    }  
      
   /**   
    * {@inheritDoc}  
    */ 
   public List<T> findByNamedQuery(  
       String queryName,   
       Map<String, Object> queryParams) {  
       String []params = new String[queryParams.size()];  
       Object []values = new Object[queryParams.size()];  
       int index = 0;  
       Iterator<String> i = queryParams.keySet().iterator();  
       while (i.hasNext()) {  
           String key = i.next();  
           params[index] = key;  
           values[index++] = queryParams.get(key);  
       }  
       return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,params,values);  
   }

	/**
	 * ��Criteria��ҳ��ѯ.
	 * @param page ��ҳ����.
	 * @param criterions �����ɱ��Criterion.
	 * @return ��ҳ��ѯ���.��������б����в�ѯ�������.
	 */
	public Page<T> findPage(final Page<T> page, final Criterion... criterions) {
		Assert.notNull(page, "page����Ϊ��");
		Criteria c = createCriteria(criterions);
		if (page.isAutoCount()) {
			long totalCount = countCriteriaResult(c);
			page.setTotalCount(totalCount);
		}
		setPageParameterToCriteria(c, page);
		List result = c.list();
		page.setResult(result);
		return page;
	}
	
	/**
	 * ����Criterion��������Criteria.
	 * ��find()�����ɽ��и������Ĳ���.
	 * @param criterions �����ɱ��Criterion.
	 */
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(clazz);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	/**
	 * ִ��count��ѯ��ñ���Criteria��ѯ���ܻ�õĶ�������.
	 */
	@SuppressWarnings("unchecked")
	protected long countCriteriaResult(final Criteria c) {
		CriteriaImpl impl = (CriteriaImpl) c;
		// �Ȱ�Projection��ResultTransformer��OrderByȡ����,������ߺ���ִ��Count����
		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();
		List<CriteriaImpl.OrderEntry> orderEntries = null;
		try {
			orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
			ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			//logger.error("�������׳����쳣:{}", e.getMessage());
		}
		// ִ��Count��ѯ
		Long totalCountObject = null ;
		try{
			totalCountObject = (Long) c.setProjection(Projections.rowCount()).uniqueResult();
		}catch(Exception e ){
			totalCountObject = Long.parseLong(new String(c.setProjection(Projections.rowCount()).uniqueResult().toString()));
		}
		long totalCount = (totalCountObject != null) ? totalCountObject : 0;
		// ��֮ǰ��Projection,ResultTransformer��OrderBy�����������ȥ
		c.setProjection(projection);

		if (projection == null) {
			c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (transformer != null) {
			c.setResultTransformer(transformer);
		}
		try {
			ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			//logger.error("�������׳����쳣:{}", e.getMessage());
		}
		return totalCount;
	}
	
	/**
	 * ���÷�ҳ������Criteria����,��������.
	 */
	protected Criteria setPageParameterToCriteria(final Criteria c, final Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");
		//hibernate��firstResult����Ŵ�0��ʼ
		c.setFirstResult(page.getFirst() - 1);
		c.setMaxResults(page.getPageSize());
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			Assert.isTrue(orderByArray.length == orderArray.length, "��ҳ�������������,�����ֶ���������ĸ��������");
			for (int i = 0; i < orderByArray.length; i++) {
				if (Page.ASC.equals(orderArray[i])) {
					c.addOrder(Order.asc(orderByArray[i]));
				} else {
					c.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}
		return c;
	}
	
	
	private String prepareCountHql(String orgHql) {
		String fromHql = orgHql;
		//select�Ӿ���order by�Ӿ��Ӱ��count��ѯ,���м򵥵��ų�.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		String countHql = "select count(*) " + fromHql;
		return countHql;
	}
	
	/**
	 * ���ݲ�ѯHQL������б���Query����.
	 * ��find()�����ɽ��и������Ĳ���.
	 * 
	 * @param values �����ɱ�Ĳ���,��˳���.
	 */
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString����Ϊ��");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	/**
	 * ��HQL��ѯΨһ����.
	 * 
	 * @param values �����ɱ�Ĳ���,��˳���.
	 */
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	
	/**
	 * ִ��count��ѯ��ñ���Hql��ѯ���ܻ�õĶ�������.
	 * 
	 * ������ֻ���Զ�����򵥵�hql���,���ӵ�hql��ѯ�����б�дcount����ѯ.
	 */
	protected long countHqlResult(final String hql, final Object... values) {
		String countHql = prepareCountHql(hql);
		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}
	

	/**
	 * ���÷�ҳ������Query����,��������.
	 */
	protected Query setPageParameterToQuery(final Query q, final Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");
		//hibernate��firstResult����Ŵ�0��ʼ
		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}
	
	/**
	 * ��HQL��ҳ��ѯ.
	 * 
	 * @param page ��ҳ����. ע�ⲻ֧�����е�orderBy����.
	 * @param hql hql���.
	 * @param values �����ɱ�Ĳ�ѯ����,��˳���.
	 * 
	 * @return ��ҳ��ѯ���, ��������б����в�ѯ�������.
	 */
	public Page<T> findPage(Page<T> page, String hql, Object... values) {
		Assert.notNull(page, "page����Ϊ��");
		Query q = createQuery(hql, values);
		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}
		setPageParameterToQuery(q, page);
		List result = q.list();
		page.setResult(result);
		return page;
	}
	
	/**
	 * ��HQL��ҳ��ѯ.
	 * 
	 * @param page ��ҳ����. ע�ⲻ֧�����е�orderBy����.
	 * @param hql hql���.
	 * @param values ��������,�����ư�.
	 * 
	 * @return ��ҳ��ѯ���, ��������б����в�ѯ�������.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page, final String hql, final Map<String, ?> values) {
		Assert.notNull(page, "page����Ϊ��");
		Query q = createQuery(hql, values);
		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalCount(totalCount);
		}
		setPageParameterToQuery(q, page);
		List result = q.list();
		page.setResult(result);
		return page;
	}
	
	/**
	 * ���ݲ�ѯHQL������б���Query����.
	 * ��find()�����ɽ��и������Ĳ���.
	 * 
	 * @param values ��������,�����ư�.
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString����Ϊ��");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	
	/**
	 * ִ��count��ѯ��ñ���Hql��ѯ���ܻ�õĶ�������.
	 * 
	 * ������ֻ���Զ�����򵥵�hql���,���ӵ�hql��ѯ�����б�дcount����ѯ.
	 */
	protected long countHqlResult(final String hql, final Map<String, ?> values) {
		String countHql = prepareCountHql(hql);
		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}
	
	/**
	 * ��HQL��ѯΨһ����.
	 * 
	 * @param values ��������,�����ư�.
	 */
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/******************����sql����ҳ��ѯ**************************/
	
	 /**
     * ��SQL��ѯ�����б�.
     * 
     * @param values
     *            �����ɱ�Ĳ���,��˳���.
     */
    public <X> List<X> findArrayObjBySQL(final String sql, final Object... values) {
        return createSQLQuery(sql, values).list();
    }
	  /**
     * ���ݲ�ѯSQL������б���SQLQuery����.
     * 
     * �����װ��find()����ȫ��Ĭ�Ϸ��ض�������ΪT,����ΪTʱʹ�ñ�����.
     * 
     * @param values
     *            �����ɱ�Ĳ���,��˳���.
     */
    public SQLQuery createSQLQuery(final String queryString,
            final Object... values) {
        Assert.hasText(queryString, "queryString����Ϊ��");
        SQLQuery query = getSession().createSQLQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }
	
	public Page<T> findPageBySql(Page<T> page, String sql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		Assert.notNull(page, "page����Ϊ��");
        SQLQuery q = createSQLQuery(sql, values);
        if (page.isAutoCount()) {
            long totalCount = countSQLResult(sql, values);
            page.setTotalCount(totalCount);
        }
        setPageParameterToQuery(q, page);
        List result = q.list();
        page.setResult(result);
        return page;
	}
	
	 /**
     * ���ݲ�ѯSql������б���SqlQuery����.
     * 
     * @param values
     *            ��������,�����ư�.
     */
    public SQLQuery createSQLQuery(final String queryString,
            final Map<String, ?> values) {
        Assert.hasText(queryString, "queryString����Ϊ��");
        SQLQuery query = getSession().createSQLQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }
    /**
     * ִ��count��ѯ��ñ���sql��ѯ���ܻ�õĶ�������. ������ֻ���Զ�����򵥵�hql���,���ӵ�hql��ѯ�����б�дcount����ѯ.
     */
    protected long countSQLResult(final String sql, Map<String, ?> values) {
        String fromHql = sql.toLowerCase();
        // select�Ӿ���order by�Ӿ��Ӱ��count��ѯ,���м򵥵��ų�.
        fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
        fromHql = StringUtils.substringBeforeLast(fromHql, "order by");
        String countSql = "select count(*) " + fromHql;
        try {
        	// BigDecimal count = findUniqueBySQL(countSql, values);
        	Integer count = findUniqueBySQL(countSql, values);
        	Long l = new Long(count);
        	return l.longValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("sql can't be auto count, sql is:"
                    + countSql, e);
        }
    }

    /**
     * ��SQL��ѯΨһ����.
     * 
     * @param values
     *            �����ɱ�Ĳ���,��˳���.
     */
    public <X> X findUniqueBySQL(final String sql, Map<String, ?> values) {
        return (X) createSQLQuery(sql, values).uniqueResult();
    }

	public T load(Integer id) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().load(this.clazz, id);
	}
	
}
