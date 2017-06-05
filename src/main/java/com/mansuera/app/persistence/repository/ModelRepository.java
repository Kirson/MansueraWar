package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
	
	public List<Model> findByBrand(Brand brand);
	public List<Model> findByNemonic(String nemonic);

}
