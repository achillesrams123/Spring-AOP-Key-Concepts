package com.example.aoplab.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    

    @Pointcut("execution(* com.example.aoplab.service.UserService.*(..))")
    public void userServiceMethods() {}

    
    @Before("execution(* com.example.aoplab.service.UserService.createUser(..))")
    public void logBeforeCreateUser(JoinPoint joinPoint) {
        // ... method implementation
    	 System.out.println("=== BEFORE ADVICE ===");
    }
   
    
    @AfterReturning(pointcut = "execution(* com.example.aoplab.service.UserService.findUserById(..))", returning = "result")
    public void logAfterReturningFindUser(JoinPoint joinPoint, Object result) {
        // ... method implementation
    	System.out.println("=== AFTER RETURNING ADVICE ===");
    }
    

    @Around("execution(* com.example.aoplab.service.UserService.updateUser(..))")
    public Object logAroundUpdateUser(ProceedingJoinPoint joinPoint) throws Throwable {
    	System.out.println("=== AROUND ADVICE BEFORE =====");
    	Object result =  joinPoint.proceed();
    	System.out.println("=== AROUND ADVICE - AFTER ===");
    	return result;
    }
    
    
    @AfterThrowing(pointcut = "execution(* com.example.aoplab.service.UserService.deleteUser(..))", throwing = "exception")
    public void logAfterThrowingDeleteUser(JoinPoint joinPoint, Exception exception) {
        // ... method implementation
    	System.out.println("=== AFTER THROWING ADVICE ===");
    }
    
    
    @After("execution(* com.example.aoplab.service.UserService.getAllUsers(..))")
    public void logAfterGetAllUsers(JoinPoint joinPoint) {
    	System.out.println("=== AFTER ADVICE ===");
    }
    
  
    @Before("userServiceMethods()")
    public void logAllUserServiceMethods(JoinPoint joinPoint) {
    	System.out.println("=== POINT CUT REUSE ===");
    }
    
  

    
   
}
