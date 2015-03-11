package com.dream.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dream.cms.common.StoreList;
import com.dream.cms.common.JsonQuery;
import com.dream.cms.db.model.Commodity;
import com.dream.cms.db.model.Store;
import com.dream.cms.support.CommoditySupport;

@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {
	@Autowired
	private CommoditySupport _commoditySupport;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody Commodity commodity) {
		System.out.println(commodity.getName() + "////////////////////");
		_commoditySupport.insert(commodity);
	}

	@RequestMapping(value = "/getCommodities", method = RequestMethod.POST)
	public List<Commodity> getCommodities(@RequestBody JsonQuery jsonQuery) {
		return _commoditySupport.getCommodities(jsonQuery);
	}
	
	@RequestMapping(value = "/saveInstore", method = RequestMethod.POST)
	public void saveInstore(@RequestBody StoreList storeList) {
//		System.out.println(instoreList.getInstoreList().size());
		_commoditySupport.saveInstore(storeList);
	}
	
	@RequestMapping(value = "/saveOutstore", method = RequestMethod.POST)
	public void saveOutstore(@RequestBody StoreList storeList) {
//		System.out.println(instoreList.getInstoreList().size());
		_commoditySupport.saveOutstore(storeList);
	}
	
	@RequestMapping(value = "/getStore", method = RequestMethod.POST)
	public List<Store> getStore(@RequestBody JsonQuery jsonQuery) {
//		System.out.println(instoreList.getInstoreList().size());
		return _commoditySupport.getStore(jsonQuery);
	}
}
