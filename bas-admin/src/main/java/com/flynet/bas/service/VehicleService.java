/* <p>文件名称: VehicleService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳龙天科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2016年12月4日</p>
 * <p>完成日期：2016年12月4日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午7:11:54
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.flynet.bas.model.Vehicle;

/**
 * 车辆服务
 * @author zhanghuafeng
 */
public interface VehicleService {
	/**
	 * 获取车辆数据列表
	 * @param parameters
	 */
	List<Vehicle> getList(Map<String, Object> parameters);
	
	/**
	 * 获取车辆信息
	 * @param id
	 * @return
	 */
	Vehicle get(String id);
	
	/**
	 * 添加车辆信息
	 * @param entity
	 * @return
	 */
	Vehicle add(Vehicle entity);
	
	/**
	 * 修改车辆信息
	 * @param entity
	 * @return
	 */
	Vehicle update(Vehicle entity);
	
	/**
	 * 删除车辆信息
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 导入车辆信息
	 * @param inputStream
	 * @param fileName
	 * @throws Exception
	 */
	void upload(InputStream inputStream, String fileName) throws Exception;
}
