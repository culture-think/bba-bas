/* <p>文件名称: UserServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月20日</p>
 * <p>完成日期：2017年2月20日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午1:19:34
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.UserDao;
import com.flynet.bas.exception.DesException;
import com.flynet.bas.model.User;
import com.flynet.bas.service.UserService;

/**
 * 用户服务实现
 * 
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getList(Map<String, Object> parameters) {
		List<User> userList = userDao.getUserList(parameters);

		return userList;
	}

	@Override
	public User getById(String id) {
		User user = userDao.getUser(id);

		return user;
	}

	@Override
	public User getByLoginName(String loginName) {
		User user = userDao.getUserByLoginName(loginName);

		return user;
	}

	@Override
	public User add(User user) throws DesException {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		user.setId(id);
		
//		IUserDetailsWrapper currentUser = new UserUtil().getCurrentUser();
//		user.setProjectId(currentUser.getProjectId());
		
		if(user.getDisplayName() == null){
			user.setDisplayName(user.getLoginName());
		}
		
		if(user.getPassword() == null){
			user.setPassword(user.getLoginName());
		}
		
		if(user.getType() == null){
			user.setType(2);//普通管理员，没有系统管理权限
		}

		userDao.addUser(user);

		return user;
	}

	@Override
	public void delete(String id) {
		userDao.deleteUser(id);
	}

	@Override
	public User update(User user) throws DesException {
		userDao.updateUser(user);

		return user;
	}

	@Override
	public void modifyPassword(User user) throws DesException {
		userDao.modifyPassword(user);

	}

}
