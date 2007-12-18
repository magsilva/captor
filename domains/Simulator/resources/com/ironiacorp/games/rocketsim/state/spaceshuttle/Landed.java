package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Landed extends SpaceShuttleState
{

	public Landed(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
	}

	public void throttle(double percent)
	{
	}
}
