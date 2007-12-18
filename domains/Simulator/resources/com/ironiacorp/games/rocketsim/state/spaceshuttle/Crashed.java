package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Crashed extends SpaceShuttleState
{
	public Crashed(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
		System.err.println("Vehicle lost, jump off!");
	}

	public void throttle(double percent)
	{
		System.err.println("Vehicle lost, jump off!");
	}
}
