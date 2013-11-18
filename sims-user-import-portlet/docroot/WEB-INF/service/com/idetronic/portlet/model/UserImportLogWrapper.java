/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserImportLog}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       UserImportLog
 * @generated
 */
public class UserImportLogWrapper implements UserImportLog,
	ModelWrapper<UserImportLog> {
	public UserImportLogWrapper(UserImportLog userImportLog) {
		_userImportLog = userImportLog;
	}

	public Class<?> getModelClass() {
		return UserImportLog.class;
	}

	public String getModelClassName() {
		return UserImportLog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("totalProcess", getTotalProcess());
		attributes.put("totalImport", getTotalImport());
		attributes.put("totalError", getTotalError());
		attributes.put("summary", getSummary());
		attributes.put("createDate", getCreateDate());
		attributes.put("totalExisting", getTotalExisting());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long totalProcess = (Long)attributes.get("totalProcess");

		if (totalProcess != null) {
			setTotalProcess(totalProcess);
		}

		Long totalImport = (Long)attributes.get("totalImport");

		if (totalImport != null) {
			setTotalImport(totalImport);
		}

		Long totalError = (Long)attributes.get("totalError");

		if (totalError != null) {
			setTotalError(totalError);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long totalExisting = (Long)attributes.get("totalExisting");

		if (totalExisting != null) {
			setTotalExisting(totalExisting);
		}
	}

	/**
	* Returns the primary key of this user import log.
	*
	* @return the primary key of this user import log
	*/
	public long getPrimaryKey() {
		return _userImportLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user import log.
	*
	* @param primaryKey the primary key of this user import log
	*/
	public void setPrimaryKey(long primaryKey) {
		_userImportLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this user import log.
	*
	* @return the entry ID of this user import log
	*/
	public long getEntryId() {
		return _userImportLog.getEntryId();
	}

	/**
	* Sets the entry ID of this user import log.
	*
	* @param entryId the entry ID of this user import log
	*/
	public void setEntryId(long entryId) {
		_userImportLog.setEntryId(entryId);
	}

	/**
	* Returns the start time of this user import log.
	*
	* @return the start time of this user import log
	*/
	public java.util.Date getStartTime() {
		return _userImportLog.getStartTime();
	}

	/**
	* Sets the start time of this user import log.
	*
	* @param startTime the start time of this user import log
	*/
	public void setStartTime(java.util.Date startTime) {
		_userImportLog.setStartTime(startTime);
	}

	/**
	* Returns the end time of this user import log.
	*
	* @return the end time of this user import log
	*/
	public java.util.Date getEndTime() {
		return _userImportLog.getEndTime();
	}

	/**
	* Sets the end time of this user import log.
	*
	* @param endTime the end time of this user import log
	*/
	public void setEndTime(java.util.Date endTime) {
		_userImportLog.setEndTime(endTime);
	}

	/**
	* Returns the total process of this user import log.
	*
	* @return the total process of this user import log
	*/
	public long getTotalProcess() {
		return _userImportLog.getTotalProcess();
	}

	/**
	* Sets the total process of this user import log.
	*
	* @param totalProcess the total process of this user import log
	*/
	public void setTotalProcess(long totalProcess) {
		_userImportLog.setTotalProcess(totalProcess);
	}

	/**
	* Returns the total import of this user import log.
	*
	* @return the total import of this user import log
	*/
	public long getTotalImport() {
		return _userImportLog.getTotalImport();
	}

	/**
	* Sets the total import of this user import log.
	*
	* @param totalImport the total import of this user import log
	*/
	public void setTotalImport(long totalImport) {
		_userImportLog.setTotalImport(totalImport);
	}

	/**
	* Returns the total error of this user import log.
	*
	* @return the total error of this user import log
	*/
	public long getTotalError() {
		return _userImportLog.getTotalError();
	}

	/**
	* Sets the total error of this user import log.
	*
	* @param totalError the total error of this user import log
	*/
	public void setTotalError(long totalError) {
		_userImportLog.setTotalError(totalError);
	}

	/**
	* Returns the summary of this user import log.
	*
	* @return the summary of this user import log
	*/
	public java.lang.String getSummary() {
		return _userImportLog.getSummary();
	}

	/**
	* Sets the summary of this user import log.
	*
	* @param summary the summary of this user import log
	*/
	public void setSummary(java.lang.String summary) {
		_userImportLog.setSummary(summary);
	}

	/**
	* Returns the create date of this user import log.
	*
	* @return the create date of this user import log
	*/
	public java.util.Date getCreateDate() {
		return _userImportLog.getCreateDate();
	}

	/**
	* Sets the create date of this user import log.
	*
	* @param createDate the create date of this user import log
	*/
	public void setCreateDate(java.util.Date createDate) {
		_userImportLog.setCreateDate(createDate);
	}

	/**
	* Returns the total existing of this user import log.
	*
	* @return the total existing of this user import log
	*/
	public java.lang.Long getTotalExisting() {
		return _userImportLog.getTotalExisting();
	}

	/**
	* Sets the total existing of this user import log.
	*
	* @param totalExisting the total existing of this user import log
	*/
	public void setTotalExisting(java.lang.Long totalExisting) {
		_userImportLog.setTotalExisting(totalExisting);
	}

	public boolean isNew() {
		return _userImportLog.isNew();
	}

	public void setNew(boolean n) {
		_userImportLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _userImportLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userImportLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userImportLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userImportLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userImportLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userImportLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userImportLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserImportLogWrapper((UserImportLog)_userImportLog.clone());
	}

	public int compareTo(
		com.idetronic.portlet.model.UserImportLog userImportLog) {
		return _userImportLog.compareTo(userImportLog);
	}

	@Override
	public int hashCode() {
		return _userImportLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.UserImportLog> toCacheModel() {
		return _userImportLog.toCacheModel();
	}

	public com.idetronic.portlet.model.UserImportLog toEscapedModel() {
		return new UserImportLogWrapper(_userImportLog.toEscapedModel());
	}

	public com.idetronic.portlet.model.UserImportLog toUnescapedModel() {
		return new UserImportLogWrapper(_userImportLog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userImportLog.toString();
	}

	public java.lang.String toXmlString() {
		return _userImportLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userImportLog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserImportLogWrapper)) {
			return false;
		}

		UserImportLogWrapper userImportLogWrapper = (UserImportLogWrapper)obj;

		if (Validator.equals(_userImportLog, userImportLogWrapper._userImportLog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserImportLog getWrappedUserImportLog() {
		return _userImportLog;
	}

	public UserImportLog getWrappedModel() {
		return _userImportLog;
	}

	public void resetOriginalValues() {
		_userImportLog.resetOriginalValues();
	}

	private UserImportLog _userImportLog;
}