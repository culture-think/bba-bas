/* <p>文件名称: VehicleSelection.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:19:15
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

import java.util.Date;

/**
 * 车辆选择信息
 * @author zhanghuafeng
 */
public class VehicleSelection {
	/**
	 * Id
	 */
	private String id;
	/**
	 * 工作计划ID
	 */
	private String workPlanId;
	/**
	 * 选车用户ID
	 */
	private String userId;
	/**
	 * 车辆ID
	 */
	private String vehicleId;
	/**
	 * 选车时间
	 */
	private Date selectDate;
	/**
	 * 开始公里数
	 */
	private Integer beginKm;
	/**
	 * 结束公里数
	 */
	private Integer finishKm;
	/**
	 * 温度
	 */
	private Integer temperature;
	/**
	 * 天气
	 */
	private String weather;
	/**
	 * 测试人员：存储ID，逗号分隔，显示姓名
	 */
	private String testers;

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
	public String getProjectId() {
		return workPlanId;
	}
	/**
	 * 
	 */
	public void setProjectId(String projectId) {
		this.workPlanId = projectId;
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
	public Integer getBeginKm() {
		return beginKm;
	}
	/**
	 * 
	 */
	public void setBeginKm(Integer beginKm) {
		this.beginKm = beginKm;
	}
	/**
	 * 
	 */
	public Integer getFinishKm() {
		return finishKm;
	}
	/**
	 * 
	 */
	public void setFinishKm(Integer finishKm) {
		this.finishKm = finishKm;
	}
	/**
	 * 
	 */
	public Integer getTemperature() {
		return temperature;
	}
	/**
	 * 
	 */
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	/**
	 * 
	 */
	public String getWeather() {
		return weather;
	}
	/**
	 * 
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}
	/**
	 * 
	 */
	public String getTesters() {
		return testers;
	}
	/**
	 * 
	 */
	public void setTesters(String testers) {
		this.testers = testers;
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
	public String getUserId() {
		return userId;
	}
	/**
	 * 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 
	 */
	public Date getSelectDate() {
		return selectDate;
	}
	/**
	 * 
	 */
	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}
	
	public String getKey(){
		return this.workPlanId + this.vehicleId;
	}
}