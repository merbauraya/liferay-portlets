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

package com.idetronic.portlet.model.impl;

import com.idetronic.portlet.model.UserImportLog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserImportLog in entity cache.
 *
 * @author Mazlan Mat
 * @see UserImportLog
 * @generated
 */
public class UserImportLogCacheModel implements CacheModel<UserImportLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", totalProcess=");
		sb.append(totalProcess);
		sb.append(", totalImport=");
		sb.append(totalImport);
		sb.append(", totalError=");
		sb.append(totalError);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", totalExisting=");
		sb.append(totalExisting);
		sb.append("}");

		return sb.toString();
	}

	public UserImportLog toEntityModel() {
		UserImportLogImpl userImportLogImpl = new UserImportLogImpl();

		userImportLogImpl.setEntryId(entryId);

		if (startTime == Long.MIN_VALUE) {
			userImportLogImpl.setStartTime(null);
		}
		else {
			userImportLogImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			userImportLogImpl.setEndTime(null);
		}
		else {
			userImportLogImpl.setEndTime(new Date(endTime));
		}

		userImportLogImpl.setTotalProcess(totalProcess);
		userImportLogImpl.setTotalImport(totalImport);
		userImportLogImpl.setTotalError(totalError);

		if (summary == null) {
			userImportLogImpl.setSummary(StringPool.BLANK);
		}
		else {
			userImportLogImpl.setSummary(summary);
		}

		if (createDate == Long.MIN_VALUE) {
			userImportLogImpl.setCreateDate(null);
		}
		else {
			userImportLogImpl.setCreateDate(new Date(createDate));
		}

		userImportLogImpl.setTotalExisting(totalExisting);

		userImportLogImpl.resetOriginalValues();

		return userImportLogImpl;
	}

	public long entryId;
	public long startTime;
	public long endTime;
	public long totalProcess;
	public long totalImport;
	public long totalError;
	public String summary;
	public long createDate;
	public Long totalExisting;
}