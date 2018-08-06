/* <p>文件名称: WorkPlan.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:11:53
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
import java.util.List;

/**
 *
 * @author zhanghuafeng
 */
public class WorkPlan {
	/**
	 * Id
	 */
	private String id;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后修改用户ID
	 */
	private String lastUpdateUserId;
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;
	/**
	 * 项目
	 */
	private Project project;
	/**
	 * 工作计划用户列表
	 */
	private List<WorkPlanUser> users;
	/**
	 * 工作计划车辆列表
	 */
	private List<WorkPlanVehicle> vehicles;
	/**
	 * 创建人
	 */
	private User creator;
	/**
	 * 最后修改人
	 */
	private User lastUpdateUser;
	
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
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * 
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 
	 */
	public List<WorkPlanUser> getUsers() {
		return users;
	}
	/**
	 * 
	 */
	public void setUsers(List<WorkPlanUser> users) {
		this.users = users;
	}
	/**
	 * 
	 */
	public List<WorkPlanVehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * 
	 */
	public void setVehicles(List<WorkPlanVehicle> vehicles) {
		this.vehicles = vehicles;
	}
	/**
	 * 
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * 
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * 
	 */
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	/**
	 * 
	 */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	/**
	 * 
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	/**
	 * 
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 
	 */
	public User getCreator() {
		return creator;
	}
	/**
	 * 
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}
	/**
	 * 
	 */
	public User getLastUpdateUser() {
		return lastUpdateUser;
	}
	/**
	 * 
	 */
	public void setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
}
