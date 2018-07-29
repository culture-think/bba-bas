/* <p>文件名称: Module.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年1月11日</p>
 * <p>完成日期：2018年1月11日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午7:59:42
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.model;

import java.util.List;

/**
 * 模块
 * @author zhanghuafeng
 */
public class Module {
	public static int APPLICATION = 1;//应用
	public static int GROUP = 2;//分组
	public static int MODULE = 4;//模块
	/**
	 * Id
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 父模块Id
	 */
	private String parentId;
	/**
	 * 类型：默认模块
	 */
	private int type = MODULE;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * url
	 */
	private String url;
	/**
	 * 序号
	 */
	private int index;
	/**
	 * 父模块
	 */
	private Module parent;
	/**
	 * 子模块
	 */
	private List<Module> children;
	
	public Module(){
		
	}
	
	public Module(Module module){
		this.id = module.id;
		this.name = module.name;
		this.parentId = module.parentId;
		this.type = module.type;
		this.icon = module.icon;
		this.url = module.url;
		this.index = module.index;
	}
	
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
	public String getName() {
		return name;
	}
	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 
	 */
	public int getType() {
		return type;
	}
	/**
	 * 
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * 
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * 
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * 
	 */
	public Module getParent() {
		return parent;
	}
	/**
	 * 
	 */
	public void setParent(Module parent) {
		this.parent = parent;
	}
	/**
	 * 
	 */
	public List<Module> getChildren() {
		return children;
	}
	/**
	 * 
	 */
	public void setChildren(List<Module> children) {
		this.children = children;
	}
}
