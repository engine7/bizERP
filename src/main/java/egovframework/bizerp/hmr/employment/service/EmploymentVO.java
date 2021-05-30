package egovframework.bizerp.hmr.employment.service;

/**
 * @Class Name : EmploymentVO.java
 * @Description : Employment VO class
 * @Modification Information
 *
 * @author 이성권
 * @since 2020-08-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class EmploymentVO extends EmploymentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** ROLE_TYPE_ID_FROM */
    private java.lang.String roleTypeIdFrom;
    
    /** ROLE_TYPE_ID_TO */
    private java.lang.String roleTypeIdTo;
    
    /** PARTY_ID_FROM */
    private java.lang.String partyIdFrom;
    
    /** PARTY_ID_TO */
    private java.lang.String partyIdTo;
    
    /** FROM_DATE */
    private java.util.Date fromDate;
    
    /** THRU_DATE */
    private java.util.Date thruDate;
    
    /** TERMINATION_REASON_ID */
    private java.lang.String terminationReasonId;
    
    /** TERMINATION_TYPE_ID */
    private java.lang.String terminationTypeId;
    
    /** LAST_UPDATED_STAMP */
    private java.util.Date lastUpdatedStamp;
    
    /** LAST_UPDATED_TX_STAMP */
    private java.util.Date lastUpdatedTxStamp;
    
    /** CREATED_STAMP */
    private java.util.Date createdStamp;
    
    /** CREATED_TX_STAMP */
    private java.util.Date createdTxStamp;
    
    public java.lang.String getRoleTypeIdFrom() {
        return this.roleTypeIdFrom;
    }
    
    public void setRoleTypeIdFrom(java.lang.String roleTypeIdFrom) {
        this.roleTypeIdFrom = roleTypeIdFrom;
    }
    
    public java.lang.String getRoleTypeIdTo() {
        return this.roleTypeIdTo;
    }
    
    public void setRoleTypeIdTo(java.lang.String roleTypeIdTo) {
        this.roleTypeIdTo = roleTypeIdTo;
    }
    
    public java.lang.String getPartyIdFrom() {
        return this.partyIdFrom;
    }
    
    public void setPartyIdFrom(java.lang.String partyIdFrom) {
        this.partyIdFrom = partyIdFrom;
    }
    
    public java.lang.String getPartyIdTo() {
        return this.partyIdTo;
    }
    
    public void setPartyIdTo(java.lang.String partyIdTo) {
        this.partyIdTo = partyIdTo;
    }
    
    public java.util.Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(java.util.Date fromDate) {
        this.fromDate = fromDate;
    }
    
    public java.util.Date getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(java.util.Date thruDate) {
        this.thruDate = thruDate;
    }
    
    public java.lang.String getTerminationReasonId() {
        return this.terminationReasonId;
    }
    
    public void setTerminationReasonId(java.lang.String terminationReasonId) {
        this.terminationReasonId = terminationReasonId;
    }
    
    public java.lang.String getTerminationTypeId() {
        return this.terminationTypeId;
    }
    
    public void setTerminationTypeId(java.lang.String terminationTypeId) {
        this.terminationTypeId = terminationTypeId;
    }
    
    public java.util.Date getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    
    public void setLastUpdatedStamp(java.util.Date lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }
    
    public java.util.Date getLastUpdatedTxStamp() {
        return this.lastUpdatedTxStamp;
    }
    
    public void setLastUpdatedTxStamp(java.util.Date lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }
    
    public java.util.Date getCreatedStamp() {
        return this.createdStamp;
    }
    
    public void setCreatedStamp(java.util.Date createdStamp) {
        this.createdStamp = createdStamp;
    }
    
    public java.util.Date getCreatedTxStamp() {
        return this.createdTxStamp;
    }
    
    public void setCreatedTxStamp(java.util.Date createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }
    
}
