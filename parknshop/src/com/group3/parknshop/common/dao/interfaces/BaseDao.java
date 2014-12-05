package com.group3.parknshop.common.dao.interfaces;

import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import com.group3.parknshop.common.page.*;


/**
 * ͨ�����ݳ־ò�
 * 
 */
public interface BaseDao<T> {
	 /**  
     * Generic method used to get all objects of a particular type. This  
     * is the same as lookup up all rows in a table.  
     * @return List of populated objects  
     */ 
    List<T> getAll();  
 
    /**  
     * Generic method to get an object based on class and identifier. An  
     * ObjectRetrievalFailureException Runtime Exception is thrown if  
     * nothing is found.  
     *  
     * @param id the identifier (primary key) of the object to get  
     * @return a populated object  
     * @see org.springframework.orm.ObjectRetrievalFailureException  
     */ 
    T get(Integer id);  
 
    /**  
     * Checks for existence of an object of type T using the id arg.  
     * @param id the id of the entity  
     * @return - true if it exists, false if it doesn't  
     */ 
    T load(Integer id);
    
    /**  
     * Generic method to save an object - handles both update and insert.  
     * @param object the object to save  
     * @return the persisted object  
     */ 
    T save(T object);  
 
    /**  
     * Generic method to delete an object based on class and id  
     * @param id the identifier (primary key) of the object to remove  
     */ 
    void remove(Integer id);  
      
    /**  
     * Gets all records without duplicates.  
     * <p>Note that if you use this method, it is imperative that your model  
     * classes correctly implement the hashcode/equals methods</p>  
     * @return List of populated objects  
     */ 
    List<T> getAllDistinct();  
      
 
    /**  
     * Find a list of records by using a named query  
     * @param queryName query name of the named query  
     * @param queryParams a map of the query names and the values  
     * @return a list of the records found  
     */ 
    List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);  
    
    /**
	 * ��Criteria��ҳ��ѯ.
	 * 
	 * @param page ��ҳ����.
	 * @param criterions �����ɱ��Criterion.
	 * 
	 * @return ��ҳ��ѯ���.��������б����в�ѯ�������.
	 */
	public Page<T> findPage(final Page<T> page, final Criterion... criterions) ;
	
	public Page<T> findPage(final Page<T> page, final String hql,final Object... values);
	
	/**
	 * ��HQL��ҳ��ѯ.
	 * 
	 * @param page ��ҳ����. ע�ⲻ֧�����е�orderBy����.
	 * @param hql hql���.
	 * @param values ��������,�����ư�.
	 * 
	 * @return ��ҳ��ѯ���, ��������б����в�ѯ�������.
	 */
	public Page<T> findPage(final Page<T> page, final String hql, final Map<String, ?> values);
	
	public Page<T> findPageBySql(final Page<T> page, final String sql, final Map<String, ?> values);
	
	public <X> List<X> findArrayObjBySQL(final String sql, final Object... values);
}
