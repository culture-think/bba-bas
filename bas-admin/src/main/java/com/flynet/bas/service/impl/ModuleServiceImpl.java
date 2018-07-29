/* <p>文件名称: ModuleServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年1月11日</p>
 * <p>完成日期：2018年1月11日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午8:33:44
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.ModuleDao;
import com.flynet.bas.model.Module;
import com.flynet.bas.service.ModuleService;

/**
 * 模块服务实现
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public List<Module> getList(Map<String, Object> parameters) {
		List<Module> list = moduleDao.getList(parameters);
		
		//处理父模块
		Map<String, Module> moduleMap = new HashMap<String, Module>();
		for(Module module: list){
			moduleMap.put(module.getId(), module);
		}
		
		Module parent = null;
		for(Module module: list){
			parent = moduleMap.get(module.getParentId());
			if(parent != null){
				parent = new Module(parent);
			}
			module.setParent(parent);
		}

		return list;
	}

	@Override
	public Module get(String id) {
		Module entity = moduleDao.get(id);
		
		return entity;
	}

	@Override
	public Module add(Module entity) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		entity.setId(id);
		
		moduleDao.add(entity);

		return entity;
	}

	@Override
	public void delete(String id) {
		moduleDao.delete(id);
	}

	@Override
	public void update(Module entity) {
		moduleDao.update(entity);
	}

}
