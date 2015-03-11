package com.dream.cms.db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.cms.common.JsonQuery;
import com.dream.cms.db.model.Store;



public interface StoreMapper {
	public void insert(Store store);
	public void update(Store store);
	public Store getCommodityStore(@Param("code") String code);
	public List<Store> getStore(JsonQuery jsonQuery);
}
