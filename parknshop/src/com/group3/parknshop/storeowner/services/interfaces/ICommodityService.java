package com.group3.parknshop.storeowner.services.interfaces;

import com.group3.parknshop.entities.Commodity;

public interface ICommodityService {

	boolean addCommodity( Commodity commodity ) ;
	boolean updateCommodity( Commodity commodity ) ;
	boolean deleteCommodity( Commodity commodity ) ;	

}
