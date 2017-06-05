package com.mansuera.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.AutoPart;
import com.mansuera.app.persistence.repository.AutoPartRepository;


@Service
public class AutoPartService {

	@Autowired
	private AutoPartRepository autoPartRepository;
	
	public List<AutoPart> getAll(){
		return autoPartRepository.findAll();
	}
	
	@Transactional
	public AutoPart save(AutoPart autoPart){
		return autoPartRepository.save(autoPart);
	}
	
	@Transactional
	public String delete(AutoPart autoPart){
		String result = "OK";
		
		AutoPart found = autoPartRepository.findOne(autoPart.getId());
		
		if(found!=null){
			autoPartRepository.delete(found);
		}
		
		return result;
	}
	
	@Transactional
	public String deletePart(Long partId){
		
		AutoPart found = autoPartRepository.findOne(partId);
		
		return delete(found);
	}
}
