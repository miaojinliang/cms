package com.dream.cms.common;

import java.util.List;

import com.dream.cms.db.model.InstoreHistory;
import com.dream.cms.db.model.OutstoreHistory;

public class StoreList {
	private List<InstoreHistory> instoreList;
	private List<OutstoreHistory> outstoreList;

	public List<InstoreHistory> getInstoreList() {
		return instoreList;
	}

	public void setInstoreList(List<InstoreHistory> instoreList) {
		this.instoreList = instoreList;
	}

	public List<OutstoreHistory> getOutstoreList() {
		return outstoreList;
	}

	public void setOutstoreList(List<OutstoreHistory> outstoreList) {
		this.outstoreList = outstoreList;
	}
	
}
