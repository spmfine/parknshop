package com.group3.parknshop.storeowner.dao.interfaces;

import com.group3.parknshop.entities.Commodity;

public interface ICommodityDao {

	boolean addCommodity( Commodity commodity ) ;
	boolean updateCommodity( Commodity commodity ) ;
	boolean deleteCommodity( Commodity commodity ) ;	
}
