package com.revature.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.annotations.ProtectedRouteAnn;
import com.revature.exceptions.ProtectedRouteException;
import com.revature.models.User;
import com.revature.util.LoggedInUserGetter;

@Aspect
@Component
public class ProtectedRouteAspect {

	private LoggedInUserGetter lg;
	
	@Autowired
	public ProtectedRouteAspect(LoggedInUserGetter lg) {
		this.lg = lg;
	}
	
	@Around("@annotation(auth) && execution(* com.revature.controllers..*(..))")
	public Object authenticateUser(ProceedingJoinPoint pjp, ProtectedRouteAnn auth) throws Throwable {
		User currentUser = lg.getLoggedInUser();
		if(currentUser == null) {
			throw new ProtectedRouteException();
		}
		if(currentUser.getId() != 0) {
			return pjp.proceed();
		} else {
			throw new ProtectedRouteException();
		}
	}


}
