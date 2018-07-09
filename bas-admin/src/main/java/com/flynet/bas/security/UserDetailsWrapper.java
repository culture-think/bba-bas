/* <p>文件名称: UserDetailsWrapper.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年2月26日</p>
 * <p>完成日期：2017年2月26日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午7:39:50
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.flynet.bas.model.User;

/**
 * 用户信息包装类
 * @author zhanghuafeng
 */
public class UserDetailsWrapper implements UserDetails, IUserDetailsWrapper {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserDetailsWrapper(User user){
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();	
		
		//Admin权限
		if(user.getType() == 1/**User.ADMIN**/){
			authorityList.add(new GrantedAuthorityImpl("ADMIN"));
		}
		
		return authorityList;
	}


	@Override
	public String getPassword() {
		if(user == null){
			return "";
		}
		
		return user.getPassword();
	}


	@Override
	public String getUsername() {
		return user.getLoginName();
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getId(){
		return this.user.getId();
	}
	
	public String getDisplayName(){
		return this.user.getDisplayName();
	}
	
	public User getUser(){
		User theUser = new User();
		
		theUser.setDisplayName(this.user.getDisplayName());
		theUser.setEmail(this.user.getEmail());
		theUser.setId(this.user.getId());
		theUser.setLoginName(this.user.getLoginName());
		theUser.setPhoneNumber(this.user.getPhoneNumber());
		theUser.setType(this.user.getType());
		theUser.setProjectId(this.user.getProjectId());
		
		//密码字段处理为null，不向外界暴露
		theUser.setPassword(null);
		
		return theUser;
	}

	@Override
	public String getEmail() {
		return this.user.getEmail();
	}

	@Override
	public String getLoginName() {
		return this.user.getLoginName();
	}

	@Override
	public String getPhoneNumber() {
		return this.user.getPhoneNumber();
	}

	@Override
	public Integer getType() {
		return this.user.getType();
	}

	@Override
	public String getProjectId() {
		return this.user.getProjectId();
	}

}
