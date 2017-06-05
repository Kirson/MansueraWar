package com.mansuera.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mansuera.app.persistence.entity.Model;
import com.mansuera.app.persistence.service.ModelService;
import com.mansuera.app.persistence.vo.ModelVO;

@RestController
@RequestMapping(value = "/api/model")
@CrossOrigin(origins = "*")
public class ModelController {

	@Autowired
	ModelService modelService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Model>> getAll(){
		
		List<Model> found = modelService.getModels();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Model>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Model>>(new ArrayList<Model>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Model> save(@RequestBody ModelVO modelVO){
		
		Model response = modelService.save(modelVO.getModel());
		
		return new ResponseEntity<Model>(response,HttpStatus.OK);
	}
	
	
}
