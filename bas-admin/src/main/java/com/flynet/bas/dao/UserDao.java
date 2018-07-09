/* <p>文件名称: UserDao.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月20日</p>
 * <p>完成日期：2017年2月20日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:58:14
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.flynet.bas.model.User;

/**
 * 用户Dao
 * @author zhanghuafeng
 */
@Mapper
public interface UserDao {
	/**
	 * 获取用户列表
	 * @param paras
	 * @return
	 */
	List<User> getUserList(Map<String, Object> parameters);
	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	User getUser(String id);
	
	/**
	 * 获取用户
	 * @param loginName
	 * @return
	 */
	User getUserByLoginName(String loginName);
	
	
	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(String id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 修改密码
	 * @param user
	 */
	void modifyPassword(User user);
}
