/* <p>文件名称: DocumentServiceImpl.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年2月6日</p>
 * <p>完成日期：2018年2月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午2:31:54
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.flynet.bas.dao.DocumentDao;
import com.flynet.bas.model.Document;
import com.flynet.bas.security.IUserDetailsWrapper;
import com.flynet.bas.security.UserUtil;
import com.flynet.bas.service.DocumentService;
import com.flynet.bas.util.Base64Util;

/**
 *
 * @author zhanghuafeng
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private Environment env;

	@Autowired
	private DocumentDao documentDao;

	@Override
	public Document add(String category, MultipartFile multipartFile, String parentName)
			throws IOException {
		// 1、保存文件
		String documentId = UUID.randomUUID().toString().replaceAll("-", "");

		StringBuffer directory = new StringBuffer().append(env.getProperty("webapp.resources-path")).append("documents")
				.append(File.separator);

		String fileName = multipartFile.getOriginalFilename();
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);

		String filePath = directory + documentId + "." + type;

		File file = new File(filePath);
		multipartFile.transferTo(file);

		Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
		Matcher matcher = pattern.matcher(fileName);
		fileName = matcher.replaceAll("");

		// 2、创建文档
		Document document = new Document();
		document.setId(documentId);

		document.setCategory(category);
		document.setType(type);

		document.setCreateTime(new Date());
		IUserDetailsWrapper user = new UserUtil().getCurrentUser();
		if (user != null) {
			document.setCreateUserId(user.getId());
		}

		document.setName(fileName);
		document.setFilePath(filePath);

		document.setUrl("/documents/" + documentId + "." + type);
		documentDao.add(document);

		// 3、返回结果
		return document;
	}

	@Override
	public Document add(String extendId, String category, String type, String base64Image, String parentName,
			String _fileName) throws IOException {
		// 1、保存文件
		String documentId = UUID.randomUUID().toString().replaceAll("-", "");

		StringBuffer directory = new StringBuffer().append(env.getProperty("webapp.resources-path")).append("documents")
				.append(File.separator);

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);

		String fileName = documentId + "." + type;

		String filePath = directory + documentId + "." + type;

		Base64Util.convert2File(base64Image, filePath);
		Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
		Matcher matcher = pattern.matcher(_fileName);
		_fileName = matcher.replaceAll("");

		// 2、创建文档
		Document document = new Document();
		document.setId(documentId);

		document.setExtendId(extendId);
		document.setCategory(category);
		document.setType(type);

		document.setCreateTime(new Date());
		IUserDetailsWrapper user = new UserUtil().getCurrentUser();
		if (user != null) {
			document.setCreateUserId(user.getId());
		}

		document.setName(fileName);
		document.setFilePath(filePath);

		document.setUrl("/documents/" + documentId + "." + type);
		documentDao.add(document);

		// 3、返回结果
		return document;
	}

	@Override
	public List<Document> addList(String extendId, String category, Collection<String> fileNameList) {
		// 1、构造目录
		StringBuffer directory = new StringBuffer().append(env.getProperty("webapp.resources-path")).append("documents")
				.append(File.separator);

		String createUserId = null;
		IUserDetailsWrapper user = new UserUtil().getCurrentUser();
		if (user != null) {
			createUserId = user.getId();
		}

		// 2、创建文档列表
		List<Document> documentList = new ArrayList<Document>();
		for (String fileName : fileNameList) {
			String documentId = UUID.randomUUID().toString().replaceAll("-", "");
			String type = fileName.substring(fileName.lastIndexOf(".") + 1);

			Document document = new Document();
			document.setId(documentId);

			document.setExtendId(extendId);
			document.setCategory(category);
			document.setType(type);

			document.setCreateTime(new Date());
			document.setCreateUserId(createUserId);

			document.setName(fileName);
			document.setFilePath(directory + documentId + "." + type);

			document.setUrl("/documents/" + documentId + "." + type);

			documentList.add(document);
		}

		documentDao.addList(documentList);

		// 3、返回结果
		return documentList;
	}

	@Override
	public void delete(String id) {
		Document document = documentDao.get(id);
		if (document == null) {
			return;
		}
		File file = new File(document.getFilePath());
		if (file.exists()) {
			file.delete();
		}

		documentDao.delete(id);
	}

	@Override
	public void deleteList(Map<String, Object> parameters) {
		List<Document> list = documentDao.getList(parameters);

		for (Document document : list) {
			File file = new File(document.getFilePath());
			if (file.exists()) {
				file.delete();
			}

			documentDao.delete(document.getId());
		}
	}
}
