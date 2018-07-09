/* <p>文件名称: ErrorCodeDefinition.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月24日</p>
 * <p>完成日期：2017年2月24日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午3:03:58
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.exception;

/**
 * 错误码定义
 * @author zhanghuafeng
 */
public interface ErrorCodeDefinition {
	/**
	 * 用户名已经存在
	 */
	int USER_LOGGIN_NAME_ALREADY_EXISTS = 420;
	/**
	 * 邮箱已经存在
	 */
	int USER_EMAIL_ALREADY_EXISTS = 421;
	/**
	 * 电话号码已经存在
	 */
	int USER_PHONE_NUMBER_ALREADY_EXISTS = 422;
	/**
	 * 密码错误
	 */
	int USER_PASSWORD_WRONG = 423;
	
}
