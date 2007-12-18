package com.ironiacorp.patterns.state;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public abstract class ContextInFSM<T extends State> extends BaseContext<T>
{
	private Set<Object> inputAlphabet;
	
	private Set<Object> outputAlphabet;
	
	protected BlockingQueue<Object> symbols;

	public ContextInFSM()
	{
		super();
		inputAlphabet = new HashSet<Object>();
		outputAlphabet = new HashSet<Object>();
		symbols = new SynchronousQueue<Object>();
	}
	
	public synchronized void addInputAlphabetSymbol(Object obj)
	{
		inputAlphabet.add(obj);
	}

	public synchronized void addOutputAlphabetSymbol(Object obj)
	{
		outputAlphabet.add(obj);
	}

	public void queueSymbol(Object symbol)
	{
		symbols.add(symbol);
	}
}
