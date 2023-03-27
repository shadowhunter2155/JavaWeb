package spa.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import spa.Entity.Member;

@WebListener
public class SpaSessionAttrListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		try {
			Member m = (Member)event.getSession().getAttribute("member");
			if(m.getUsername().equals("C03")) {
				System.out.println("alert...");	
				//event.getSession().invalidate();
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeRemoved(event);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeReplaced(event);
	}
	
}
