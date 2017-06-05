package com.mansuera.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@SuppressWarnings("serial")
@Entity
@Table(name = "model",schema="mansuera")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_seq_gen")
	@SequenceGenerator(name = "model_seq_gen", sequenceName = "mansuera.model_id_seq")
	private Long id;
	
	@JsonBackReference
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nemonic")
	private String nemonic;
	
	@Column(name = "is_produce")
	private Boolean isProduce;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNemonic() {
		return nemonic;
	}

	public void setNemonic(String nemonic) {
		this.nemonic = nemonic;
	}

	public Boolean getIsProduce() {
		return isProduce;
	}

	public void setIsProduce(Boolean isProduce) {
		this.isProduce = isProduce;
	}
	
	

}
