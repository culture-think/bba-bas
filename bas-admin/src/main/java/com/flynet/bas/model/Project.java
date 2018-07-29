package com.flynet.bas.model;

/**
 * 项目
 *
 * @author zhanghuafeng
 */
public class Project {
	/**
	 * 项目ID
	 */
    private String id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目图片ID
     */
    private String pictureId;
    /**
     * 项目图片
     */
    private Document pictureDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

	/**
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String getPictureId() {
		return pictureId;
	}

	/**
	 * 
	 */
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	/**
	 * 
	 */
	public Document getPictureDocument() {
		return pictureDocument;
	}

	/**
	 * 
	 */
	public void setPictureDocument(Document pictureDocument) {
		this.pictureDocument = pictureDocument;
	}

}