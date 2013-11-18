package com.idetronic.portlet.job;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.idetronic.portlet.SimsUser;
public class UserImport implements MessageListener {
	public void receive(Message message)
			throws MessageListenerException 
		{
			System.out.println("inside receive method....");
			SimsUser.importStaff();
		}

}
