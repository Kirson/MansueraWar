package com.mansuera.app.persistence.vo;

import java.io.Serializable;

import com.mansuera.app.persistence.entity.Model;

public class ModelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4359926865589328779L;
	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
