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
}
