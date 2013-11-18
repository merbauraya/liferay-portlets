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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user import log service. This utility wraps {@link UserImportLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserImportLogPersistence
 * @see UserImportLogPersistenceImpl
 * @generated
 */
public class UserImportLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserImportLog userImportLog) {
		getPersistence().clearCache(userImportLog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserImportLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserImportLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserImportLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserImportLog update(UserImportLog userImportLog,
		boolean merge) throws SystemException {
		return getPersistence().update(userImportLog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserImportLog update(UserImportLog userImportLog,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userImportLog, merge, serviceContext);
	}

	/**
	* Caches the user import log in the entity cache if it is enabled.
	*
	* @param userImportLog the user import log
	*/
	public static void cacheResult(
		com.idetronic.portlet.model.UserImportLog userImportLog) {
		getPersistence().cacheResult(userImportLog);
	}

	/**
	* Caches the user import logs in the entity cache if it is enabled.
	*
	* @param userImportLogs the user import logs
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.portlet.model.UserImportLog> userImportLogs) {
		getPersistence().cacheResult(userImportLogs);
	}

	/**
	* Creates a new user import log with the primary key. Does not add the user import log to the database.
	*
	* @param entryId the primary key for the new user import log
	* @return the new user import log
	*/
	public static com.idetronic.portlet.model.UserImportLog create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log that was removed
	* @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog remove(long entryId)
		throws com.idetronic.portlet.NoSuchUserImportLogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(entryId);
	}

	public static com.idetronic.portlet.model.UserImportLog updateImpl(
		com.idetronic.portlet.model.UserImportLog userImportLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userImportLog, merge);
	}

	/**
	* Returns the user import log with the primary key or throws a {@link com.idetronic.portlet.NoSuchUserImportLogException} if it could not be found.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log
	* @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog findByPrimaryKey(
		long entryId)
		throws com.idetronic.portlet.NoSuchUserImportLogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the user import log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log, or <code>null</code> if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the user import logs.
	*
	* @return the user import logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.UserImportLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.portlet.model.UserImportLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.portlet.model.UserImportLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user import logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user import logs.
	*
	* @return the number of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserImportLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserImportLogPersistence)PortletBeanLocatorUtil.locate(com.idetronic.portlet.service.ClpSerializer.getServletContextName(),
					UserImportLogPersistence.class.getName());

			ReferenceRegistry.registerReference(UserImportLogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserImportLogPersistence persistence) {
	}

	private static UserImportLogPersistence _persistence;
}