/* <p>文件名称: User.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
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

/**
 * 用户
 *
 * @author zhanghuafeng
 */
public class User {
	/**
	 * 用户ID
	 */
    private String id;
    /**
     * 用户登录名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 类型：1管理员，2普通用户
     */
    private Integer type;
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
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 
	 */
	public void setType(Integer type) {
		this.type = type;
	}

}