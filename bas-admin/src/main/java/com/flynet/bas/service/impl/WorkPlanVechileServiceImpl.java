/* <p>文件名称: WorkPlanVehicleServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午4:33:11
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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.UserDao;
import com.flynet.bas.dao.VehicleDao;
import com.flynet.bas.dao.VehicleSelectionDao;
import com.flynet.bas.dao.WorkPlanVehicleDao;
import com.flynet.bas.model.User;
import com.flynet.bas.model.Vehicle;
import com.flynet.bas.model.VehicleSelection;
import com.flynet.bas.model.WorkPlanVehicle;
import com.flynet.bas.service.WorkPlanVehicleService;

/**
 *
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class WorkPlanVechileServiceImpl implements WorkPlanVehicleService {
	@Autowired
	private WorkPlanVehicleDao workPlanVehicleDao;
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private VehicleSelectionDao selectionDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<WorkPlanVehicle> getList(Map<String, Object> parameters) {
		//1、获取工作计划车辆列表
		List<WorkPlanVehicle> list = workPlanVehicleDao.getList(parameters);
		if(list.isEmpty()){
			return list;
		}
		
		//2、设置车辆
		parameters = new HashMap<String, Object>();
		Map<String, Vehicle> vehicleMap = vehicleDao.getList(parameters).stream().collect(Collectors.toMap(Vehicle::getId, entity -> entity, (k1, k2) -> k2));
		Map<String, VehicleSelection> selectionMap = selectionDao.getList(parameters).stream().collect(Collectors.toMap(VehicleSelection::getKey, entity -> entity, (k1, k2) -> k2));
		Map<String, User> userMap = userDao.getList(parameters).stream().collect(Collectors.toMap(User::getId, entity -> entity, (k1, k2) -> k2));
		
		list.forEach(workPlanVehicle -> {
			workPlanVehicle.setVehicle(vehicleMap.get(workPlanVehicle.getVehicleId()));
			
			VehicleSelection selection = selectionMap.get(workPlanVehicle.getId() + workPlanVehicle.getVehicleId());
			workPlanVehicle.setSelection(selection);
			
			if(selection != null && selection.getTesterId() != null){
				selection.setTester(userMap.get(selection.getTesterId()));
			}
		});
		
		//3、返回结果
		return list;
	}

}
