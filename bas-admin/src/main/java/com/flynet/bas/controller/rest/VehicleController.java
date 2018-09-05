package com.flynet.bas.controller.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flynet.bas.model.Document;
import com.flynet.bas.model.Vehicle;
import com.flynet.bas.service.DocumentService;
import com.flynet.bas.service.VehicleService;

/**
 * 车辆控制器
 * @author zhanghuafeng
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/api")
public class VehicleController {
	@Autowired(required = false)
	private VehicleService vehicleService;
	@Autowired(required = false)
	private DocumentService documentService;
	/**
	 * 获取车辆列表
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public List<Vehicle> getVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String projectId = request.getParameter("projectId");
		if(projectId != null){
			parameters.put("projectId", projectId);
		}
		
		List<Vehicle> dataList = vehicleService.getList(parameters);
		return dataList;
	}	
	/**
	 * 获取车辆
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
	public Vehicle getVehicle(@PathVariable String id, HttpServletResponse response) throws IOException {		
		Vehicle vehicle = vehicleService.get(id);
		return vehicle;
	}
	/**
	 * 添加车辆
	 * @param vehicle
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/vehicles", method = RequestMethod.POST)
	public Vehicle addVehicle(@RequestBody Vehicle vehicle, HttpServletResponse response) throws Exception {
		vehicle = vehicleService.add(vehicle);
		return vehicle;
	}
	
	/**
	 * 修改车辆
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.PUT)
	public void updateVehicle(@PathVariable String id,@RequestBody Vehicle vehicle, HttpServletResponse response) throws IOException {
		vehicle.setId(id);
		
		vehicleService.update(vehicle);
		
	}
	/**
	 * 删除车辆
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable String id, HttpServletResponse response){
		vehicleService.delete(id);
	}
	@RequestMapping(value = "/vehicles/upload-picture", method = RequestMethod.POST)
	public Document importVariant(final MultipartFile file, String projectName) throws Exception {
		Document document = documentService.add("vehicle.picture", file, null);
		return document;
		
	}
}
