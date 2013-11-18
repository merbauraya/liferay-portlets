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

package com.idetronic.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserImportLogLocalService}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       UserImportLogLocalService
 * @generated
 */
public class UserImportLogLocalServiceWrapper
	implements UserImportLogLocalService,
		ServiceWrapper<UserImportLogLocalService> {
	public UserImportLogLocalServiceWrapper(
		UserImportLogLocalService userImportLogLocalService) {
		_userImportLogLocalService = userImportLogLocalService;
	}

	/**
	* Adds the user import log to the database. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog addUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.addUserImportLog(userImportLog);
	}

	/**
	* Creates a new user import log with the primary key. Does not add the user import log to the database.
	*
	* @param entryId the primary key for the new user import log
	* @return the new user import log
	*/
	public com.idetronic.portlet.model.UserImportLog createUserImportLog(
		long entryId) {
		return _userImportLogLocalService.createUserImportLog(entryId);
	}

	/**
	* Deletes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log that was removed
	* @throws PortalException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog deleteUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.deleteUserImportLog(entryId);
	}

	/**
	* Deletes the user import log from the database. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog deleteUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.deleteUserImportLog(userImportLog);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userImportLogLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.idetronic.portlet.model.UserImportLog fetchUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.fetchUserImportLog(entryId);
	}

	/**
	* Returns the user import log with the primary key.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log
	* @throws PortalException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog getUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.getUserImportLog(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.idetronic.portlet.model.UserImportLog> getUserImportLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.getUserImportLogs(start, end);
	}

	/**
	* Returns the number of user import logs.
	*
	* @return the number of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public int getUserImportLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.getUserImportLogsCount();
	}

	/**
	* Updates the user import log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog updateUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.updateUserImportLog(userImportLog);
	}

	/**
	* Updates the user import log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @param merge whether to merge the user import log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user import log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.portlet.model.UserImportLog updateUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userImportLogLocalService.updateUserImportLog(userImportLog,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userImportLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userImportLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userImportLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserImportLogLocalService getWrappedUserImportLogLocalService() {
		return _userImportLogLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserImportLogLocalService(
		UserImportLogLocalService userImportLogLocalService) {
		_userImportLogLocalService = userImportLogLocalService;
	}

	public UserImportLogLocalService getWrappedService() {
		return _userImportLogLocalService;
	}

	public void setWrappedService(
		UserImportLogLocalService userImportLogLocalService) {
		_userImportLogLocalService = userImportLogLocalService;
	}

	private UserImportLogLocalService _userImportLogLocalService;
}