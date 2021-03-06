package com.example.sonaliproject.model.response;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.constants.enums.LeaveType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaveResponse {
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
