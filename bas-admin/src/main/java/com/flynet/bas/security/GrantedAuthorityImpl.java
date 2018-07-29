/* <p>文件名称: GrantedAuthorityImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年6月17日</p>
 * <p>完成日期：2017年6月17日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午9:09:50
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.security;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author zhanghuafeng
 */
public class GrantedAuthorityImpl implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	/**
	 * 权限
	 */
    private String authority;
    
    public GrantedAuthorityImpl(String authority){
    	this.authority = authority;
    }
    
	@Override
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
