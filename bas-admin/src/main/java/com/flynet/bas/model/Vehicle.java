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
	 * VIN#
	 */
	private String vinCode;
	/**
	 * V#
	 */
	private String vCode;
	
	/**
	 * 
	 */
    private String edrMlogSn;
	/**
	 * 
	 */    
    private String edrWifiModuleSn;
	/**
	 * 
	 */    
    private String arcosSn;
	/**
	 * 
	 */    
    private String carOwner;
	/**
	 * 
	 */
    private String edrType;
	/**
	 * Arcos数据文件路径
	 */
	private String arcosFilePath;
	/**
	 * EDR数据文件路径
	 */
	private String edrFilePath;
	/**
	 * Arcos数据传输路径
	 */
	private String arcosTransmissionPath;
	/**
	 * EDR数据传输路径
	 */
	private String edrTransmissionPath;	
	/**
	 * Arcos数据备份路径
	 */
	private String arcosBackupPath;
	/**
	 * EDR数据备份路径
	 */
	private String edrBackupPath;	
	/**
	 * 车辆图片路径
	 */
	private String picName;
	/**
	 * 是否可用
	 */
	private Boolean available;
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
	public String getVinCode() {
		return vinCode;
	}
	/**
	 * 
	 */
	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}
	/**
	 * 
	 */
	public String getvCode() {
		return vCode;
	}
	/**
	 * 
	 */
	public void setvCode(String vCode) {
		this.vCode = vCode;
	}
	/**
	 * 
	 */
	public String getArcosFilePath() {
		return arcosFilePath;
	}
	/**
	 * 
	 */
	public void setArcosFilePath(String arcosFilePath) {
		this.arcosFilePath = arcosFilePath;
	}
	/**
	 * 
	 */
	public String getEdrFilePath() {
		return edrFilePath;
	}
	/**
	 * 
	 */
	public void setEdrFilePath(String edrFilePath) {
		this.edrFilePath = edrFilePath;
	}
	/**
	 * 
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * 
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	/**
	 * 
	 */
	public Boolean getAvailable() {
		return available;
	}
	/**
	 * 
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	/**
	 * 
	 */
	public String getEdrMlogSn() {
		return edrMlogSn;
	}
	/**
	 * 
	 */
	public void setEdrMlogSn(String edrMlogSn) {
		this.edrMlogSn = edrMlogSn;
	}
	/**
	 * 
	 */
	public String getEdrWifiModuleSn() {
		return edrWifiModuleSn;
	}
	/**
	 * 
	 */
	public void setEdrWifiModuleSn(String edrWifiModuleSn) {
		this.edrWifiModuleSn = edrWifiModuleSn;
	}
	/**
	 * 
	 */
	public String getArcosSn() {
		return arcosSn;
	}
	/**
	 * 
	 */
	public void setArcosSn(String arcosSn) {
		this.arcosSn = arcosSn;
	}
	/**
	 * 
	 */
	public String getCarOwner() {
		return carOwner;
	}
	/**
	 * 
	 */
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	/**
	 * 
	 */
	public String getEdrType() {
		return edrType;
	}
	/**
	 * 
	 */
	public void setEdrType(String edrType) {
		this.edrType = edrType;
	}
	/**
	 * 
	 */
	public String getArcosTransmissionPath() {
		return arcosTransmissionPath;
	}
	/**
	 * 
	 */
	public void setArcosTransmissionPath(String arcosTransmissionPath) {
		this.arcosTransmissionPath = arcosTransmissionPath;
	}
	/**
	 * 
	 */
	public String getEdrTransmissionPath() {
		return edrTransmissionPath;
	}
	/**
	 * 
	 */
	public void setEdrTransmissionPath(String edrTransmissionPath) {
		this.edrTransmissionPath = edrTransmissionPath;
	}
	/**
	 * 
	 */
	public String getArcosBackupPath() {
		return arcosBackupPath;
	}
	/**
	 * 
	 */
	public void setArcosBackupPath(String arcosBackupPath) {
		this.arcosBackupPath = arcosBackupPath;
	}
	/**
	 * 
	 */
	public String getEdrBackupPath() {
		return edrBackupPath;
	}
	/**
	 * 
	 */
	public void setEdrBackupPath(String edrBackupPath) {
		this.edrBackupPath = edrBackupPath;
	}
	
}
