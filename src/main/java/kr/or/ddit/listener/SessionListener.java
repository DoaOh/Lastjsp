package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionListener.class);
	
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();  
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//새로운 세션이 응용 프로그램을 만들 때마다 sessionCreated () 메소드는 서블릿 컨테이너에 의해 호출된다. 
		//인수로 전달되는 HttpSessionEvent를 통해 세션 ID를 포함하는 세션과 관련된 정보를 얻을 수 있다.
		se.getSession().getServletContext().setAttribute("sessionMap", sessionMap);
		logger.debug("Session Created : {}", se.getSession().getId());
		sessionMap.put(se.getSession().getId(), se.getSession());
		
//		getSession() ?
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//세션 소멸시에 컨테이너에 의해 자동으로 실행된다.
		logger.debug("Session Destroyed : {}", se.getSession().getId());
		sessionMap.remove(se.getSession().getId());
		
	}
}
