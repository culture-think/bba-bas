/* <p>文件名称: WorkPlanServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月6日</p>
 * <p>完成日期：2018年8月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:24:03
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.ProjectDao;
import com.flynet.bas.dao.UserDao;
import com.flynet.bas.dao.WorkPlanDao;
import com.flynet.bas.dao.WorkPlanUserDao;
import com.flynet.bas.dao.WorkPlanVehicleDao;
import com.flynet.bas.exception.ErrorCodeDefinition;
import com.flynet.bas.exception.FlyNetException;
import com.flynet.bas.model.Project;
import com.flynet.bas.model.User;
import com.flynet.bas.model.WorkPlan;
import com.flynet.bas.model.WorkPlanUser;
import com.flynet.bas.model.WorkPlanVehicle;
import com.flynet.bas.security.IUserDetailsWrapper;
import com.flynet.bas.security.UserUtil;
import com.flynet.bas.service.WorkPlanService;
import com.flynet.bas.service.WorkPlanUserService;
import com.flynet.bas.service.WorkPlanVehicleService;

/**
 *
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class WorkPlanServiceImpl implements WorkPlanService {
	@Autowired
	private WorkPlanDao workPlanDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private WorkPlanUserDao workPlanUserDao;
	@Autowired
	private WorkPlanVehicleDao workPlanVehicleDao;
	
	@Autowired
	private WorkPlanUserService workPlanUserService;
	@Autowired
	private WorkPlanVehicleService workPlanVehicleService;
	
	@Override
	public WorkPlan get(String id) {
		//1、获取工作计划
		WorkPlan plan = workPlanDao.get(id);
		if(plan == null){
			return plan;
		}
		
		//2、设置项目
		Project project = projectDao.get(plan.getProjectId());
		plan.setProject(project);
		
		//3、设置用户列表
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("workPlanId", plan.getId());
		
		List<WorkPlanUser> users = workPlanUserService.getList(parameters);
		plan.setUsers(users);
		
		//4、设置车辆列表
		List<WorkPlanVehicle> vehicles = workPlanVehicleService.getList(parameters);
		plan.setVehicles(vehicles);
		
		//5、设置创建人
		if(plan.getCreatorId() != null){
			plan.setCreator(userDao.get(plan.getCreatorId()));
		}
		
		//6、设置最后修改人
		if(plan.getLastUpdateUserId() != null){
			plan.setLastUpdateUser(userDao.get(plan.getLastUpdateUserId()));
		}
		
		//7、返回
		return plan;
	}
	
	@Override
	public List<WorkPlan> getList(Map<String, Object> parameters) {
		//1、获取工作计划列表
		List<WorkPlan> workPlans = workPlanDao.getList(parameters);
		
		//2、设置项目信息
		Map<String, Project> projectMap = projectDao.getList(parameters).stream().collect(Collectors.toMap(Project::getId, entity -> entity, (k1, k2) -> k2));
		workPlans.stream().forEach(workPlan -> workPlan.setProject(projectMap.get(workPlan.getProjectId())));
		
		//3、设置创建人信息
		Map<String, User> userMap = userDao.getList(parameters).stream().collect(Collectors.toMap(User::getId, entity -> entity, (k1, k2) -> k2));
		workPlans.stream().filter(workPlan -> workPlan.getCreatorId() != null).forEach(workPlan -> workPlan.setCreator(userMap.get(workPlan.getCreatorId())));
		
		//4、设置最后修改人信息
		workPlans.stream().filter(workPlan -> workPlan.getLastUpdateUserId() != null).forEach(workPlan -> workPlan.setLastUpdateUser(userMap.get(workPlan.getLastUpdateUserId())));
		
		//5、设置用户列表
		parameters = new HashMap<String, Object>();
		Map<String, List<WorkPlanUser>> workPlanUsersMap = workPlanUserService.getList(parameters).stream().collect(Collectors.groupingBy(WorkPlanUser::getWorkPlanId));
		workPlans.stream().forEach(workPlan -> workPlan.setUsers(workPlanUsersMap.getOrDefault(workPlan.getId(), new ArrayList<WorkPlanUser>())));
		
		//6、设置车辆列表
		Map<String, List<WorkPlanVehicle>> workPlanVehiclesMap = workPlanVehicleService.getList(parameters).stream().collect(Collectors.groupingBy(WorkPlanVehicle::getWorkPlanId));
		workPlans.stream().forEach(workPlan -> workPlan.setVehicles(workPlanVehiclesMap.getOrDefault(workPlan.getId(), new ArrayList<WorkPlanVehicle>())));
		
		//7、返回结果
		return workPlans;
	}

	@Override
	public WorkPlan getByProjectId(String projectId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("projectId", projectId);
		
		WorkPlan plan = workPlanDao.getList(parameters).stream().findFirst().orElse(null);
		if(plan == null){
			return plan;
		}
		
		Project project = projectDao.get(projectId);
		plan.setProject(project);
		
		parameters.put("workPlanId", plan.getId());
		
		List<WorkPlanUser> users = workPlanUserDao.getList(parameters);
		plan.setUsers(users);
		
		List<WorkPlanVehicle> vehicles = workPlanVehicleDao.getList(parameters);
		plan.setVehicles(vehicles);
		
		return plan;
	}
	


	@Override
	public WorkPlan add(WorkPlan entity) throws FlyNetException{
		//1、前置条件判断
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("projectId", entity.getProjectId());
		
		if(!workPlanDao.getList(parameters).isEmpty()){
			throw new FlyNetException(ErrorCodeDefinition.WORK_PLAN_EXISTED, "");
		}
		
		//2、work-plan对象创建
		String workPlanId = UUID.randomUUID().toString().replaceAll("-", "");
		entity.setId(workPlanId);
		
		IUserDetailsWrapper currentUser = new UserUtil().getCurrentUser();
		if(currentUser != null){
			entity.setCreatorId(currentUser.getId());
		}
		entity.setCreateTime(new Date(System.currentTimeMillis()));
		
		//3、work-plan-user对象创建
		List<WorkPlanUser> users = entity.getUsers();
		if(users != null){
			users = new ArrayList<WorkPlanUser>();
		}
		
		users.stream().forEach(user -> {
			user.setWorkPlanId(workPlanId);
			user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		});
		
		//4、work-plan-vehicle对象创建
		List<WorkPlanVehicle> vehicles = entity.getVehicles();
		if(vehicles != null){
			vehicles = new ArrayList<WorkPlanVehicle>();
		}
		
		vehicles.stream().forEach(vehicle -> {
			vehicle.setWorkPlanId(workPlanId);
			vehicle.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		});
		
		//5、数据入库
		workPlanDao.add(entity);
		
		if(!users.isEmpty()){
			workPlanUserDao.addList(users);
		}
		
		if(!vehicles.isEmpty()){
			workPlanVehicleDao.addList(vehicles);
		}

		//6、返回结果
		return entity;
	}

	@Override
	public WorkPlan update(WorkPlan entity) throws FlyNetException{
		//1、前置条件判断
		String workPlanId = entity.getId();
		if(workPlanDao.get(workPlanId) == null){
			throw new FlyNetException(ErrorCodeDefinition.WORK_PLAN_NOT_EXISTED, "");
		}
		
		//2、work-plan对象修改
		IUserDetailsWrapper currentUser = new UserUtil().getCurrentUser();
		if(currentUser != null){
			entity.setLastUpdateUserId(currentUser.getId());
		}
		entity.setLastUpdateTime(new Date(System.currentTimeMillis()));
		
		//3、work-plan-user列表修改
		List<WorkPlanUser> users = entity.getUsers();
		if(users != null){
			users = new ArrayList<WorkPlanUser>();
		}
		
		users.stream().forEach(user -> {
			user.setWorkPlanId(workPlanId);
			user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		});
		
		//4、work-plan-vehicle对象创建
		List<WorkPlanVehicle> vehicles = entity.getVehicles();
		if(vehicles != null){
			vehicles = new ArrayList<WorkPlanVehicle>();
		}
		
		vehicles.stream().forEach(vehicle -> {
			vehicle.setWorkPlanId(workPlanId);
			vehicle.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		});
		
		//5、数据入库
		workPlanDao.update(entity);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("workPlanId", workPlanId);
		
		workPlanUserDao.delete(parameters);
		workPlanVehicleDao.delete(parameters);
		
		if(!users.isEmpty()){
			workPlanUserDao.addList(users);
		}
		
		if(!vehicles.isEmpty()){
			workPlanVehicleDao.addList(vehicles);
		}

		//6、返回结果
		return entity;
	}

	@Override
	public void delete(String id) throws FlyNetException{
		//1、删除用户
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("workPlanId", id);
		workPlanUserDao.delete(parameters);
		
		//2、删除车辆
		workPlanVehicleDao.delete(parameters);
		
		//3、删除工作计划
		workPlanDao.delete(id);
	}

}
