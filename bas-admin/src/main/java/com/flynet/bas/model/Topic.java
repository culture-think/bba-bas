/* <p>文件名称: Topic.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月16日</p>
 * <p>完成日期：2018年8月16日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:19:54
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

import java.util.List;

/**
 * 问题
 * @author zhanghuafeng
 */
public class Topic {
	/**
	 * Id
	 */
	private String id;
	/**
	 * 工作计划ID
	 */
	private String workPlanId;
	/**
	 * 车辆ID
	 */
	private String vehicleId;
	/**
	 * 序号，界面显示No.
	 */
	private Integer orderNumber;
	/**
	 * 问题描述
	 */
	private String problemDescription;
	/**
	 * BI
	 */
	private Integer bi;
	/**
	 * BI说明
	 */
	private String comment;
	/**
	 * 测试人员ID
	 */
	private String testerId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 分析部门
	 */
	private String analyseDepartment;
	/**
	 * 新问题还是旧问题，true为新问题，false为旧问题
	 */
	private Boolean newOrOld = Boolean.TRUE;
	/**
	 * 专家
	 */
	private String  specialist;
	/**
	 * 专家BI
	 */
	private Integer specialistBi;
	/**
	 * PQM/ALM No.
	 */
	private String pqmAlmNumber;
	/**
	 * ATG-IT No.
	 */
	private String atgItNumber;
	/**
	 * Remark
	 */
	private String remark;
	/**
	 * 测试人员
	 */
	private User tester;
	/**
	 * 车辆
	 */
	private Vehicle vehicle;
	
    /**
     * 视频
     */
    private List<Document> vedios;
    
    /**
     * 图片列表
     */
    private List<Document> pictures;
    
	/**
	 * 
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public String getWorkPlanId() {
		return workPlanId;
	}
	/**
	 * 
	 */
	public void setWorkPlanId(String workPlanId) {
		this.workPlanId = workPlanId;
	}
	/**
	 * 
	 */
	public String getVehicleId() {
		return vehicleId;
	}
	/**
	 * 
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	/**
	 * 
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * 
	 */
	public String getProblemDescription() {
		return problemDescription;
	}
	/**
	 * 
	 */
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	/**
	 * 
	 */
	public Integer getBi() {
		return bi;
	}
	/**
	 * 
	 */
	public void setBi(Integer bi) {
		this.bi = bi;
	}
	/**
	 * 
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 
	 */
	public String getTesterId() {
		return testerId;
	}
	/**
	 * 
	 */
	public void setTesterId(String testerId) {
		this.testerId = testerId;
	}
	/**
	 * 
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 
	 */
	public String getAnalyseDepartment() {
		return analyseDepartment;
	}
	/**
	 * 
	 */
	public void setAnalyseDepartment(String analyseDepartment) {
		this.analyseDepartment = analyseDepartment;
	}
	/**
	 * 
	 */
	public Boolean getNewOrOld() {
		return newOrOld;
	}
	/**
	 * 
	 */
	public void setNewOrOld(Boolean newOrOld) {
		this.newOrOld = newOrOld;
	}
	/**
	 * 
	 */
	public String getSpecialist() {
		return specialist;
	}
	/**
	 * 
	 */
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	/**
	 * 
	 */
	public Integer getSpecialistBi() {
		return specialistBi;
	}
	/**
	 * 
	 */
	public void setSpecialistBi(Integer specialistBi) {
		this.specialistBi = specialistBi;
	}
	/**
	 * 
	 */
	public String getPqmAlmNumber() {
		return pqmAlmNumber;
	}
	/**
	 * 
	 */
	public void setPqmAlmNumber(String pqmAlmNumber) {
		this.pqmAlmNumber = pqmAlmNumber;
	}
	/**
	 * 
	 */
	public String getAtgItNumber() {
		return atgItNumber;
	}
	/**
	 * 
	 */
	public void setAtgItNumber(String atgItNumber) {
		this.atgItNumber = atgItNumber;
	}
	/**
	 * 
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 
	 */
	public User getTester() {
		return tester;
	}
	/**
	 * 
	 */
	public void setTester(User tester) {
		this.tester = tester;
	}
	/**
	 * 
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/**
	 * 
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * 
	 */
	public List<Document> getVedios() {
		return vedios;
	}
	/**
	 * 
	 */
	public void setVedios(List<Document> vedios) {
		this.vedios = vedios;
	}
	/**
	 * 
	 */
	public List<Document> getPictures() {
		return pictures;
	}
	/**
	 * 
	 */
	public void setPictures(List<Document> pictures) {
		this.pictures = pictures;
	}
	
}
