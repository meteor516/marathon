package com.sf.marathon.dao;

import com.sf.marathon.domain.ProMarketBase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProMarketBaseRepository extends JpaRepository<ProMarketBase, String> {

	 @Query(value = "select u from com.sf.marathon.domain.ProMarketBase u where u.id = com.sf.marathon.domain.PackGroup")
	 Page<ProMarketBase> findAll(Pageable pageAble);
}
