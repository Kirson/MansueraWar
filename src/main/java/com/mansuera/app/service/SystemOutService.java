package com.mansuera.app.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.mansuera.app.persistence.entity.MansueraLog;
import com.mansuera.app.persistence.service.MansueraLogService;

@Service
public class SystemOutService implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 7076904526090186870L;

	@Autowired
	protected PropertySourcesPlaceholderConfigurer propertyConfigurer;
	
	@Autowired
	private MansueraLogService logService;
	
	private @Value("${mansuera.log.system.out}") String printSystemOut;
	private @Value("${mansuera.log.database}") String printDatabase;
	
	
	
	
	public void println(String line){
		
		if(printSystemOut.equals("Y")){
			print(line,null);
		}else if(printDatabase.equals("Y")){
			MansueraLog mlog = new MansueraLog();
			mlog.setLogDate(new Date());
			mlog.setProcessName("SYSTEM-OUT");
			mlog.setErrorInfo(line);
			logService.save(mlog);
		}
		
	}
	
	public void println(Exception exception){
		
		if(printSystemOut.equals("Y")){
			print(null,exception);
		}else if(printDatabase.equals("Y")){
			MansueraLog mlog = new MansueraLog();
			mlog.setLogDate(new Date());
			mlog.setProcessName("SYSTEM-OUT");
			mlog.setErrorInfo(exception.getMessage());
			logService.save(mlog);
		}
		
	}
	
	private void print(String line, Exception exception){
		try{
			
			if(exception==null){
				System.out.println(line);
			}else{
				System.out.println("Exception "+exception.getMessage());
				exception.printStackTrace();
			}
			
		}catch(Exception e){
			MansueraLog mlog = new MansueraLog();
			mlog.setLogDate(new Date());
			mlog.setProcessName("SYSTEM-OUT-ERROR");
			mlog.setErrorInfo(e.getMessage());
			logService.save(mlog);
		}
	}
	
}
