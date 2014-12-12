package com.group3.parknshop.storeowner.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group3.parknshop.storeowner.dao.interfaces.IApplyOpenShopDao;
import com.group3.parknshop.storeowner.services.interfaces.IApplyOpenShopService;

@Service( "applyOpenShopService" )
public class ApplyOpenShopService implements IApplyOpenShopService {

	@Resource( name = "applyOpenShopDao" )
	private IApplyOpenShopDao applyOpenShopDao ;
}
