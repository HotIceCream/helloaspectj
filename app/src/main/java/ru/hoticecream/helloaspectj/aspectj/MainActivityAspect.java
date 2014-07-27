package ru.hoticecream.helloaspectj.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class MainActivityAspect {
    private static final String TAG = "helloaspectj";

    @Pointcut("execution(* ru.hoticecream.helloaspectj.ui.MainActivity.onCreate(..))")
    public void onCreateMethod(){}

    @Before("onCreateMethod()")
    public void doBeforeOnCreate(JoinPoint joinPoint) {
        Log.i(TAG, "AspectJ was here");
    }

    @Pointcut("execution(* ru.hoticecream.helloaspectj.ui.MainActivity.setGreetingMessage(..))")
    public void setGreetingMessageMethod(){}

    @Around("setGreetingMessageMethod()")
    public void makeNasty(final ProceedingJoinPoint pjp)
            throws Throwable {
        Log.d(TAG, pjp.getSignature().toLongString());
        pjp.proceed(new Object[] { "Hello AspectJ" });
    }
}
