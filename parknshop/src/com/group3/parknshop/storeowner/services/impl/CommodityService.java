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
		return iCommodityDao.addCommodity(commodity) ;
	}

	public boolean updateCommodity(Commodity commodity) {
		return iCommodityDao.updateCommodity(commodity) ;
	}

	public boolean deleteCommodity(Commodity commodity) {
		return iCommodityDao.deleteCommodity(commodity) ;
	}

}
