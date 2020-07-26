package com.example.sonaliproject.model.entity;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.constants.enums.LeaveType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LEAVE_INFO")
public class Leave implements Serializable {

    @Id
    @Column(name = "LEAVE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "IS_HALF_DAY")
    private Boolean isHalfDay;

    @Column(name = "LEAVE_TYPE")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @Column(name = "APPLIED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime appliedDate;

    @Column(name = "UPDATED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime updatedDate;
}
//    create TABLE `LEAVE_INFO` (
//        `LEAVE_ID` int(11) NOT NULL AUTO_INCREMENT,
//        `REASON` varchar(500) NOT NULL,
//        `START_DATE` datetime NOT NULL ,
//        `END_DATE` datetime NOT NULL,
//        `IS_HALF_DAY` tinyint(1) NOT NULL DEFAULT '0',
//        `LEAVE_TYPE` enum('CL','PL','LWP') NOT NULL DEFAULT 'LWP',
//        `STATUS` enum('APPLIED','APPROVED','REJECTED','AVAILED') NOT NULL DEFAULT 'APPLIED',
//        `APPLIED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
//        `UPDATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP ON update CURRENT_TIMESTAMP,
//        PRIMARY KEY(`LEAVE_ID`),
//        INDEX(LEAVE_TYPE,STATUS)
//        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;