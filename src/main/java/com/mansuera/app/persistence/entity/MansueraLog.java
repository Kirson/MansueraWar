package com.mansuera.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mansuera_log",schema="mansuera")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MansueraLog implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7108446606774024212L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mansuera_log_id_seq")
	@SequenceGenerator(name = "mansuera_log_id_seq", sequenceName = "mansuera.mansuera_log_id_seq")
	private Long id;
	
	@Column(name="process_name")
	private String processName;
	
	@org.hibernate.annotations.Type(type="com.mansuera.app.persistence.util.SQLXMLType")
	@Column(name="xml_info")
	private String xmlInfo;
	
	@Column(name="error_info")
	private String errorInfo;
	
	@org.hibernate.annotations.Type(type="com.mansuera.app.persistence.util.SQLXMLType")
	@Column(name="additional_info")
	private String additionalInfo;
	
	@Column(name="text_info")
	private String textinfo;
	
	@Column(name="log_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logDate;
	
	@Column(name="reference_id")
	private String referenceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getXmlInfo() {
		return xmlInfo;
	}

	public void setXmlInfo(String xmlInfo) {
		this.xmlInfo = xmlInfo;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getTextinfo() {
		return textinfo;
	}

	public void setTextinfo(String textinfo) {
		this.textinfo = textinfo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	
	
	
}
