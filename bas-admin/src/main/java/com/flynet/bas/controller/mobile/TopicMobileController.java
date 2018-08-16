/* <p>文件名称: TopicMobileController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月16日</p>
 * <p>完成日期：2018年8月16日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午10:56:05
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.model.Topic;
import com.flynet.bas.service.TopicService;

/**
 *
 * @author zhanghuafeng
 */
@RestController
@RequestMapping(value = "/mobile-api")
public class TopicMobileController {
	@Autowired
	private TopicService topicService;
	
	/**
	 * 获取问题列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public List<Topic> getTopics(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String workPlanId = request.getParameter("workPlanId");
		if(workPlanId != null){
			parameters.put("workPlanId", workPlanId);
		}
		
		String vehicleId = request.getParameter("vehicleId");
		if(vehicleId != null){
			parameters.put("vehicleId", vehicleId);
		}
		
		List<Topic> list = topicService.getList(parameters);
		
		return list;
	}

	/**
	 * 获取问题列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/topics", method = RequestMethod.PUT)
	public List<Topic> updateTopics(@RequestBody List<Topic> list, HttpServletRequest request, HttpServletResponse response) {
		list = topicService.updateList(list);
		
		return list;
	}
}
