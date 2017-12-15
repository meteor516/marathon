package com.sf.marathon.dao;

import com.sf.marathon.domain.PackGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackGroupDao extends JpaRepository<PackGroup, String> {

    @Query(value = "select u from com.sf.marathon.domain.PackGroup u where u.id=:id and u.finish = 0 ")
    PackGroup findUnfinishPackageGroupById(@Param("id") String id);

    @Query(value = "select u from com.sf.marathon.domain.PackGroup u where u.proMarketBase.id=:pid and u.finish = 0")
    List<PackGroup> findUnfinishGroup(@Param("pid") String pid);

}
