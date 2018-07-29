package com.flynet.bas.controller.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flynet.bas.model.Module;
import com.flynet.bas.service.ModuleService;

/**
 * 模块控制器
 * @author zhanghuafeng
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/api")
public class ModuleController {
	@Autowired(required = false)
	private ModuleService moduleService;
	
	/**
	 * 获取模块列表
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public List<Module> getModule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String parentId = request.getParameter("parentId");
		if(parentId != null){
			parameters.put("parentId", parentId);
		}
		String parentIdIsNull = request.getParameter("parentIdIsNull");
		if(parentIdIsNull != null){
			parameters.put("parentIdIsNull", new Boolean(parentIdIsNull));
		}
		
		List<Module> dataList = moduleService.getList(parameters);
		return dataList;
	}	
	/**
	 * 获取模块
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/modules/{id}", method = RequestMethod.GET)
	public Module getModule(@PathVariable String id, HttpServletResponse response) throws IOException {		
		Module module = moduleService.get(id);
		return module;
	}
	/**
	 * 添加模块
	 * @param module
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/modules", method = RequestMethod.POST)
	public Module addModule(@RequestBody Module module, HttpServletResponse response) throws Exception {
		module = moduleService.add(module);
		return module;
	}
	
	/**
	 * 修改模块
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/modules/{id}", method = RequestMethod.PUT)
	public void updateModule(@PathVariable String id,@RequestBody Module module, HttpServletResponse response) throws IOException {
		module.setId(id);
		
		moduleService.update(module);
		
	}
	/**
	 * 删除模块
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/modules/{id}", method = RequestMethod.DELETE)
	public void deleteModule(@PathVariable String id, HttpServletResponse response){
		moduleService.delete(id);
	}
	
}
