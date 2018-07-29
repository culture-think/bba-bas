/* <p>文件名称: WebController.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年5月30日</p>
 * <p>完成日期：2017年5月30日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午2:03:56
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author zhanghuafeng
 */
@Controller
public class WebController {
	@RequestMapping(value = "/")
	public String home() {
		return "main";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/vehicle")
	public String vehicle() {
		return "vehicle/main";
	}
	
	@RequestMapping(value = "/report")
	public String report() {
		return "report/main";
	}

	@RequestMapping(value = "/history")
	public String history() {
		return "history/main";
	}
	
	@RequestMapping(value = "/transmission")
	public String transmission() {
		return "transmission/main";
	}
}
