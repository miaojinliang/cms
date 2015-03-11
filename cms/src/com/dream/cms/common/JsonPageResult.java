package com.dream.cms.common;

import java.util.List;

public class JsonPageResult<T> extends JsonResult<List<T>> {
	
	private long total;

	public JsonPageResult(long total, List<T> result) {
		super(result);
		this.total = total;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
}
