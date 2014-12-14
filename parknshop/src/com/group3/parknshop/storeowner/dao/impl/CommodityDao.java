package com.group3.parknshop.storeowner.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.group3.parknshop.common.dao.impl.BaseDaoImpl;
import com.group3.parknshop.entities.Commodity;
import com.group3.parknshop.storeowner.dao.interfaces.ICommodityDao;

@Repository( "commodityDao" )
public class CommodityDao extends BaseDaoImpl implements ICommodityDao {

	public boolean addCommodity(Commodity commodity) {
		if(this.getHibernateTemplate().save(commodity) != null)
			return true;
		return false;
	}

	public boolean updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		if( this.getHibernateTemplate().contains(commodity) )
			try {
				this.getHibernateTemplate().delete(commodity);
				return true ;
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false ;
	}

}
