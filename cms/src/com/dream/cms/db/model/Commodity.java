package com.dream.cms.db.model;

public class Commodity {
	private Integer id;
	private String code;
	private String name;
	private Double inPrice;
	private Double outPrice;
	private String productor;
	private Integer qualityDay;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getInPrice() {
		return inPrice;
	}
	public void setInPrice(Double inPrice) {
		this.inPrice = inPrice;
	}
	public Double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(Double outPrice) {
		this.outPrice = outPrice;
	}
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public Integer getQualityDay() {
		return qualityDay;
	}
	public void setQualityDay(Integer qualityDay) {
		this.qualityDay = qualityDay;
	}
	
}
