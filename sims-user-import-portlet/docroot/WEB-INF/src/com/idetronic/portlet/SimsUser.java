package com.idetronic.portlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.SystemException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.idetronic.portlet.service.UserImportLogLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.idetronic.portlet.model.UserImportLog;
import com.idetronic.portlet.model.impl.UserImportLogImpl;
//import com.idetronic.portlet.model.impl.FAQEntryImpl;
/**
 * Portlet implementation class SimsUser
 */
public class SimsUser extends MVCPortlet {
	
	static long _organisationId;
	static String _organisationName;// ="Universiti Teknologi Mara";
	static long _companyId;
	static Log log = LogFactoryUtil.getLog(SimsUser.class);
	static UserImportLog _importLog;
	static Date _startTime;
	static long _totalProcess;
	static long _totalImport;
	static long _totalError;
	static long _totalExisting;
	static Locale _locale;
	public  static void importStaff()
	{
		
		Connection conn;
		Organization organization = null;
		_startTime = new Date();
		
		//start our log;
		_totalProcess = 0;
		_totalImport=0;
		_totalError=0;
		_totalExisting=0;
		
		_locale = LocaleUtil.getDefault();
		//Log log = LogFactoryUtil.getLog(SimsUser.class);//  (LMSBookLocalServiceImpl.class);
		String DATASOURCE_CONTEXT = "java:comp/env/jdbc/sims";
		Connection result = null;
		try 
		{
			Context initialContext = new InitialContext();
			if ( initialContext == null)
			{
				log.error("Cannot get initialContext");
			}
			
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get("default.web.id"));
			_organisationName = PropsUtil.get("user.default.orgname");
			_companyId = company.getCompanyId();//  company.getGroup().getGroupId(); 
			
			log.info("comp="+ _companyId);
			
			//get our Organisation
			_organisationId = OrganizationLocalServiceUtil.getOrganizationId(_companyId, _organisationName);//
			organization = OrganizationLocalServiceUtil.getOrganization(_organisationId);
			
			
			DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
			conn = datasource.getConnection();
			importDepartment(conn,_companyId);
			importUsers(_companyId, conn);
			conn.close();
			
			//log our import
			if (_totalProcess > 0)
				createImportLog();
			if (_totalImport > 0)
				OrganizationLocalServiceUtil.updateOrganization(organization, true);
				
		}
		catch ( NamingException ex ) {
			log.error("Cannot get connection: " + ex);
		}
		catch(SQLException ex){
			log.error("Cannot get connection: " + ex); 
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (PortalException ex)
		{
			log.error("error getting company info"+ ex.getMessage());
		}
	
		finally
		{
			
			
		}
		
		
	}
 
