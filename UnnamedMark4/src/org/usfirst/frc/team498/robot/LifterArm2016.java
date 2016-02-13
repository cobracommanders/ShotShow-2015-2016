package org.usfirst.frc.team498.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class LifterArm2016 {
	// Handle action arm related inputs and outputs
	Joystick thisStick;
	CANTalon lifter;
	DigitalInput innerBounds;
	
	LifterArm2016(Joystick joystick,int lifterCANPort,int innerBoundSwitchDIOPort) {
		thisStick = joystick;
		lifter = new CANTalon(lifterCANPort);
		innerBounds = new DigitalInput(innerBoundSwitchDIOPort);
	}
	public void baseListener() {

			if (!innerBounds.get()) {
				if (-thisStick.getRawAxis(5) < 0) {
					setLifter(0);
				} else {
					setLifter(-thisStick.getRawAxis(5));
				}

			} 
			
			/*
			 * TO ADD OUTER BOUND LIMIT SWITCH UNCOMMENT AND ADD APPROPRAITE VARIABLES
			 * 
			 * else if (outerBounds.get()) {
				if (thisStick.getRawAxis(5) > 0) {
					lifter.set(0);
				} else {
					lifter.set(thisStick.getRawAxis(5));
				}

			}*/ else {
				setLifter(-thisStick.getRawAxis(5));
			}
		}
	
	public void setLifter(double value){
		lifter.set(value);
	}
}