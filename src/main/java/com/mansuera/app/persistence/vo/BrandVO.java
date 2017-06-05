package com.mansuera.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;

public class BrandVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 2774328127673554142L;
	private Long brandId;
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	private Brand brand;
	private List<Model> modelList;
	private List<Model> removeList;
	private Model model;
	
	public BrandVO(){
		modelList = new ArrayList<Model>();
		removeList = new ArrayList<Model>();
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Model> getModelList() {
		return modelList;
	}

	public void setModelList(List<Model> modelList) {
		this.modelList = modelList;
	}

	public List<Model> getRemoveList() {
		return removeList;
	}

	public void setRemoveList(List<Model> removeList) {
		this.removeList = removeList;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
	
}
