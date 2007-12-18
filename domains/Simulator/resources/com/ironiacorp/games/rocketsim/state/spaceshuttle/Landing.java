package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Landing extends SpaceShuttleState
{
	public Landing(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{
		System.err.println("Steering using the shuttle aerodynamic surfaces");
		double altitute = sts.getAltitute() - 800;
		if (altitute <= 0) {
			altitute = 0;
		}
		sts.setAltitute(altitute);

		double speed = sts.getSpeed() - (300 / sts.getAltitute());
		if (speed <= 0) {
			speed = 0;
		}
		sts.setSpeed(speed);

		if (sts.getAltitute() == 0) {
			if (sts.getSpeed() > 150) {
				System.err.println("Overspeed when landing, sorry");
				changeState(Crashed.class);
			} else {
				System.err.println("The eagle has landed! Welcome back guys");
				changeState(Landed.class);
			}
		}
	}

	public void throttle(double percent)
	{
	}
}
