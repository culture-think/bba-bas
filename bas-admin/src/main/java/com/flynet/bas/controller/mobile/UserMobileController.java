/* <p>文件名称: UserMobileController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月12日</p>
 * <p>完成日期：2018年8月12日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午3:24:30
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.controller.mobile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.model.User;
import com.flynet.bas.service.UserService;

/**
 * 用户移动端控制器
 * @author zhanghuafeng
 */
@RestController
@RequestMapping(value = "/mobile-api")
public class UserMobileController {
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
		parameters.put("type", UserService.NORMAL_USER_TYPE);
		
		String projectId = request.getParameter("projectId");
		if(projectId != null){
			parameters.put("projectId", projectId);
		}
		
		List<User> dataList = userService.getList(parameters);
		
		return dataList;
	}
}
