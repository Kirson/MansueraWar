package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansuera.app.persistence.entity.AutoPart;
import com.mansuera.app.persistence.entity.Brand;
import com.mansuera.app.persistence.entity.Catalog;
import com.mansuera.app.persistence.entity.Model;

public interface AutoPartRepository extends JpaRepository<AutoPart, Long> {
	
	public List<AutoPart> findByBrand(Brand brand);
	public List<AutoPart> findByModel(Model model);
	public List<AutoPart> findByCategory(Catalog category);
	public List<AutoPart> findByPartBrand(Catalog partBrand);

}
