package com.example.sonaliproject.transformer;

import com.example.sonaliproject.aop.annotation.Logged;
import com.example.sonaliproject.model.entity.Leave;
import com.example.sonaliproject.model.request.LeaveRequest;
import com.example.sonaliproject.model.response.LeaveResponse;
import org.springframework.stereotype.Component;

@Component
public class LeaveTransformer {

    @Logged
    public LeaveResponse buildLeaveResponse(Leave leave) {
        LeaveResponse leaveResponse=new LeaveResponse();
        leaveResponse.setReason(leave.getReason());
        leaveResponse.setLeaveId(leave.getLeaveId());
        leaveResponse.setStartDate(leave.getStartDate());
        leaveResponse.setEndDate(leave.getEndDate());
        leaveResponse.setIsHalfDay(leave.getIsHalfDay());
        leaveResponse.setLeaveType(leave.getLeaveType());
        leaveResponse.setLeaveStatus(leave.getLeaveStatus());
        leaveResponse.setAppliedDate(leave.getAppliedDate());
        leaveResponse.setUpdatedDate(leave.getUpdatedDate());
        return leaveResponse;

    }
    @Logged
    public Leave buildLeave(LeaveRequest leaveRequest) {
        Leave leave=new Leave();
        leave.setReason(leaveRequest.getReason());
        leave.setStartDate(leaveRequest.getStartDate());
        leave.setEndDate(leaveRequest.getEndDate());
        leave.setIsHalfDay(leaveRequest.getIsHalfDay());
        leave.setLeaveType(leaveRequest.getLeaveType());
        leave.setLeaveStatus(leaveRequest.getLeaveStatus());
        return leave;
    }
}
