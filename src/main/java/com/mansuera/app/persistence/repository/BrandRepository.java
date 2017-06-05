package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mansuera.app.persistence.entity.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long>  {

	public Brand findByName(String name);
	public List<Brand> findByNemonic(String nemonic);
}
