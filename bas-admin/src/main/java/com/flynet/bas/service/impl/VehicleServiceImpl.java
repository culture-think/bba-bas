/* <p>文件名称: VehicleServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年1月21日</p>
 * <p>完成日期：2018年1月21日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午9:55:54
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.VehicleDao;
import com.flynet.bas.model.Vehicle;
import com.flynet.bas.service.VehicleService;
import com.flynet.bas.util.ImportExcelUtil;

/**
 * 车辆信息服务
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public List<Vehicle> getList(Map<String, Object> parameters) {
		List<Vehicle> list = vehicleDao.getList(parameters);
		
		return list;
	}

	@Override
	public Vehicle get(String id) {
		Vehicle entity = vehicleDao.get(id);
		
		return entity;
	}

	@Override
	public Vehicle add(Vehicle entity) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		entity.setId(id);
	
		vehicleDao.add(entity);
		
		return entity;
	}

	@Override
	public Vehicle update(Vehicle entity) {
		vehicleDao.update(entity);
		
		return entity;
	}

	@Override
	public void delete(String id) {
		vehicleDao.delete(id);
	}

	@Override
	public void upload(InputStream inputStream, String fileName) throws Exception {
		//1、读取excel数据
		List<List<Object>> newList  = new ImportExcelUtil().getBankListByExcel(inputStream, fileName);
		
		if(newList.isEmpty()){
			return;
		}
		
		//2、数据转换：添加车辆
		Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();
		List<Vehicle> vehicleList = vehicleDao.getList(new HashMap<String, Object>());
		for(Vehicle vehicle : vehicleList){
			vehicleMap.put(vehicle.getVinCode(), vehicle);
		}
		
		Vehicle vehicle = null;
		String vinCode = null;
		for(List<Object> list : newList){
			if(list.size() < 2){
				continue;
			}		
			vinCode = list.get(1).toString();
			if(vehicleMap.containsKey(vinCode)){
				continue;
			}	
			
			if(vinCode == null || vinCode.trim().isEmpty()){
				continue;
			}
			vehicle = new Vehicle();
			vehicle.setVinCode(vinCode);
			
			vehicle.setvCode(list.get(2).toString());
			vehicle.setEdrMlogSn(list.get(3).toString());
			vehicle.setEdrWifiModuleSn(list.get(4).toString());
			vehicle.setArcosSn(list.get(5).toString());
			vehicle.setCarOwner(list.get(6).toString());
			vehicle.setEdrType(list.get(7).toString());
			vehicle.setEdrFilePath(list.get(8).toString());
			vehicle.setArcosFilePath(list.get(9).toString());

			vehicle.setEdrTransmissionPath(list.get(10).toString());
			vehicle.setArcosTransmissionPath(list.get(11).toString());
			vehicle.setEdrBackupPath(list.get(12).toString());
			vehicle.setArcosBackupPath(list.get(13).toString());
			
			vehicle.setPicName(list.get(14).toString());
			
			vehicle.setAvailable(list.get(15).toString().trim().equals("y"));
			
			this.add(vehicle);
		}
	}

}
