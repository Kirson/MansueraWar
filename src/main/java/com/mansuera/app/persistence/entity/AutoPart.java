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

@Entity
@Table(name = "auto_part",schema="mansuera")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AutoPart implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -603687214382848708L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_part_seq_gen")
	@SequenceGenerator(name = "auto_part_seq_gen", sequenceName = "mansuera.auto_part_id_seq")
	private Long id;
	
	@JsonBackReference(value="brand")
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	
	@JsonBackReference(value="model")
	@JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Model model;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "fr")
	private String fr;
	
	@Column(name = "observation_text")
	private String observationText;
	
	@Column(name = "system_description_text")
	private String systemDescription;
	
	@Column(name = "maker")
	private String maker;
	
	@JsonBackReference(value="category")
	@JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog category;
	
	@JsonBackReference(value="motorNumber")
	@JoinColumn(name = "motor_number_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog motorNumber;
	
	@JsonBackReference(value="observation")
	@JoinColumn(name = "observation_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog observation;
	
	@JsonBackReference(value="partBrand")
	@JoinColumn(name = "part_brand_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog partBrand;
	
	@JsonBackReference(value="startYear")
	@JoinColumn(name = "start_year_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog startYear;
	
	@JsonBackReference(value="endYear")
	@JoinColumn(name = "end_year_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog endYear;

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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getObservationText() {
		return observationText;
	}

	public void setObservationText(String observationText) {
		this.observationText = observationText;
	}

	public String getSystemDescription() {
		return systemDescription;
	}

	public void setSystemDescription(String systemDescription) {
		this.systemDescription = systemDescription;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Catalog getCategory() {
		return category;
	}

	public void setCategory(Catalog category) {
		this.category = category;
	}

	public Catalog getMotorNumber() {
		return motorNumber;
	}

	public void setMotorNumber(Catalog motorNumber) {
		this.motorNumber = motorNumber;
	}

	public Catalog getObservation() {
		return observation;
	}

	public void setObservation(Catalog observation) {
		this.observation = observation;
	}

	public Catalog getPartBrand() {
		return partBrand;
	}

	public void setPartBrand(Catalog partBrand) {
		this.partBrand = partBrand;
	}

	public Catalog getStartYear() {
		return startYear;
	}

	public void setStartYear(Catalog startYear) {
		this.startYear = startYear;
	}

	public Catalog getEndYear() {
		return endYear;
	}

	public void setEndYear(Catalog endYear) {
		this.endYear = endYear;
	}
	
	

}
