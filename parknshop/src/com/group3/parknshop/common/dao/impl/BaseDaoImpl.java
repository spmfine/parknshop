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
    	System.out.println("DAO的真实实现类是：" + this.clazz.getName()); 
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
	 * 按Criteria分页查询.
	 * @param page 分页参数.
	 * @param criterions 数量可变的Criterion.
	 * @return 分页查询结果.附带结果列表及所有查询输入参数.
	 */
	public Page<T> findPage(final Page<T> page, final Criterion... criterions) {
		Assert.notNull(page, "page不能为空");
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
	 * 根据Criterion条件创建Criteria.
	 * 与find()函数可进行更加灵活的操作.
	 * @param criterions 数量可变的Criterion.
	 */
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(clazz);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	/**
	 * 执行count查询获得本次Criteria查询所能获得的对象总数.
	 */
	@SuppressWarnings("unchecked")
	protected long countCriteriaResult(final Criteria c) {
		CriteriaImpl impl = (CriteriaImpl) c;
		// 先把Projection、ResultTransformer、OrderBy取出来,清空三者后再执行Count操作
		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();
		List<CriteriaImpl.OrderEntry> orderEntries = null;
		try {
			orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
			ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			//logger.error("不可能抛出的异常:{}", e.getMessage());
		}
		// 执行Count查询
		Long totalCountObject = null ;
		try{
			totalCountObject = (Long) c.setProjection(Projections.rowCount()).uniqueResult();
		}catch(Exception e ){
			totalCountObject = Long.parseLong(new String(c.setProjection(Projections.rowCount()).uniqueResult().toString()));
		}
		long totalCount = (totalCountObject != null) ? totalCountObject : 0;
		// 将之前的Projection,ResultTransformer和OrderBy条件重新设回去
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
			//logger.error("不可能抛出的异常:{}", e.getMessage());
		}
		return totalCount;
	}
	
	/**
	 * 设置分页参数到Criteria对象,辅助函数.
	 */
	protected Criteria setPageParameterToCriteria(final Criteria c, final Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");
		//hibernate的firstResult的序号从0开始
		c.setFirstResult(page.getFirst() - 1);
		c.setMaxResults(page.getPageSize());
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");
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
		//select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		String countHql = "select count(*) " + fromHql;
		return countHql;
	}
	
	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 与find()函数可进行更加灵活的操作.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	
	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
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
	 * 设置分页参数到Query对象,辅助函数.
	 */
	protected Query setPageParameterToQuery(final Query q, final Page<T> page) {
		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");
		//hibernate的firstResult的序号从0开始
		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}
	
	/**
	 * 按HQL分页查询.
	 * 
	 * @param page 分页参数. 注意不支持其中的orderBy参数.
	 * @param hql hql语句.
	 * @param values 数量可变的查询参数,按顺序绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	public Page<T> findPage(Page<T> page, String hql, Object... values) {
		Assert.notNull(page, "page不能为空");
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
	 * 按HQL分页查询.
	 * 
	 * @param page 分页参数. 注意不支持其中的orderBy参数.
	 * @param hql hql语句.
	 * @param values 命名参数,按名称绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page, final String hql, final Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");
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
	 * 根据查询HQL与参数列表创建Query对象.
	 * 与find()函数可进行更加灵活的操作.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	
	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
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
	 * 按HQL查询唯一对象.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/******************根据sql语句分页查询**************************/
	
	 /**
     * 按SQL查询对象列表.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    public <X> List<X> findArrayObjBySQL(final String sql, final Object... values) {
        return createSQLQuery(sql, values).list();
    }
	  /**
     * 根据查询SQL与参数列表创建SQLQuery对象.
     * 
     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    public SQLQuery createSQLQuery(final String queryString,
            final Object... values) {
        Assert.hasText(queryString, "queryString不能为空");
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
		Assert.notNull(page, "page不能为空");
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
     * 根据查询Sql与参数列表创建SqlQuery对象.
     * 
     * @param values
     *            命名参数,按名称绑定.
     */
    public SQLQuery createSQLQuery(final String queryString,
            final Map<String, ?> values) {
        Assert.hasText(queryString, "queryString不能为空");
        SQLQuery query = getSession().createSQLQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }
    /**
     * 执行count查询获得本次sql查询所能获得的对象总数. 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
     */
    protected long countSQLResult(final String sql, Map<String, ?> values) {
        String fromHql = sql.toLowerCase();
        // select子句与order by子句会影响count查询,进行简单的排除.
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
     * 按SQL查询唯一对象.
     * 
     * @param values
     *            数量可变的参数,按顺序绑定.
     */
    public <X> X findUniqueBySQL(final String sql, Map<String, ?> values) {
        return (X) createSQLQuery(sql, values).uniqueResult();
    }

	public T load(Integer id) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().load(this.clazz, id);
	}
	
}
