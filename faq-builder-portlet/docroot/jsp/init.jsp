<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%> 
<%@page import="com.idetronic.portlet.FAQConstant"%>
<%@page import="com.idetronic.portlet.service.FAQEntryLocalServiceUtil"%>
<%@page import="com.idetronic.portlet.model.FAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Constants" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.WindowState" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>
<%
WindowState windowState = liferayPortletRequest.getWindowState();
%>