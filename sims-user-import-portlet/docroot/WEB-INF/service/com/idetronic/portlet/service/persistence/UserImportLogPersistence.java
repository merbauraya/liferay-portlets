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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.model.UserImportLog;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user import log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserImportLogPersistenceImpl
 * @see UserImportLogUtil
 * @generated
 */
public interface UserImportLogPersistence extends BasePersistence<UserImportLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserImportLogUtil} to access the user import log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user import log in the entity cache if it is enabled.
	*
	* @param userImportLog the user import log
	*/
	public void cacheResult(
		com.idetronic.portlet.model.UserImportLog userImportLog);

	/**
	* Caches the user import logs in the entity cache if it is enabled.
	*
	* @param userImportLogs the user import logs
	*/
	public void cacheResult(
		java.util.List<com.idetronic.portlet.model.UserImportLog> userImportLogs);

	/**
	* Creates a new user import log with the primary key. Does not add the user import log to the database.
	*
	* @param entryId the primary key for the new user import log
	* @return the new user import log
	*/
	public com.idetronic.portlet.model.UserImportLog create(long entryId);

	/**
	* Removes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log that was removed
	* @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog remove(long entryId)
		throws com.idetronic.portlet.NoSuchUserImportLogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.portlet.model.UserImportLog updateImpl(
		com.idetronic.portlet.model.UserImportLog userImportLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user import log with the primary key or throws a {@link com.idetronic.portlet.NoSuchUserImportLogException} if it could not be found.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log
	* @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog findByPrimaryKey(
		long entryId)
		throws com.idetronic.portlet.NoSuchUserImportLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user import log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log, or <code>null</code> if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user import logs.
	*
	* @return the user import logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserImportLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user import logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user import logs
	* @param end the upper bound of the range of user import logs (not inclusive)
	* @return the range of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserImportLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user import logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user import logs
	* @param end the upper bound of the range of user import logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.portlet.model.UserImportLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user import logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user import logs.
	*
	* @return the number of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}