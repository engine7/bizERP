package egovframework.bizerp.hmr.employees.service;

/**
 * @Class Name : EmployeesVO.java
 * @Description : Employees VO class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class EmployeesVO extends EmployeesDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** PARTY_ID */
    private java.lang.String partyId;
    
    /** PARTY_TYPE_ID */
    private java.lang.String partyTypeId;
    
    /** EXTERNAL_ID */
    private java.lang.String externalId;
    
    /** PREFERRED_CURRENCY_UOM_ID */
    private java.lang.String preferredCurrencyUomId;
    
    /** DESCRIPTION */
    private java.lang.String description;
    
    /** STATUS_ID */
    private java.lang.String statusId;
    
    /** CREATED_DATE */
    private java.util.Date createdDate;
    
    /** CREATED_BY_USER_LOGIN */
    private java.lang.String createdByUserLogin;
    
    /** LAST_MODIFIED_DATE */
    private java.util.Date lastModifiedDate;
    
    /** LAST_MODIFIED_BY_USER_LOGIN */
    private java.lang.String lastModifiedByUserLogin;
    
    /** DATA_SOURCE_ID */
    private java.lang.String dataSourceId;
    
    /** IS_UNREAD */
    private java.lang.String isUnread;
    
    /** LAST_UPDATED_STAMP */
    private java.util.Date lastUpdatedStamp;
    
    /** LAST_UPDATED_TX_STAMP */
    private java.util.Date lastUpdatedTxStamp;
    
    /** CREATED_STAMP */
    private java.util.Date createdStamp;
    
    /** CREATED_TX_STAMP */
    private java.util.Date createdTxStamp;

	public java.lang.String getPartyId() {
		return partyId;
	}

	public void setPartyId(java.lang.String partyId) {
		this.partyId = partyId;
	}

	public java.lang.String getPartyTypeId() {
		return partyTypeId;
	}

	public void setPartyTypeId(java.lang.String partyTypeId) {
		this.partyTypeId = partyTypeId;
	}

	public java.lang.String getExternalId() {
		return externalId;
	}

	public void setExternalId(java.lang.String externalId) {
		this.externalId = externalId;
	}

	public java.lang.String getPreferredCurrencyUomId() {
		return preferredCurrencyUomId;
	}

	public void setPreferredCurrencyUomId(java.lang.String preferredCurrencyUomId) {
		this.preferredCurrencyUomId = preferredCurrencyUomId;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getStatusId() {
		return statusId;
	}

	public void setStatusId(java.lang.String statusId) {
		this.statusId = statusId;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.lang.String getCreatedByUserLogin() {
		return createdByUserLogin;
	}

	public void setCreatedByUserLogin(java.lang.String createdByUserLogin) {
		this.createdByUserLogin = createdByUserLogin;
	}

	public java.util.Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public java.lang.String getLastModifiedByUserLogin() {
		return lastModifiedByUserLogin;
	}

	public void setLastModifiedByUserLogin(java.lang.String lastModifiedByUserLogin) {
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
	}

	public java.lang.String getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(java.lang.String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public java.lang.String getIsUnread() {
		return isUnread;
	}

	public void setIsUnread(java.lang.String isUnread) {
		this.isUnread = isUnread;
	}

	public java.util.Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(java.util.Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	public java.util.Date getLastUpdatedTxStamp() {
		return lastUpdatedTxStamp;
	}

	public void setLastUpdatedTxStamp(java.util.Date lastUpdatedTxStamp) {
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
	}

	public java.util.Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(java.util.Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public java.util.Date getCreatedTxStamp() {
		return createdTxStamp;
	}

	public void setCreatedTxStamp(java.util.Date createdTxStamp) {
		this.createdTxStamp = createdTxStamp;
	}
}
