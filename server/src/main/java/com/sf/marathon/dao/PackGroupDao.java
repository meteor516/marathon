package com.sf.marathon.dao;

import com.sf.marathon.domain.PackGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PackGroupDao extends JpaRepository<PackGroup, String> {


    @Query(value = "select u from com.sf.marathon.domain.PackGroup u where u.pid=:pid and u.finish = 0 limit 1")
    PackGroup findUnfinishGroup(@Param("pid") String pid);

}
