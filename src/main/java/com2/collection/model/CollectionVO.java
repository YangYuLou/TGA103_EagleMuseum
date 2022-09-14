package com2.collection.model;

import java.sql.Date;

public class CollectionVO implements java.io.Serializable{
	private Integer collectionID;
	private String collectionText;
	private String collectionMaterial;
	private Date lastUpdateTime;
	private Boolean collectionStatus;
	
	
	public Integer getCollectionID() {
		return collectionID;
	}
	public void setCollectionID(Integer collectionID) {
		this.collectionID = collectionID;
	}
	public String getCollectionText() {
		return collectionText;
	}
	public void setCollectionText(String collectionText) {
		this.collectionText = collectionText;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Boolean getCollectionStatus() {
		return collectionStatus;
	}
	public void setCollectionStatus(Boolean collectionStatus) {
		this.collectionStatus = collectionStatus;
	}
	public String getCollectionMaterial() {
		return collectionMaterial;
	}
	public void setCollectionMaterial(String collectionMaterial) {
		this.collectionMaterial = collectionMaterial;
	}
}
	
	