/* <p>文件名称: WorkPlanService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:00:51
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

import com.flynet.bas.exception.FlyNetException;
import com.flynet.bas.model.WorkPlan;

/**
 * 
 * @author zhanghuafeng
 */
public interface WorkPlanService {
	/**
	 * 获取工作计划列表
	 * @param parameters
	 * @return
	 */
	List<WorkPlan> getList(Map<String, Object> parameters);
	
	/**
	 * 获取工作计划
	 * @param id
	 * @return
	 */
	WorkPlan get(String id);
	
	/**
	 * 添加工作计划
	 * @param entity
	 * @return
	 */
	WorkPlan add(WorkPlan entity) throws FlyNetException;
	
	/**
	 * 修改工作计划：不能修改项目，只能修改用户列表和车辆列表
	 * @param entity
	 * @return
	 */
	WorkPlan update(WorkPlan entity) throws FlyNetException;
	
	/**
	 * 删除工作计划
	 * @param id
	 */
	void delete(String id) throws FlyNetException;
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	WorkPlan getByProjectId(String projectId);
}
