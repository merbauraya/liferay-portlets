<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.idetronic.portlet.TimeDifference" %>

<%
	
	//SimsUser.importStaff();

	List<UserImportLog> importLogs = UserImportLogLocalServiceUtil.getUserImportLogs(0, -1) ;
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/jsp/view.jsp");
%>
<h1>User Import Log</h1>
<liferay-ui:search-container delta="10" emptyResultsMessage="Sorry. There are no items to display."
	iteratorURL="<%= iteratorURL %>">
	<liferay-ui:search-container-results total="<%= importLogs.size() %>"
		results="<%= ListUtil.subList(importLogs,searchContainer.getStart(),searchContainer.getEnd()) %>"/>

	<liferay-ui:search-container-row modelVar="importLog" className="UserImportLog">
	<liferay-ui:search-container-column-text name="Start Time" property="startTime" />
	<liferay-ui:search-container-column-text name="End Time" property="endTime" />
	<liferay-ui:search-container-column-text name="Total User Processed" property="totalProcess"/>
	<liferay-ui:search-container-column-text name="Total User Imported" property="totalImport"/>
	<liferay-ui:search-container-column-text name="Total Existing User" property="totalExisting"/>
	<liferay-ui:search-container-column-text name="Error" property="totalError"/>
	<liferay-ui:search-container-column-text name="Elapsed">
		<%=TimeDifference.getDifferenceStr(importLog.getStartTime(), importLog.getEndTime()) %>
	</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>