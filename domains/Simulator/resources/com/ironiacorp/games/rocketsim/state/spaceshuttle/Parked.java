package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Parked extends SpaceShuttleState
{
	public Parked(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
		System.err.println("Steering using all aerodynamic surfaces");
	}

	public void throttle(double percent)
	{
		if (percent < 0.5) {
			System.err.println("Heh, trying to lift off with so little thrust?");
		} else {
			if (sts.willFail()) {
				changeState(Crashed.class);
			} else {
				sts.setAltitute(1);
				sts.setSpeed(1);
				changeState(Launching.class);
			}
		}
	}
}
