/* <p>文件名称: UserService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月20日</p>
 * <p>完成日期：2017年2月20日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:41:44
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service;

import java.util.List;
import java.util.Map;

import com.flynet.bas.exception.FlyNetException;
import com.flynet.bas.model.User;


/**
 * 用户服务
 * @author zhanghuafeng
 */
public interface UserService {
	/**
	 * 管理员用户类型
	 */
	int ADMIN_USER_TYPE = 1;
	/**
	 * 普通用户类型
	 */
	int NORMAL_USER_TYPE = 2;
	/**
	 * 获取用户列表
	 * @param parameters
	 * @return
	 */
	List<User> getList(Map<String, Object> parameters);
	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	User getById(String id);
	
	/**
	 * 获取用户
	 * @param loginName
	 * @return
	 */
	User getByLoginName(String loginName);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	User add(User user) throws FlyNetException;
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	User update(User user) throws FlyNetException;
	
	/**
	 * 修改密码
	 * @param user
	 * @throws FlyNetException
	 */
	void modifyPassword(User user) throws FlyNetException;
}
