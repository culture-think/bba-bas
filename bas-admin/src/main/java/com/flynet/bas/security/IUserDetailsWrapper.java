/* <p>文件名称: IUser.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月27日</p>
 * <p>完成日期：2017年2月27日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午1:39:48
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.security;

/**
 * 用户详细信息封装器接口
 * @author zhanghuafeng
 */
public interface IUserDetailsWrapper {
	/**
	 * 用户ID
	 * @return
	 */
	String getId();

	/**
	 * 用户登录名称
	 * @return
	 */
	String getLoginName();


	/**
	 * 用户显示名称
	 * @return
	 */
	String getDisplayName();

	/**
	 * 用户电子邮箱
	 * @return
	 */
	String getEmail();

	/**
	 * 用户手机号码
	 * @return
	 */
	String getPhoneNumber();

	/**
	 * 用户类型
	 * @return
	 */
	Integer getType();
	
	/**
	 *  工厂ID
	 * @return
	 */
	String getProjectId();
}