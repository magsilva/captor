package com.ironiacorp.patterns.state;

import java.util.Set;

public class Transition
{
	private State source;
	
	private State target;
	
	private Set<Object> inputSymbols;
	
	public Transition(State source, State target, Set<Object> symbols)
	{
	}

	public State getSource()
	{
		return source;
	}

	public State getTarget()
	{
		return target;
	}

	private boolean isGuardSatisfied()
	{
		return true;
	}
	
	public boolean isReady(State source, Object symbol)
	{
		if (! this.source.equals(source)) {
			return false;
		}
		
		if (! inputSymbols.contains(symbol)) {
			return false;
		}
		
		if (! isGuardSatisfied()) {
			return false;
		}
		
		return true;
	}
	
	public void run()
	{
		
	}

}
