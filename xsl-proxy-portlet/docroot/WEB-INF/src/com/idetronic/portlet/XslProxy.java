package com.idetronic.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.idetronic.portlet.ProxyConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
//import com.liferay.portal.model.PortletPreferences;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.plexobject.transform.XslContentTransformer;
import com.plexobject.web.proxy.HttpProxyImpl;
import com.plexobject.web.proxy.MethodType;
import com.plexobject.web.proxy.ProxyResponse;
import com.plexobject.web.proxy.ProxyState;
import com.plexobject.web.service.*;

/**
 * Portlet implementation class XslProxy
 */
public class XslProxy extends MVCPortlet {
	private HttpProxyImpl proxy;
	private String _portletName;
	private String _portletURL; //action URL
	private String _proxyURL; //our proxied url
	private String _response;
	
	 public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException 
	 {
		 //read the config
		 getPortletInfo(actionRequest);
		 
		 
		 String method = actionRequest.getMethod();
		 Log log = LogFactoryUtil.getLog(XslProxy.class);//  (LMSBookLocalServiceImpl.class);
		 log.info("processaction");	
		 
		 //get posted/getted params
		 Map<String, String[]> paramMap = actionRequest.getParameterMap();// .getRequestParameterMap();
		 
		 //build our proxy request to target server
		 HttpProxyImpl proxy = new HttpProxyImpl();
		 
		 ProxyResponse pResponse = null;
	 	 
			
		XslContentTransformer xform = new XslContentTransformer(
		            "/com/plexobject/transform/xhtmlTransform.xslt", true);
		Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
		props.put("portletURL",_portletURL);
		    //props.put("portletURL",portletURL);
		
		
		 
		 String origActionURL="";
		 
		 Map<String, String[]> params = new HashMap<String, String[]>();
		 Iterator i = paramMap.keySet().iterator();
		 while ( i.hasNext() )
		 {
			 String key = (String) i.next();
			 String value = ((String[]) paramMap.get( key ))[ 0 ];
			 
			 if (key.equalsIgnoreCase("_originalActionUrl"))
				 origActionURL = value;
			 else
				 params.put(key, paramMap.get( key ));
			 log.info("Key="+ key + " value=" + value);
		 
		 }
		 String url = origActionURL == "" ? _proxyURL: origActionURL;
		 log.info("url="+url + " method="+method);
		 ProxyState state = new ProxyState(url,method);
		 pResponse = proxy.request(state, params);
		 
		 _response = xform.transform(pResponse.getContents(), props);
		 actionRequest.setAttribute("result", _response);
		 /*
		//show the result 
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,
                 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", ProxyConstant.RENDER_RESPONSE); // set required parameter that you need in doView or render Method
		//redirectURL.setParameter("content", response);
		actionResponse.sendRedirect(redirectURL.toString()); 

	        */
	 }
	
	public void testGoogle(ActionRequest actionRequest,
		    ActionResponse actionResponse)
		            throws IOException, PortletException {
				
		proxy = new HttpProxyImpl();
		ProxyState state = new ProxyState("http://www.google.com/search",
	                MethodType.GET);
		Map<String, String[]> params = new HashMap<String, String[]>();
		params.put("q", new String[] { "amazon" });
		params.put("hl", new String[] { "en" });
		params.put("btnG", new String[] { "Google+Search" });
		params.put("aq", new String[] { "f" });
		params.put("oq", new String[] { "" });
		ProxyResponse response = proxy.request(state, params);
		
		//assertTrue(response.getResponseCode() == 200);
		//assertTrue(response.getContents().indexOf("q=http://www.amazon.com") != -1);
	}
	
	private String proxyRequest()
	{
		HttpProxyImpl proxy = new HttpProxyImpl();
		ProxyState state = new ProxyState("http://eprints.uitm.edu.my/cgi/search/simple",
	        MethodType.GET);
		Map<String, String[]> params = new HashMap<String, String[]>();
	    params.put("q", new String[] { "thesis" });
	    params.put("hl", new String[] { "en" });
	    params.put("btnG", new String[] { "Google+Search" });
	    params.put("aq", new String[] { "f" });
	    params.put("oq", new String[] { "" });
	    
	    ProxyResponse pResponse = null;
		try {
			pResponse = proxy.request(state, params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    XslContentTransformer xform = new XslContentTransformer(
	            "/com/plexobject/transform/xhtmlTransform.xslt", true);
	    Map<String,String> props = new HashMap<String,String>();
		props.put("callbackHandler","www.portlet.com");
	    //props.put("portletURL",portletURL);
	    String x = xform.transform(pResponse.getContents(), props);
	    
	    String content = x;//pResponse.getContents();
	    return content;

	}
	private void getPortletInfo(ActionRequest actionRequest)
	{
		ThemeDisplay themeDisplay =(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
		_portletName = portletConfig.getPortletName();
		PortletURL pURL = PortletURLFactoryUtil.create(
				actionRequest,
				_portletName + "_WAR_" + _portletName + "portlet",
				themeDisplay.getPlid(),PortletRequest.ACTION_PHASE);
		pURL.setParameter(ActionRequest.ACTION_NAME,ProxyConstant.ACTION_URL);
		_portletURL = pURL.toString();
		
		//read portlet config;
		PortletPreferences preferences = actionRequest.getPreferences();
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		 
		if (Validator.isNotNull(portletResource)) 
		{
		     try {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		_proxyURL = preferences.getValue("url","");
		
	}
	



}
