package com.sf.marathon.dao;

import com.sf.marathon.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByName(String name);

    @Query(value = "select u from com.sf.marathon.domain.Address u where u.name=:name")
    Page<Address> findByUserName(@Param("name") String name, Pageable pageAble);
}
