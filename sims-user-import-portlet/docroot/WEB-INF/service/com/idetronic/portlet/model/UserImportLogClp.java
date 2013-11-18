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

import com.idetronic.portlet.service.ClpSerializer;
import com.idetronic.portlet.service.UserImportLogLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class UserImportLogClp extends BaseModelImpl<UserImportLog>
	implements UserImportLog {
	public UserImportLogClp() {
	}

	public Class<?> getModelClass() {
		return UserImportLog.class;
	}

	public String getModelClassName() {
		return UserImportLog.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryId", long.class);

				method.invoke(_userImportLogRemoteModel, entryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_userImportLogRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_userImportLogRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getTotalProcess() {
		return _totalProcess;
	}

	public void setTotalProcess(long totalProcess) {
		_totalProcess = totalProcess;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalProcess", long.class);

				method.invoke(_userImportLogRemoteModel, totalProcess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getTotalImport() {
		return _totalImport;
	}

	public void setTotalImport(long totalImport) {
		_totalImport = totalImport;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalImport", long.class);

				method.invoke(_userImportLogRemoteModel, totalImport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getTotalError() {
		return _totalError;
	}

	public void setTotalError(long totalError) {
		_totalError = totalError;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalError", long.class);

				method.invoke(_userImportLogRemoteModel, totalError);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setSummary", String.class);

				method.invoke(_userImportLogRemoteModel, summary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userImportLogRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Long getTotalExisting() {
		return _totalExisting;
	}

	public void setTotalExisting(Long totalExisting) {
		_totalExisting = totalExisting;

		if (_userImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _userImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalExisting", Long.class);

				method.invoke(_userImportLogRemoteModel, totalExisting);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserImportLogRemoteModel() {
		return _userImportLogRemoteModel;
	}

	public void setUserImportLogRemoteModel(
		BaseModel<?> userImportLogRemoteModel) {
		_userImportLogRemoteModel = userImportLogRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userImportLogRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userImportLogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserImportLogLocalServiceUtil.addUserImportLog(this);
		}
		else {
			UserImportLogLocalServiceUtil.updateUserImportLog(this);
		}
	}

	@Override
	public UserImportLog toEscapedModel() {
		return (UserImportLog)ProxyUtil.newProxyInstance(UserImportLog.class.getClassLoader(),
			new Class[] { UserImportLog.class }, new AutoEscapeBeanHandler(this));
	}

	public UserImportLog toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		UserImportLogClp clone = new UserImportLogClp();

		clone.setEntryId(getEntryId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setTotalProcess(getTotalProcess());
		clone.setTotalImport(getTotalImport());
		clone.setTotalError(getTotalError());
		clone.setSummary(getSummary());
		clone.setCreateDate(getCreateDate());
		clone.setTotalExisting(getTotalExisting());

		return clone;
	}

	public int compareTo(UserImportLog userImportLog) {
		int value = 0;

		value = DateUtil.compareTo(getStartTime(), userImportLog.getStartTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserImportLogClp)) {
			return false;
		}

		UserImportLogClp userImportLog = (UserImportLogClp)obj;

		long primaryKey = userImportLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", totalProcess=");
		sb.append(getTotalProcess());
		sb.append(", totalImport=");
		sb.append(getTotalImport());
		sb.append(", totalError=");
		sb.append(getTotalError());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", totalExisting=");
		sb.append(getTotalExisting());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.UserImportLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalProcess</column-name><column-value><![CDATA[");
		sb.append(getTotalProcess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalImport</column-name><column-value><![CDATA[");
		sb.append(getTotalImport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalError</column-name><column-value><![CDATA[");
		sb.append(getTotalError());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalExisting</column-name><column-value><![CDATA[");
		sb.append(getTotalExisting());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private Date _startTime;
	private Date _endTime;
	private long _totalProcess;
	private long _totalImport;
	private long _totalError;
	private String _summary;
	private Date _createDate;
	private Long _totalExisting;
	private BaseModel<?> _userImportLogRemoteModel;
}