package com.ironiacorp.patterns.state;

public abstract class ContextInState<T extends IntrusiveState> extends BaseContext<T>
{
	public ContextInState()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public void setCurrentState(Class<? extends IntrusiveState> clazz)
	{
		T state = findInstanceforState((Class<? extends T>) clazz);
		currentState = state;
	}
	
	public T getCurrentState()
	{
		return currentState;
	}

	public T getState(Class<T> clazz)
	{
		return null;
	}
	
}
