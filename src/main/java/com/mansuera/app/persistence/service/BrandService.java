package com.mansuera.app.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;
import com.mansuera.app.persistence.repository.BrandRepository;
import com.mansuera.app.persistence.repository.ModelRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ModelRepository modelRepository;

	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}

	public Brand findByName(String name) {
		return brandRepository.findByName(name);
	}

	public Brand findByNemonic(String nemonic) {
		List<Brand> query = brandRepository.findByNemonic(nemonic);

		if (query != null && !query.isEmpty()) {
			return query.get(0);
		} else {
			return null;
		}
	}
	
	@Transactional
	public Brand save(Brand brand){
		return brandRepository.save(brand);
	}
	
	@Transactional
	public Brand save(Brand brand, List<Model> modelList, List<Model> removeList){
		 brandRepository.save(brand);
		 brandRepository.flush();
		 
		 if(removeList!=null && !removeList.isEmpty()){
			 for(Model mr:removeList){
				 removeModel(mr);
			 }
		 }
		 
		 if (modelList != null && !modelList.isEmpty()) {
				for (Model m : modelList) {
					m.setBrand(brand);;
					modelRepository.save(m);
				}
			}
		 
		 return brand;
	}
	
	@Transactional
	public void removeModel(Model model){
		Model found = modelRepository.findOne(model.getId());
		if (found != null) {
			modelRepository.delete(found);
		}
	}
	
	@Transactional
	public void removeAllModel(List<Model> modelList){
		
			modelRepository.delete(modelList);
		
	}
	
	@Transactional
	public Model saveModel(Model model) {

		if (model.getId().intValue() == -1) {
			model.setId(null);
		}
		modelRepository.save(model);
		return model;
	}
	
	public List<Model> getModels(Long brandId){
		Brand brand = brandRepository.findOne(brandId);
		return modelRepository.findByBrand(brand);
		
	}
	
	@Transactional
	public String delete(Brand brand){
		String result = "OK";
		
		Brand found = brandRepository.findOne(brand.getId());
		
		List<Model> models = modelRepository.findByBrand(found);
		
		if(models!=null && !models.isEmpty()){
			removeAllModel(models);
			modelRepository.flush();
		}
		
		brandRepository.delete(found);
		brandRepository.flush();
		
		return result;
	}
	

	@Transactional
	public String deleteBrand(Long brandId){
	
		
		Brand found = brandRepository.findOne(brandId);
		
		return delete(found);
	
	}

}
