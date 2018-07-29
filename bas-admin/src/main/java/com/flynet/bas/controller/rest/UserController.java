/* <p>文件名称: UserController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月20日</p>
 * <p>完成日期：2017年2月20日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:36:20
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.exception.FlyNetException;
import com.flynet.bas.model.User;
import com.flynet.bas.security.IUserDetailsWrapper;
import com.flynet.bas.security.UserDetailsWrapper;
import com.flynet.bas.security.UserUtil;
import com.flynet.bas.service.UserService;

/**
 * 用户控制器
 * @author zhanghuafeng
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 获取用户列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String projectId = request.getParameter("projectId");
		if(projectId != null){
			parameters.put("projectId", projectId);
		}
		
		String type = request.getParameter("type");
		if(type != null){
			parameters.put("type", new Integer(type));
		}
		
		
		List<User> dataList = userService.getList(parameters);
		
		return dataList;
	}
	
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable String id, HttpServletResponse response) {
		User user = userService.getById(id);
		
		return user;
	}
	
	/**
	 * 获取当前用户信息
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/users/me", method = RequestMethod.GET)
	public User getCurrentUser( HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null){
			response.setStatus(401);
			return new User();
		}
		
		UserDetailsWrapper userDetails = (UserDetailsWrapper) authentication.getPrincipal();
		
		
		User user = userDetails.getUser();
		
		return user;
	}
	
	
	/**
	 * 添加用户
	 * @param user
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(@RequestBody User user, HttpServletResponse response) {
		try {
			user = userService.add(user);
		} catch (FlyNetException e) {
			e.printStackTrace();
			
			response.setStatus(e.getErrorCode());
		}
		
		return user;
	}
	
	/**
	 * 修改用户
	 * @param id
	 * @param user
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable String id, @RequestBody User user, HttpServletResponse response) {
		user.setId(id);
		
		try {
			user = userService.update(user);
		} catch (FlyNetException e) {
			e.printStackTrace();
			
			response.setStatus(e.getErrorCode());
		}
		return user;
	}
	
	@RequestMapping(value = "/users/modify-password", method = RequestMethod.PUT)
	public void modifyPassword(@RequestBody User user, HttpServletResponse response) {
		IUserDetailsWrapper currentUser = new UserUtil().getCurrentUser();
		String userId = currentUser.getId();
		user.setId(userId);
		
		try {
			userService.modifyPassword(user);
		} catch (FlyNetException e) {
			e.printStackTrace();
			
			response.setStatus(e.getErrorCode());
		}
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String id, HttpServletResponse response) {
		userService.delete(id);
	}
}
