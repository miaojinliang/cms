package com.dream.cms.support;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dream.cms.common.JsonQuery;
import com.dream.cms.common.StoreList;
import com.dream.cms.db.CommodityMapper;
import com.dream.cms.db.InstoreHistoryMapper;
import com.dream.cms.db.OutstoreHistoryMapper;
import com.dream.cms.db.StoreMapper;
import com.dream.cms.db.model.Commodity;
import com.dream.cms.db.model.InstoreHistory;
import com.dream.cms.db.model.OutstoreHistory;
import com.dream.cms.db.model.Store;

public class CommoditySupport {
	@Autowired
	private CommodityMapper _commodityMapper;
	
	@Autowired
	private InstoreHistoryMapper _instoreMapper;
	
	@Autowired
	private OutstoreHistoryMapper _outstoreMapper;
	
	@Autowired
	private StoreMapper _storeMapper;

	public void insert(Commodity commodity) {
		_commodityMapper.insert(commodity);
	}
	
	public List<Commodity> getCommodities(JsonQuery jsonQuery){
		return _commodityMapper.getCommodities(jsonQuery);
	}
	
	public void saveInstore(StoreList instoreList){
		for(InstoreHistory instore : instoreList.getInstoreList()){
			Store store = _storeMapper.getCommodityStore(instore.getCode());
			if(store==null){
				store = new Store();
				store.setCode(instore.getCode());
				store.setCount(instore.getCount());
				_storeMapper.insert(store);
			}else{
				store.setCount(store.getCount()+instore.getCount());
				_storeMapper.update(store);
			}
			instore.setDate(new Date());
			_instoreMapper.insert(instore);
		}
	}
	
	public void saveOutstore(StoreList storeList){
		for(OutstoreHistory outstore : storeList.getOutstoreList()){
			Store store = _storeMapper.getCommodityStore(outstore.getCode());
			if(store==null){
				store = new Store();
				store.setCode(outstore.getCode());
				store.setCount(0);
				_storeMapper.insert(store);
			}else{
				store.setCount(store.getCount()-outstore.getCount());
				_storeMapper.update(store);
			}
			outstore.setDate(new Date());
			_outstoreMapper.insert(outstore);
		}
	}
	
	public List<Store> getStore(JsonQuery jsonQuery){
		return _storeMapper.getStore(jsonQuery);
	}
}
