package com.mansuera.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mansuera.app.persistence.entity.MansueraLog;


public interface MansueraLogRepository extends JpaRepository<MansueraLog, Long> {

	public List<MansueraLog> findByReferenceId(String referenceId);
}
