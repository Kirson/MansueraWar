package com.mansuera.app.util;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Utilitario para reemplazar valores nulos por blancos
 * en campos de tipo string
 * @author cherrera
 */
public class ObjectUtil implements Serializable {

	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7264636852053003018L;

	public static Object replaceNullString(Object obj){
	
		Class<?> c = obj.getClass();
		
		for(Field f:c.getDeclaredFields()){
			if(f.getType().equals(String.class)){
               try {
            	   f.setAccessible(true);
            	   Object value = f.get(obj);
            	   if(value==null){
            		   f.set(obj, "");
            	   }
				
               } catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
		}
		
		return obj;
	}
}
