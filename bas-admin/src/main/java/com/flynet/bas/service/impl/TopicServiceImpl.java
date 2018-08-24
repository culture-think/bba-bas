/* <p>文件名称: TopicServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2017-2027</p>
 * <p>公    司: 沈阳网飞科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年8月16日</p>
 * <p>完成日期：2018年8月16日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：上午11:04:13
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

import com.flynet.bas.dao.TopicDao;
import com.flynet.bas.model.Topic;
import com.flynet.bas.service.TopicService;

/**
 *
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicDao topicDao;

	@Override
	public List<Topic> getList(Map<String, Object> parameters) {
		List<Topic> list = topicDao.getList(parameters);
		
		return list;
	}
	
	@Override
	public Topic add(Topic entity) {
		entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		
		topicDao.add(entity);
		return entity;
	}

	@Override
	public Topic update(Topic entity) {
		topicDao.update(entity);
		
		return entity;
	}

	@Override
	public List<Topic> updateList(List<Topic> list) {
		List<Topic> newList = list.stream().filter(topic -> topic.getId() == null).collect(Collectors.toList());
		newList.stream().forEach(topic -> topic.setId(UUID.randomUUID().toString().replaceAll("-", "")));
		topicDao.addList(newList);
		
		List<Topic> updateList = list.stream().filter(topic -> topic.getId() != null).collect(Collectors.toList());
		updateList.stream().forEach(topic -> topicDao.update(topic));
		
		newList.addAll(updateList);
		
		return newList;
	}

	@Override
	public void delete(String id) {
		topicDao.delete(id);
	}

}
