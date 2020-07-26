package com.example.sonaliproject.service;


import com.example.sonaliproject.aop.annotation.Logged;
import com.example.sonaliproject.aop.annotation.RequestThreadId;
import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.exception.ErrorCodes;
import com.example.sonaliproject.exception.InternalErrorException;
import com.example.sonaliproject.exception.ValidationException;
import com.example.sonaliproject.model.entity.Leave;
import com.example.sonaliproject.model.request.LeaveRequest;
import com.example.sonaliproject.model.request.LeaveUpdateRequest;
import com.example.sonaliproject.model.response.LeaveResponse;
import com.example.sonaliproject.repository.LeaveRepository;
import com.example.sonaliproject.transformer.LeaveTransformer;
import com.example.sonaliproject.validator.RequestParamValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveTransformer leaveTransformer;

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    @Logged
    @RequestThreadId
    public List<LeaveResponse> getLeaves() {
        try {
            List<Leave> leaves = leaveRepository.findAllLeaves();
            log.info("All Leaves: " + leaves);
            return leaves.parallelStream().map((leave) -> leaveTransformer.buildLeaveResponse(leave)).collect(Collectors.toList());

        } catch (ValidationException ex) {
            log.info("Validation Exception : ", ex);
            throw ex;
        } catch (Exception ex){
            log.error("Exception: ", ex);
            throw new InternalErrorException(ex);
        }
    }
    @Override
    @Logged
    @RequestThreadId
    public List<LeaveResponse> getLeave(String leaveStatus){
        try{
        log.info("Getting leaves for status: "+leaveStatus);
        if(!LeaveStatus.isValid(leaveStatus)){
            throw new ValidationException(ErrorCodes.LEAVE_STATUS_INVALID.toString());
        }
        List<Leave> leaves=leaveRepository.findByLeaveStatus(LeaveStatus.valueOf(leaveStatus));
        return leaves.parallelStream().map((leave) -> leaveTransformer.buildLeaveResponse(leave)).collect(Collectors.toList());
        } catch (ValidationException ex) {
            log.info("Validation Exception : ", ex);
            throw ex;
        } catch (Exception ex){
            log.error("Exception: ", ex);
            throw new InternalErrorException(ex);
        }

    }

    @Override
    @Logged
    @RequestThreadId
    public void createLeave(LeaveRequest leaveRequest) {
        try{
        RequestParamValidator.validate(leaveRequest);
        Leave leave=leaveTransformer.buildLeave(leaveRequest);
        leave=leaveRepository.saveAndFlush(leave);
    } catch (ValidationException ex) {
        log.info("Validation Exception : ", ex);
        throw ex;
    } catch (Exception ex){
        log.error("Exception: ", ex);
        throw new InternalErrorException(ex);
    }
    }

    @Override
    @Logged
    @RequestThreadId
    public LeaveResponse updateLeave(Long id, LeaveUpdateRequest leaveUpdateRequest) {
        try{
        Leave leave=leaveRepository.findById(id).orElse(null);
        if(leave==null){
            throw new ValidationException(ErrorCodes.LEAVE_DOES_NOT_EXIST.toString());
        }
        if( !StringUtils.isEmpty(leaveUpdateRequest.getReason())){
            leave.setReason(leaveUpdateRequest.getReason());
        }
        if(leaveUpdateRequest.getStartDate()!=null){
            leave.setStartDate(leaveUpdateRequest.getStartDate());
        }
        if(leaveUpdateRequest.getEndDate()!=null){
            leave.setEndDate(leaveUpdateRequest.getEndDate());
        }
        if(leaveUpdateRequest.getIsHalfDay()!=null){
            leave.setIsHalfDay(leaveUpdateRequest.getIsHalfDay());
        }
        if(leaveUpdateRequest.getLeaveType()!=null){
            leave.setLeaveType(leaveUpdateRequest.getLeaveType());
        }
        if(leaveUpdateRequest.getLeaveStatus()!=null){
            leave.setLeaveStatus(leaveUpdateRequest.getLeaveStatus());
        }
        leave=leaveRepository.save(leave);
        return leaveTransformer.buildLeaveResponse(leave);
    } catch (ValidationException ex) {
        log.info("Validation Exception : ", ex);
        throw ex;
    } catch (Exception ex){
        log.error("Exception: ", ex);
        throw new InternalErrorException(ex);
    }
    }

    @Override
    @Logged
    @RequestThreadId
    public void deleteLeave(Long id) {
        try{
        Leave leave=leaveRepository.findById(id).get();
        if(leave==null){
            throw new ValidationException(ErrorCodes.LEAVE_DOES_NOT_EXIST.toString());
        }
        leaveRepository.delete(leave);
    } catch (ValidationException ex) {
        log.info("Validation Exception : ", ex);
        throw ex;
    } catch (Exception ex){
        log.error("Exception: ", ex);
        throw new InternalErrorException(ex);
    }
    }


}

