package com.sf.marathon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.marathon.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
