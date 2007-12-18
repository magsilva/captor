package com.ironiacorp.games.rocketsim.state.spaceshuttle;

import com.ironiacorp.patterns.state.ContextInState;
import com.ironiacorp.patterns.state.IntrusiveState;

public class Launching extends SpaceShuttleState
{
	public Launching(ContextInState<? extends IntrusiveState> sm)
	{
		super(sm);
	}

	public void steer(double pitch, double roll, double yaw)
	{

		if (sts.getSpeed() < 330) {
			System.err.println("Steering using the rocket's cone aerodynamic surfaces and rockets");
		} else {
			System.err.println("Steering using the rockets");
		}
		if (pitch > 0.999 || yaw > 0.999) {
			System.err.println("Ops, the frame cannot stand such aerodynamic pressure");
			changeState(Crashed.class);
		}
	}

	public void throttle(double percent)
	{
		System.err.println("Throttling the engines to " + percent);
		double currentSpeed = sts.getSpeed();
		double speed = (currentSpeed * (0.73 + percent)) + 100;
		if (speed > 18000) {
			speed = 18000;
		}
		if (speed < currentSpeed) {
			speed = currentSpeed;
		}
		sts.setSpeed(speed);

		double altitute  = (sts.getAltitute() * (0.87 + percent)) + (sts.getSpeed() / 5);
		if (sts.getAltitute() > 180000) {
			altitute = 180000;
		}
		sts.setAltitute((int)altitute);
		

		
		if (sts.getAltitute() >= 180000 && sts.getSpeed() >= 18000) {
			changeState(Coasting.class);
		}
	}
}
