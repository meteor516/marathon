package com.sf.marathon.service;

import com.sf.marathon.dao.ProMarketBaseRepository;
import com.sf.marathon.domain.ProMarketBase;

import org.springframework.beans.factory.annotation.Autowired;
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
}
