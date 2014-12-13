package com.group3.parknshop.storeowner.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group3.parknshop.common.dao.impl.BaseDaoImpl;
import com.group3.parknshop.entities.Commodity;
import com.group3.parknshop.storeowner.dao.interfaces.ICommodityDao;
import com.group3.parknshop.storeowner.services.interfaces.ICommodityService;

@Service( "commodityService" )
public class CommodityService extends BaseDaoImpl implements ICommodityService {

	@Resource( name = "commodityDao" ) 
	private ICommodityDao iCommodityDao ;

	public boolean addCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return false;
	}

}
