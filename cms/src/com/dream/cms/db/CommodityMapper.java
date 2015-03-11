package com.dream.cms.db;

import java.util.List;

import com.dream.cms.common.JsonQuery;
import com.dream.cms.db.model.Commodity;


public interface CommodityMapper {
	public int insert(Commodity commodity);
	public List<Commodity> getCommodities(JsonQuery jsonQuery);
}
