/* <p>文件名称: ProjectController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:45:15
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.controller.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.model.Project;
import com.flynet.bas.model.User;
import com.flynet.bas.model.Vehicle;
import com.flynet.bas.service.ProjectService;
import com.flynet.bas.service.UserService;
import com.flynet.bas.service.VehicleService;

/**
 * 项目控制器
 * @author zhanghuafeng
 */
@RestController
@RequestMapping(value = "/api")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired(required = false)
	private VehicleService vehicleService;
	
	/**
	 * 获取项目列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public List<Project> getProjects(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		List<Project> dataList = projectService.getList(parameters);
		
		return dataList;
	}
	
	/**
	 * 获取项目信息
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public Project getProject(@PathVariable String id, HttpServletResponse response) {
		Project project = projectService.get(id);
		
		return project;
	}
	
	/**
	 * 添加项目
	 * @param project
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public Project addProject(@RequestBody Project project, HttpServletResponse response) {
		project = projectService.add(project);
		
		return project;
	}
	
	/**
	 * 修改项目
	 * @param id
	 * @param project
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
	public Project updateProject(@PathVariable String id, @RequestBody Project project, HttpServletResponse response) {
		project.setId(id);
		
		project = projectService.update(project);
		
		return project;
	}
	
	/**
	 * 删除项目
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable String id, HttpServletResponse response) {
		projectService.delete(id);
	}
	
	/**
	 * 获取项目用户信息
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "/projects/{projectId}/users", method = RequestMethod.GET)
	public List<User> getProjectUsers(@PathVariable String projectId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("projectId", projectId);
		List<User> userList = userService.getList(parameters);
		
		return userList;
	}
	
	
	/**
	 * 获取项目车辆信息
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "/projects/{projectId}/vehicles", method = RequestMethod.GET)
	public List<Vehicle> getProjectVehicles(@PathVariable String projectId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("projectId", projectId);
		List<Vehicle> vehicleList = vehicleService.getList(parameters);
		
		return vehicleList;
	}
	
}
