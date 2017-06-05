package com.mansuera.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;
import com.mansuera.app.persistence.repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository modelRepository;
	
	public Model findByNemonic(String nemonic) {
		List<Model> query = modelRepository.findByNemonic(nemonic);

		if (query != null && !query.isEmpty()) {
			return query.get(0);
		} else {
			return null;
		}
	}
	
	public List<Model> getModels(){
		return modelRepository.findAll();
	}
	
	public List<Model> findByBrand(Brand brand){
		return modelRepository.findByBrand(brand);
	}
	
	@Transactional
	public Model save(Model model){
		return modelRepository.save(model);
	}
}
