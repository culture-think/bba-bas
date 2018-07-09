/* <p>文件名称: UserUtil.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年3月1日</p>
 * <p>完成日期：2017年3月1日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:27:35
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.security;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 用户工具类
 * @author zhanghuafeng
 */
public class UserUtil {
	public IUserDetailsWrapper getCurrentUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null){
			return null;
		}
		
		Object principal = authentication.getPrincipal();
		if(principal instanceof IUserDetailsWrapper){
			IUserDetailsWrapper userDetails = (IUserDetailsWrapper) principal;
			
			return userDetails;
		}
		
		if(principal instanceof Map<?, ?> == false){
			return null;
		}
		
		@SuppressWarnings("unchecked")
		Map<String, Object> userMap = (Map<String, Object>) principal;
		
		IUserDetailsWrapper userDetails = new IUserDetailsWrapper(){

			@Override
			public String getId() {
				return (String) userMap.get("id");
			}

			@Override
			public String getLoginName() {
				return (String) userMap.get("loginName");
			}

			@Override
			public String getDisplayName() {
				return (String) userMap.get("displayName");
			}

			@Override
			public String getEmail() {
				return (String) userMap.get("email");
			}

			@Override
			public String getPhoneNumber() {
				return (String) userMap.get("phoneNumber");
			}

			@Override
			public Integer getType() {
				return (Integer) userMap.get("type");
			}

			@Override
			public String getProjectId() {
				// TODO Auto-generated method stub
				return (String) userMap.get("plantId");
			}
			
		};
		
		return userDetails;
	}
}