	private static void importDepartment(Connection conn,long companyId)
	{
		//Log log = LogFactoryUtil.getLog(SimsUser.class);//  (LMSBookLocalServiceImpl.class);
		String query  = "select distinct bk_jab_sekarang_desc as dept from staff_activ order by dept";
		Statement stmt = null;
		String dept;
		ServiceContext serviceContext = new ServiceContext();
		UserGroup userGroup = null;
		serviceContext.setAddGuestPermissions(true);
		
		
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            dept = rs.getString("dept");
	            log.info("processing dept "+dept);
	            userGroup = importUserGroup(companyId,dept);
	            addRole(companyId,userGroup);
	            
	        }
	        rs.close();
	    } catch (java.sql.SQLException e ) {
	        log.error("Error retrieving department" + e.getMessage());
	        e.printStackTrace();
	    
	    } finally {
	     
	    }
        
        
	}
	private static UserGroup importUserGroup(long companyId,String groupName)
	{
		//Log log = LogFactoryUtil.getLog(SimsUser.class);//  (LMSBookLocalServiceImpl.class);
		UserGroup userGroup = null;
		//liferay doesnt like having comma in name, we remove if any
		groupName = groupNameValidator(groupName);// groupName.replace(","," ");
		try 
		{
			userGroup = UserGroupLocalServiceUtil.getUserGroup(
					companyId, groupName);
		}
		
		catch (PortalException e) 
		{
			
			
			UserGroup uGroup;
			long defaultUserId;
			try {
				defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
				uGroup = UserGroupLocalServiceUtil.addUserGroup(
						defaultUserId, companyId, groupName,
						groupName);
				return uGroup;
				}
			catch (com.liferay.portal.kernel.exception.SystemException e1) {
					log.error("error importing user group,SystemException");
					e1.printStackTrace();
				} catch (PortalException e1) {
					log.error("error creating user group,portalException" + e1.getMessage());
					
				e1.printStackTrace();
			}
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			log.error("importusergroup SystemException");
			e.printStackTrace();
		}
		return userGroup;
	}
	private static void addRole(long companyId,UserGroup userGroup)
	{
		Role role = null;
		//Log log = LogFactoryUtil.getLog(SimsUser.class);//  (LMSBookLocalServiceImpl.class);
		try {
			role = RoleLocalServiceUtil.getRole(companyId, userGroup.getName());
		} catch (PortalException e) {
			log.info("creating new role " + userGroup.getName());
			User defaultUser;
			try {
				defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
				Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
				descriptionMap.put(
						LocaleUtil.getDefault(), "Autogenerated role from Sims import");
				role = RoleLocalServiceUtil.addRole(
						defaultUser.getUserId(), null, 0, userGroup.getName(),
						null, descriptionMap, RoleConstants.TYPE_REGULAR, null);
				Group group = userGroup.getGroup();
				if (GroupLocalServiceUtil.hasRoleGroup(
						role.getRoleId(), group.getGroupId())) {

					return;
				
				}
				GroupLocalServiceUtil.addRoleGroups(
						role.getRoleId(), new long[] {group.getGroupId()});

				
				} catch (PortalException e1) {
					log.error("addRole PortalException");
					e1.printStackTrace();
				} catch (com.liferay.portal.kernel.exception.SystemException e1) {
					log.error("addRole SystemException");
					e1.printStackTrace();
				}
				

							
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			log.error("Error getting role " + e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	private static void importUsers(long companyId,Connection conn)
	{
		String query  = "select * from staff_activ";
		Statement stmt = null;
		String dept;
		User user = null;
		ServiceContext serviceContext = new ServiceContext();
		UserGroup userGroup = null;
		serviceContext.setAddGuestPermissions(true);
		//Log log = LogFactoryUtil.getLog(SimsUser.class);
		int c = 0;
		log.info("Start user import");
	    try {
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) 
	        {
	        	_totalProcess++;
	        	//check if we already have the user created
	        	user = getUser(companyId,rs);
	        	if (user == null)
	        		user = addUser(companyId,rs,_locale);
	        	else
	        		_totalExisting++;
	        	c++;
	   
	           
	            
	        }
	        rs.close();
	    } catch (java.sql.SQLException e ) {
	        log.error("Error retrieving department"+ e.getMessage());
	        e.printStackTrace();
	    
	    } finally {
	     
	    }
		
		
	}
	private static User importUser(long companyId,ResultSet rs)
	{
		User user = null;
		try {
			while (rs.next())
			{
				user = getUser(companyId,rs);

				if ((user != null) && user.isDefaultUser()) {
					updateUser(user,rs);
				}
				
				//user not found, we create them
				
				user = addUser(companyId,rs,_locale);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	private static User getUser(long companyId,ResultSet rs)
	{
		User user = null;
		String screenName = null;
		String no_kp=null;
		try {
			
				no_kp = rs.getString("bp_no_kp");
			
				//1st attempt, find by no pekerja
				screenName = basicScreenNameValidator(rs.getString("bp_no_pekerja"));
				user = UserLocalServiceUtil.getUserByScreenName(
						companyId, screenName);
				
		}
		catch (PortalException nsue) {
			//user not found
			log.info("User not found:"+screenName );
			screenName = screenNameValidator(no_kp);

			try {
				user = UserLocalServiceUtil.getUserByScreenName(
						companyId, screenName);
			} catch (PortalException e) {
				log.error("error validating user:" + e.getMessage());
				//e.printStackTrace();
			} catch (com.liferay.portal.kernel.exception.SystemException e) {
				log.error("SystemException:error validating user:" + e.getMessage());
				
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException ex)
		{
			ex.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	private static User updateUser(User user, ResultSet rs)
	{
		
		try {
			user.setFirstName(rs.getString("bp_name"));
			user.setEmailAddress(rs.getString("bp_email"));
			user.setJobTitle(rs.getString("bk_jaw_sekarang_desc"));
			user.setStatus(WorkflowConstants.STATUS_APPROVED);
		
			UserLocalServiceUtil.updateUser(user);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	private static User addUser(long companyId,ResultSet rs,Locale locale)
	{
		User user = null;
		//Log log = LogFactoryUtil.getLog(SimsUser.class);
		Long creatorUserId;
		boolean autoPassword = false;
		String password1="",password2="";
		boolean autoScreenName = false;
		String screenName="" , emailAddress;
		long facebookId = 0;
		String openId=null;
		String firstName,middleName=null,lastName=null,jobTitle;
		int prefixId = 0,suffixId=0;
		String role_dept;
		boolean male=false;
		long[] userGroupIds;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds;
		int birthdayMonth,birthdayDay,birthdayYear;
		boolean sendEmail = false;
		String tmpDate="";
		boolean validBirthday = true;
		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();
		Date bday;
		
		try {
			bday = rs.getDate("bk_tarikh_lahir");
			if (rs.wasNull())
				validBirthday = false;
			else
				birthdayCal.setTime(bday);
			
		} catch (SQLException e2) {
			
			validBirthday = false;
		}
		
		
		try
		{
			birthdayMonth = 1;
			birthdayDay = 1;
			birthdayYear=1970;
			password1 = rs.getString("bp_no_kp").replaceAll("\\s","");
			
			if (validBirthday)// != "0000-00-00")
			{
					
				birthdayMonth = birthdayCal.get(Calendar.MONTH);
				birthdayDay = birthdayCal.get(Calendar.DAY_OF_MONTH);
				birthdayYear = birthdayCal.get(Calendar.YEAR);
			}
			emailAddress = null;
			if (Validator.isNotNull(rs.getString("bp_email")))
			{
				emailAddress = emailValidator(rs.getString("bp_email"));
				
			}
			screenName = screenNameValidator(rs.getString("bp_no_pekerja"));//default screen name to no pekerja
			if (screenName == "")
			{
				//we cannot use this screen name due to id conflict in group_ table
				//replace it with no_kp
				screenName = screenNameValidator(rs.getString("bp_no_kp"));
				
			}
			password2 = password1;
			firstName = rs.getString("bp_nama");
			jobTitle = rs.getString("bk_jaw_sekarang_desc");
			role_dept = rs.getString("bk_jab_sekarang_desc");
			userGroupIds = getGroupIds(companyId,rs.getString("bk_jab_sekarang_desc"));
			roleIds = getRolesIds(companyId,rs.getString("bk_jab_sekarang_desc"));
			creatorUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			
			user = UserLocalServiceUtil.addUser(creatorUserId, companyId, 
						autoPassword, password1, password2, 
						autoScreenName, screenName, emailAddress, 
						facebookId, openId, locale, firstName, 
						middleName, lastName, prefixId, 
						suffixId, male, birthdayMonth, 
						birthdayDay, birthdayYear, jobTitle, 
						groupIds, organizationIds, roleIds, 
						userGroupIds, sendEmail, new ServiceContext())	;
			user.setPasswordReset(false);
			user.setStatus(WorkflowConstants.STATUS_APPROVED);
			UserLocalServiceUtil.updateUser(user);
			assignToOrganisation(user);
			_totalImport++;
		}catch (SQLException e)
		{
			_totalError++;
			log.error("Error importing user, SQL Exception kp="+ password1 + " screenName="+screenName + " bdate="+tmpDate + e.getMessage());
			e.printStackTrace();
			
		}catch (PortalException e1)
		{
			_totalError++;
			log.error("Error importing user, PortalException Exception kp="+ password1 + " screenName="+screenName + e1.getMessage());
			e1.printStackTrace();
			
		}catch (com.liferay.portal.kernel.exception.SystemException ex)
		{	
			_totalError++;
			log.error("Error importing user, SQL Exception kp="+ password1 + " screenName="+screenName + ex.getMessage());
			ex.printStackTrace();
		}finally
		{
			
		}
		
		return user;
	}
	private static void assignToOrganisation(User user)
	{
		try {
			OrganizationLocalServiceUtil.addUserOrganization(user.getUserId(), _organisationId);
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			log.error("Error assigning user to Organization");
			e.printStackTrace();
		}
	}
	private static long[] getGroupIds(long companyId,String groupName)
	{
		long[] groups;
		groups = new long[1];
		groupName = groupNameValidator(groupName);
		
		try {
			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(
					companyId, groupName);
			groups[0] = userGroup.getUserGroupId();
		} catch (PortalException e) {
			log.error("SimsUser:getGroupIds " + e.getMessage());
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			log.error("SimsUser:getGroupIds " + e.getMessage());
			e.printStackTrace();
		}
		return groups;
	}
	private static long[] getRolesIds(long companyId,String roleName)
	{
		long[] roles;
		roleName = groupNameValidator(roleName);
		roles = new long[1];
		try {
			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
			roles[0] = role.getRoleId();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;	
	}
	private static String groupNameValidator(String in)
	{
		String ret = in;
		//liferay doesnt like comma, remove it
		ret = ret.replace("," , " ");
		//just get first 75 characters
		if (ret.length() > 75)
			ret = ret.substring(0,74);
		return ret;
	}
	private static String screenNameValidator(String in)
	{
		//doest want space
		String ret;
		log.info("screenNameValidator="+in);
		ret = in.replaceAll("\\s+","");
		ret = ret.replaceAll(",","");
		ret = ret.replaceAll("/","");
		if (Validator.isNumber(ret))
		{
		
			try {
				Group group = GroupLocalServiceUtil.fetchGroup(GetterUtil.getLong(ret));
				if (group != null)
				{
					log.info("Found user with unusable no_pekerja as screen name:" + ret);
					ret = "";
				}
			} catch (com.liferay.portal.kernel.exception.SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	private static String basicScreenNameValidator(String in)
	{
		//doest want space
		String ret = in.replaceAll("\\s","");
		ret = in.replaceAll(",","");
		ret = in.replaceAll("/","");
		return ret;
	}
	private static String emailValidator(String in)
	{
		String ret = in.replaceAll("\\s","");
		
		return ret;
	}

	private static void createImportLog()
	{
		UserImportLog importLog = new UserImportLogImpl();
		importLog.setCreateDate(new Date());
		importLog.setEndTime(new Date());
		importLog.setStartTime(_startTime);
		importLog.setTotalProcess(_totalProcess);
		importLog.setTotalImport(_totalImport);
		importLog.setTotalError(_totalError);
		importLog.setTotalExisting(_totalExisting);
		try {
			UserImportLogLocalServiceUtil.updateUserImportLog(importLog);
		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			log.error("Error creating import log");
			e.printStackTrace();
		}
	}
}