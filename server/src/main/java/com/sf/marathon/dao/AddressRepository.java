package com.sf.marathon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.marathon.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByName(String xxx);
}
