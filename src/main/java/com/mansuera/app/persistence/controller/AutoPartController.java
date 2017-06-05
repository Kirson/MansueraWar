package com.mansuera.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mansuera.app.persistence.entity.AutoPart;
import com.mansuera.app.persistence.service.AutoPartService;
import com.mansuera.app.persistence.vo.AutoPartVO;

@RestController
@RequestMapping(value = "/api/autopart")
@CrossOrigin(origins = "*")
public class AutoPartController {

	@Autowired
	AutoPartService autoPartService;
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<AutoPart>> getAll(){
		
		List<AutoPart> found = autoPartService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<AutoPart>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<AutoPart>>(new ArrayList<AutoPart>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutoPart> save(@RequestBody AutoPartVO autoPartVO){
		
		AutoPart response = autoPartService.save(autoPartVO.getAutoPart());
		
		return new ResponseEntity<AutoPart>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody AutoPartVO autoPartVO){
		
		String response = autoPartService.deletePart(autoPartVO.getPartId());
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
