package com.cos.nextICityPrepare2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.nextICityPrepare2.model.niBoard;

public interface niBoardRepository extends JpaRepository<niBoard, Integer> , JpaSpecificationExecutor<niBoard>{
	@Modifying
	@Query("update niBoard p set p.count = p.count + 1 where p.id = :id")
	int updateCount(int id);
}
