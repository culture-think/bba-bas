/* <p>文件名称: WorkPlanController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午3:54:28
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.model.WorkPlan;
import com.flynet.bas.exception.FlyNetException;
import com.flynet.bas.service.WorkPlanService;

/**
 * 工作计划控制器
 * @author zhanghuafeng
 */
@RestController
@RequestMapping(value = "/mobile-api")
public class WorkPlanMobileCotroller {
	@Autowired
	private WorkPlanService workPlanService;

	/**
	 * 获取工作计划列表
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/work-plans", method = RequestMethod.GET)
	public List<WorkPlan> getWorkPlans(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		List<WorkPlan> list = workPlanService.getList(parameters);
		
		return list;
	}
	
	/**
	 * 获取工作计划信息
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/work-plans/{id}", method = RequestMethod.GET)
	public WorkPlan getWorkPlan(@PathVariable String id, HttpServletResponse response) {
		WorkPlan entity = workPlanService.get(id);
		
		return entity;
	}
	
	/**
	 * 添加工作计划
	 * @param entity
	 * @param response
	 * @return
	 * @throws FlyNetException 
	 */
	@RequestMapping(value = "/work-plans", method = RequestMethod.POST)
	public Map<String, Object> addWorkPlan(@RequestBody WorkPlan entity, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			entity = workPlanService.add(entity);
			result.put("success", Boolean.TRUE);
			result.put("entity", entity);
		} catch (FlyNetException e) {
			result.put("success", Boolean.FALSE);
			result.put("errorCode", e.getErrorCode());
		}
		
		return result;
	}
	
	/**
	 * 修改工作计划
	 * @param id
	 * @param entity
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/work-plans/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updateWorkPlan(@PathVariable String id, @RequestBody WorkPlan entity, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			entity.setId(id);
			entity = workPlanService.update(entity);
			result.put("success", Boolean.TRUE);
			result.put("entity", entity);
		} catch (FlyNetException e) {
			result.put("success", Boolean.FALSE);
			result.put("errorCode", e.getErrorCode());
		}
		
		return result;
	}
	
	/**
	 * 删除工作计划
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/work-plans/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteWorkPlan(@PathVariable String id, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			workPlanService.delete(id);
			result.put("success", Boolean.TRUE);
		} catch (FlyNetException e) {
			result.put("success", Boolean.FALSE);
			result.put("errorCode", e.getErrorCode());
		}
		
		return result;
	}
}
