/* <p>文件名称: DocumentDao.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳龙天科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2016年8月26日</p>
 * <p>完成日期：2016年8月26日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午9:35:05
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

import com.flynet.bas.model.Document;

/**
 * 文档DAO
 * @author zhanghuafeng
 */
@Mapper
public interface DocumentDao {
	/**
	 * 新增文档
	 * @param document
	 */
	void add(Document document);
	
	/**
	 * 新增文档列表
	 * @param documents
	 */
	void addList(List<Document> documents);

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
	
	/**
	 * 获取文档
	 * @param id
	 * @return
	 */
	Document get(String id);
	
	/**
	 * 获取文档列表
	 * @param parameters
	 * @return
	 */
	List<Document> getList(Map<String, Object> parameters);
	
}
