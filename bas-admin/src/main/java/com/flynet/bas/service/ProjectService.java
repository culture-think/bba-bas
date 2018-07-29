/* <p>文件名称: ProjectService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:28:20
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service;

import java.util.List;
import java.util.Map;

import com.flynet.bas.model.Project;
import com.flynet.bas.model.ProjectUser;
import com.flynet.bas.model.ProjectVehicle;

/**
 *
 * @author zhanghuafeng
 */
public interface ProjectService {
	/**
	 * 获取项目列表
	 * @param parameters
	 * @return
	 */
	List<Project> getList(Map<String, Object> parameters);
	/**
	 * 获取项目
	 * @param id
	 * @return
	 */
	Project get(String id);
	/**
	 * 添加项目
	 * @param entity
	 * @return
	 */
	Project add(Project entity);
	/**
	 * 删除项目
	 * @param id
	 */
	void delete(String id);
	/**
	 * 修改项目
	 * @param entity
	 * @return
	 */
	Project update(Project entity);
	
	/**
	 * 修改项目用户列表
	 * @param projectUsers
	 */
	void updateUsers(List<ProjectUser> projectUsers);
	
	/**
	 * 修改项目车辆列表
	 * @param projectVehicles
	 */
	void updateVehicles(List<ProjectVehicle> projectVehicles);
}
