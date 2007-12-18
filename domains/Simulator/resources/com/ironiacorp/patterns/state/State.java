package com.ironiacorp.patterns.state;

public abstract class State implements StatefulService
{
	public String getName()
	{
		return getClass().getSimpleName();
	}

	public boolean equals(Object obj)
	{
		return getClass().equals(obj.getClass());
	}
}
