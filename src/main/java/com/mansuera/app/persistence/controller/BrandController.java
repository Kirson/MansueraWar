package com.mansuera.app.persistence.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;
import com.mansuera.app.persistence.service.BrandService;
import com.mansuera.app.persistence.vo.BrandVO;

@RestController
@RequestMapping(value = "/api/brand")
@CrossOrigin(origins = "*")
public class BrandController {

	@Autowired
	BrandService brandService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Brand>> getAll(){
		
		List<Brand> found = brandService.getBrands();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Brand>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Brand>>(new ArrayList<Brand>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Brand> save(@RequestBody BrandVO brandVO){
		
		Brand response = brandService.save(brandVO.getBrand());
		
		return new ResponseEntity<Brand>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Brand> create(@RequestBody BrandVO brandVO){
		
		Brand response = brandService.save(brandVO.getBrand());
		
		return new ResponseEntity<Brand>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Brand> update(@RequestBody BrandVO brandVO){
		
		Brand response = brandService.save(brandVO.getBrand());
		
		return new ResponseEntity<Brand>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getModels{brandId}", method = RequestMethod.GET)
	public  ResponseEntity<List<Model>> getContacts(@PathVariable("brandId") Long brandId){
		
		List<Model> found = null;
		
		 found = brandService.getModels(brandId);
	
		
		
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Model>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Model>>(new ArrayList<Model>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/removeModel", method = RequestMethod.POST)
	public ResponseEntity<String> removeModel(@RequestBody BrandVO brandVO){
		String response = "OK";
		 
		brandService.removeModel(brandVO.getModel());
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody BrandVO brandVO){
		
		String response = brandService.deleteBrand(brandVO.getBrandId());
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
}
