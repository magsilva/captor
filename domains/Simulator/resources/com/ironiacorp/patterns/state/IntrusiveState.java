package com.ironiacorp.patterns.state;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class IntrusiveState extends State
{
	protected ContextInState<? extends IntrusiveState> sm;
	
	public IntrusiveState(ContextInState<? extends IntrusiveState> sm)
	{
		this.sm = sm;
	}

	protected void changeState(Class<? extends IntrusiveState> clazz)
	{
		State previous = sm.getCurrentState();
		State current = null;
		
		sm.setCurrentState(clazz);
		current = sm.getCurrentState();
		
		System.err.println("Changing from state " + previous.getName() + " to " + current.getName());
	}
	
	protected void changeState(Class<? extends IntrusiveState> clazz, Object ... args)
	{
		String methodName = null;
		Method[] methods = null;
		Method method = null;
		State state = null;
		
		sm.setCurrentState(clazz);
		state = sm.getCurrentState();
		
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		methodName = sts[2].getMethodName();
		methods = state.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				method = m;
				break;
			}
		}
		try {
			if (args == null || args.length == 0) {
				method.invoke(state);
			} else {
				method.invoke(state, args);
			}
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
	}


}
