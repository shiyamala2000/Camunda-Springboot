package com.kgisl.leave.model;


public class LeaveRequest {
	
    private String employeeId;
    private int leaveDays;
    
    public LeaveRequest() {
    	
    }
	public LeaveRequest(String employeeId, int leaveDays) {
		super();
		this.employeeId = employeeId;
		this.leaveDays = leaveDays;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}

    
}