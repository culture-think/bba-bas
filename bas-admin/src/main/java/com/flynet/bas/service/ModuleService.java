/* <p>文件名称: ModuleService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年1月11日</p>
 * <p>完成日期：2018年1月11日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午8:08:15
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

import com.flynet.bas.model.Module;

/**
 * 模块服务接口
 * @author zhanghuafeng
 */
public interface ModuleService {
	/**
	 * 获取模块列表
	 * @return
	 */
	List<Module> getList(Map<String, Object> parameters);
	
	/**
	 * 获取模块
	 * @param id
	 * @return
	 */
	Module get(String id);
		
	/**
	 * 添加模块
	 * @param entity
	 * @return
	 */
	Module add(Module entity);
	
	/**
	 * 删除模块
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 修改模块信息
	 * @param entity
	 */
	void update(Module entity);
}
