/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Misc extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  boolean b_leds = false;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void LEDS_On(){
    RobotMap.LEDS.set(Value.kForward);
  }

  public void LEDS_Off(){
    RobotMap.LEDS.set(Value.kOff);
  }

  public void LEDS(){
    if (!b_leds){
      RobotMap.LEDS.set(Value.kForward);
      b_leds = true;
      SmartDashboard.putBoolean("LEDS Status", b_leds);
    }
    else if (b_leds){
      RobotMap.LEDS.set(Value.kOff);
      b_leds = false;
      SmartDashboard.putBoolean("LEDS Status", b_leds);
    }
  }

}
