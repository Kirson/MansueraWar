package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansuera.app.persistence.entity.Catalog;


public interface CatalogRepository extends JpaRepository<Catalog, Long> {

	
	public List<Catalog> findByMainCatalog(Catalog mainCatalog);
	public List<Catalog> findByMainCatalogIsNull();
	public List<Catalog> findByNemonic(String nemonic);
	
}
