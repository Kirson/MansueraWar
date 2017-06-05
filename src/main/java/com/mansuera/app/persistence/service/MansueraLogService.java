package com.mansuera.app.persistence.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.MansueraLog;
import com.mansuera.app.persistence.repository.MansueraLogRepository;

@Service
public class MansueraLogService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8685035589734782340L;
	
	@Autowired
	private MansueraLogRepository repository;
	
	public List<MansueraLog> getAll(){
		return repository.findAll();
	}
	
	public MansueraLog save(MansueraLog entity){
		return repository.save(entity);
	}
	
	public List<MansueraLog> findByReferenceId(String referenceId){
		return repository.findByReferenceId(referenceId);
	}
}
