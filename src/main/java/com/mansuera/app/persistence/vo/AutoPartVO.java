package com.mansuera.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mansuera.app.persistence.entity.AutoPart;
import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;

public class AutoPartVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6238568109081503794L;
	private Long partId;
	private AutoPart autoPart;
	private List<Brand> brands;
	private List<Model> models;
	
	public AutoPartVO(){
		brands = new ArrayList<Brand>();
		models = new ArrayList<Model>();
	}

	public AutoPart getAutoPart() {
		return autoPart;
	}

	public void setAutoPart(AutoPart autoPart) {
		this.autoPart = autoPart;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}
	
	
	
}
