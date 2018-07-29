/* <p>文件名称: Document.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2016年8月25日</p>
 * <p>完成日期：2016年8月25日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午4:01:29
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

import java.util.Date;

/**
 * 文档
 * @author zhanghuafeng
 */
public class Document {
	/**
	 * Id
	 */
	private String id;
	/**
	 * 父文档Id
	 */
	private String parentId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 文件url
	 */
	private String url;
	/**
	 * 文档分类
	 */
	private String category;
	/**
	 * 文档类型
	 */
	private String type;
	
	/**
	 * 扩展Id
	 */
	private String extendId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建用户Id
	 */
	private String createUserId;
	
	public Document(){
		
	}
	
	/**
	 * 浅拷贝
	 * @param document
	 */
	public Document(Document document){
		this.category = document.category;
		this.extendId = document.extendId;
		this.filePath = document.filePath;
		this.id = document.id;
		this.name = document.name;
		this.parentId = document.parentId;
		this.type = document.type;
		this.url = document.url;
	    this.createTime = document.createTime;
	    this.createUserId = document.createUserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExtendId() {
		return extendId;
	}

	public void setExtendId(String extendId) {
		this.extendId = extendId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Override
	public int hashCode() {
		if(this.id == null){
			return 0;
		}
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Document == false){
			return false;
		}
		
		Document theDocument = (Document) obj;
		if(this.id == null || theDocument.id == null){
			return false;
		}
		
		
		return this.id.equals(theDocument.id);
	}
	
	
}
