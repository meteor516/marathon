package com.sf.marathon.service.impl;

import com.sf.marathon.dao.ProMarketBaseRepository;
import com.sf.marathon.domain.ProMarketBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProMarketBaseService {
	@Autowired
	private ProMarketBaseRepository proMarketBaseRepository;

	public List<ProMarketBase> findAll() {
		return proMarketBaseRepository.findAll();
	}
	
	public ProMarketBase getOne(String id) {
		return proMarketBaseRepository.getOne(id);
	}
	
	public Page<ProMarketBase> findAll(int page,int pageSize){
		Pageable pageable = new PageRequest(page, pageSize);
		return proMarketBaseRepository.findAll(pageable);
	}
	
}
