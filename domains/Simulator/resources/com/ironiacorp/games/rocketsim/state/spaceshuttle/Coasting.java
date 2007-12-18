package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Coasting extends SpaceShuttleState
{
	public Coasting(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
		System.err.println("Steering using the rockets");
	}

	public void throttle(double percent)
	{
		System.err.println("Throttling the engines to " + percent);
		sts.setSpeed(sts.getSpeed() * (percent/30));
		sts.setAltitute(sts.getAltitute() * (percent/30));
		if (sts.getSpeed() < 180000) {
			changeState(Landing.class);
		}
	}
}
