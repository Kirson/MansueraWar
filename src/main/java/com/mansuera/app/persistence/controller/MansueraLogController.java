package com.mansuera.app.persistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mansuera.app.persistence.entity.MansueraLog;
import com.mansuera.app.persistence.service.MansueraLogService;

@RestController
@RequestMapping(value = "/api/mansueralog")
@CrossOrigin(origins = "*")
public class MansueraLogController {

	@Autowired
	MansueraLogService mansueraLogService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public  ResponseEntity<List<MansueraLog>> getAll(){
		
		List<MansueraLog> found = mansueraLogService.getAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<MansueraLog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<MansueraLog>>(new ArrayList<MansueraLog>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/findByReferenceId/{referenceId}", method = RequestMethod.GET)
	public  ResponseEntity<List<MansueraLog>> findByReferenceId(@PathVariable("referenceId") String referenceId){
		
		List<MansueraLog> found = mansueraLogService.findByReferenceId(referenceId);
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<MansueraLog>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<MansueraLog>>(new ArrayList<MansueraLog>(),HttpStatus.OK);
	    }
	}
}
