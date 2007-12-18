package com.ironiacorp.patterns.state;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseContext<T extends State> implements Context<T>
{
	private Set<T> states;

	private T startState;
	
	private Set<T> finalStates;
	
	
	protected T currentState;

	public BaseContext()
	{
		states = new HashSet<T>();
		finalStates = new HashSet<T>();
	}

	protected T findInstanceforState(Class<? extends T> clazz)
	{
		Iterator<T> i = states.iterator();
		T state = null;
		
		while (i.hasNext()) {
			T stateTmp = i.next();
			if (stateTmp.getClass().equals(clazz)) {
				state = stateTmp;
				break;
			}
		}
		
		if (state == null) {
			throw new IllegalArgumentException("Invalid state");
		}
		
		return state;
	}

	public void setStartState(Class<? extends T> clazz)
	{
		T state = findInstanceforState(clazz);
		startState = state;
	}

	public void addFinalState(Class<? extends T> clazz)
	{
		T state = findInstanceforState(clazz);
		finalStates.add(state);
	}

	@SuppressWarnings("unchecked")
	public void addState(Class<? extends T> clazz)
	{
		T state = null;
		Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
		Constructor<T> constructor = null;
		for (Constructor<T> i : constructors) {
			if (i.getParameterTypes().length == 1) {
				constructor = i;
				break;
			}
		}
		
		try {
			state = constructor.newInstance(this);
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
		
		states.add(state);
	}

	public void start()
	{
		currentState = startState;
	}

}
