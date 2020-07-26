package com.example.sonaliproject.model.response;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.constants.enums.LeaveType;
import com.example.sonaliproject.model.entity.Leave;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class LeaveResponse {
    public LeaveResponse(Leave leave){
        this.leaveId=leave.getLeaveId();
        this.reason=leave.getReason();
        this.startDate=leave.getStartDate();
        this.endDate=leave.getEndDate();
        this.isHalfDay=leave.getIsHalfDay();
        this.leaveType=leave.getLeaveType();
        this.leaveStatus=leave.getLeaveStatus();
        this.appliedDate=leave.getAppliedDate();
        this.updatedDate=leave.getUpdatedDate();
    }
    private Long leaveId;
    private String reason;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isHalfDay;
    private LeaveType leaveType;
    private LeaveStatus leaveStatus;
    private LocalDateTime appliedDate;
    private LocalDateTime updatedDate;
}
