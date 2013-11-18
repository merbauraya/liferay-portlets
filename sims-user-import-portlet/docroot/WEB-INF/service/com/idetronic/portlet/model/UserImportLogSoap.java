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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Mazlan Mat
 * @generated
 */
public class UserImportLogSoap implements Serializable {
	public static UserImportLogSoap toSoapModel(UserImportLog model) {
		UserImportLogSoap soapModel = new UserImportLogSoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setTotalProcess(model.getTotalProcess());
		soapModel.setTotalImport(model.getTotalImport());
		soapModel.setTotalError(model.getTotalError());
		soapModel.setSummary(model.getSummary());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTotalExisting(model.getTotalExisting());

		return soapModel;
	}

	public static UserImportLogSoap[] toSoapModels(UserImportLog[] models) {
		UserImportLogSoap[] soapModels = new UserImportLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserImportLogSoap[][] toSoapModels(UserImportLog[][] models) {
		UserImportLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserImportLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserImportLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserImportLogSoap[] toSoapModels(List<UserImportLog> models) {
		List<UserImportLogSoap> soapModels = new ArrayList<UserImportLogSoap>(models.size());

		for (UserImportLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserImportLogSoap[soapModels.size()]);
	}

	public UserImportLogSoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getTotalProcess() {
		return _totalProcess;
	}

	public void setTotalProcess(long totalProcess) {
		_totalProcess = totalProcess;
	}

	public long getTotalImport() {
		return _totalImport;
	}

	public void setTotalImport(long totalImport) {
		_totalImport = totalImport;
	}

	public long getTotalError() {
		return _totalError;
	}

	public void setTotalError(long totalError) {
		_totalError = totalError;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Long getTotalExisting() {
		return _totalExisting;
	}

	public void setTotalExisting(Long totalExisting) {
		_totalExisting = totalExisting;
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
}