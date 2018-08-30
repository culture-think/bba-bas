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

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.DocumentDao;
import com.flynet.bas.dao.VehicleDao;
import com.flynet.bas.model.Document;
import com.flynet.bas.model.Vehicle;
import com.flynet.bas.service.VehicleService;

/**
 * 车辆信息服务
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private DocumentDao documentDao;
	
	private String vehiclePictureCategory = "vehicle.picture";
	
	@Override
	public List<Vehicle> getList(Map<String, Object> parameters) {
		List<Vehicle> list = vehicleDao.getList(parameters);
		
		parameters.clear();
		parameters.put("category", vehiclePictureCategory);
		Map<String, Document> documentMap = documentDao.getList(parameters).stream().collect(Collectors.toMap(Document::getId, entity -> entity, (k1, k2) -> k2));
		
		list.forEach(Vehicle -> {
			if(Vehicle.getPictureId() != null){
				Vehicle.setPictureDocument(documentMap.get(Vehicle.getPictureId()));
			}
		});
		
		return list;
	}

	@Override
	public Vehicle get(String id) {
		Vehicle entity = vehicleDao.get(id);
		if(entity.getPictureId() != null){
			entity.setPictureDocument(documentDao.get(entity.getPictureId()));
		}
		
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
}
