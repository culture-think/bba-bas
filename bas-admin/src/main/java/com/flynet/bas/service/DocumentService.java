/* <p>文件名称: DocumentService.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳龙天科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2016年8月25日</p>
 * <p>完成日期：2016年8月25日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午3:52:22
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.flynet.bas.model.Document;


/**
 * 文档服务
 * @author zhanghuafeng
 */
public interface DocumentService {
	/**
	 * 新增文档
	 * @param extendId
	 * @param category
	 * @param file
	 * @return
	 * @throws DocumentException 
	 */
	Document add(String category, MultipartFile file, String parentName) throws IOException;
	
	/**
	 * 新增文档
	 * @param extendId
	 * @param category
	 * @param type，文件类型：比如jpg，mp4
	 * @param base64Image
	 * @return
	 * @throws DocumentException 
	 */
	Document add(String extendId, String category,  String type, String base64Image, String parentName, String fileName) throws IOException;
	
	/**
	 * 新增文档列表
	 * @param extendId
	 * @param category
	 * @param fileNameList
	 * @return
	 * @throws DocumentException 
	 */
	List<Document> addList(String extendId, String category, Collection<String> fileNameList);
	
	/**
	 * 删除文档
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 删除文档列表
	 * @param parameters
	 */
	void deleteList(Map<String, Object> parameters);
}
