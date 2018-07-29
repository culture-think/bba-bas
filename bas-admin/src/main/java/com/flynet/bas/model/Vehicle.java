/* <p>文件名称: Vehicle.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年1月18日</p>
 * <p>完成日期：2018年1月18日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午2:08:49
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

/**
 * 车辆
 * @author zhanghuafeng
 */
public class Vehicle {
	/**
	 * ID
	 */
	private String id;
	/**
	 * Order
	 */
	private Integer order;
	/**
	 * Type
	 */
	private String type;
	
	/**
	 * Engine
	 */
    private String engine;
	/**
	 * Tire
	 */    
    private String tire;
	/**
	 * VIN
	 */
	private String vin;
	/**
	 * I-Level
	 */    
    private String iLevel;
    /**
     * 图片ID
     */
    private String pictureId;
	/**
	 * 
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 
	 */
	public String getEngine() {
		return engine;
	}
	/**
	 * 
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}
	/**
	 * 
	 */
	public String getTire() {
		return tire;
	}
	/**
	 * 
	 */
	public void setTire(String tire) {
		this.tire = tire;
	}
	/**
	 * 
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * 
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * 
	 */
	public String getiLevel() {
		return iLevel;
	}
	/**
	 * 
	 */
	public void setiLevel(String iLevel) {
		this.iLevel = iLevel;
	}
	/**
	 * 
	 */
	public String getPictureId() {
		return pictureId;
	}
	/**
	 * 
	 */
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	
}
