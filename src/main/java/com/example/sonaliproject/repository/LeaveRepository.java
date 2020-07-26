package com.example.sonaliproject.repository;


import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.model.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "leaves", path = "leaves")
public interface LeaveRepository extends PagingAndSortingRepository<Leave, Long> {

    @Query("select l from Leave l where l.leaveStatus=:leaveStatus")
    List<Leave> findByLeaveStatus(@Param("leaveStatus") LeaveStatus leaveStatus);
}