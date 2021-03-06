/* <p>文件名称: ProjectServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年7月29日</p>
 * <p>完成日期：2018年7月29日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午3:13:16
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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flynet.bas.dao.DocumentDao;
import com.flynet.bas.dao.ProjectDao;
import com.flynet.bas.model.Document;
import com.flynet.bas.model.Project;
import com.flynet.bas.service.ProjectService;

/**
 * 项目服务实现
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private DocumentDao documentDao;
	
	private String projectPictureCategory = "project.picture";
	
	@Override
	public List<Project> getList(Map<String, Object> parameters) {
		List<Project> list = projectDao.getList(parameters);
		
		parameters.clear();
		parameters.put("category", projectPictureCategory);
		Map<String, Document> documentMap = documentDao.getList(parameters).stream().collect(Collectors.toMap(Document::getId, entity -> entity, (k1, k2) -> k2));
		
		list.forEach(project -> {
			if(project.getPictureId() != null){
				project.setPictureDocument(documentMap.get(project.getPictureId()));
			}
		});
		return list;
	}

	@Override
	public Project get(String id) {
		Project entity = projectDao.get(id);
		
		if(entity.getPictureId() != null){
			entity.setPictureDocument(documentDao.get(entity.getPictureId()));
		}
		
		return entity;
	}

	@Override
	public Project add(Project entity) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		entity.setId(id);
		
		projectDao.add(entity);
		
		return entity;
	}

	@Override
	public void delete(String id) {
		projectDao.delete(id);
	}

	@Override
	public Project update(Project entity) {
		projectDao.update(entity);
		return entity;
	}
}
