/* <p>文件名称: ProjectDao.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午7:23:20
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.flynet.bas.model.WorkPlan;

/**
 * 工作计划映射器
 * @author zhanghuafeng
 */
@Mapper
public interface WorkPlanDao {	
	/**
	 * 获取工作计划
	 * @param id
	 */
	WorkPlan get(String id);
	/**
	 * 获取工作计划列表
	 * @param entity
	 */
	List<WorkPlan> getList(Map<String, Object> parameters);
	/**
	 * 添加工作计划
	 * @param entity
	 */
	int add(WorkPlan entity);
	/**
	 * 修改工作计划
	 * @param entity
	 */
	int update(WorkPlan entity);
	/**
	 * 删除工作计划
	 * @param id
	 */
	void delete(String id);
}