/* <p>文件名称: ProjectVehicle.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳飞网科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午9:48:20
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

/**
 * 项目车辆关系
 * @author zhanghuafeng
 */
public class ProjectVehicle {
	/**
	 * Id
	 */
	private String id;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 车辆ID
	 */
	private String vehicleId;
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
	private Float temperature;
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
		return projectId;
	}
	/**
	 * 
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public Float getTemperature() {
		return temperature;
	}
	/**
	 * 
	 */
	public void setTemperature(Float temperature) {
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
	
}
