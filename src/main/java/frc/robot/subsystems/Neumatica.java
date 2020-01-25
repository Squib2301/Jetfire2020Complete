/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Neumatica extends Subsystem {
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public boolean b_pist = false;
  public boolean b_flor = false;
  public boolean b_shift = false;

  //TIMED COMMANDS
  public void PistonOut(){
    RobotMap.piston.set(Value.kReverse);
    b_pist = true;
    SmartDashboard.putBoolean("Piston", b_pist);
  }

  public void PistonIn(){
    RobotMap.piston.set(Value.kForward);
    b_pist = false;
    SmartDashboard.putBoolean("Piston", b_flor);
  }

  public void FlorAbierta(){
    RobotMap.flor.set(Value.kForward);
    b_flor = true;
    SmartDashboard.putBoolean("Flor", b_flor);
  }

  public void FlorCerrada(){
    RobotMap.flor.set(Value.kReverse);
    b_flor = false;
    SmartDashboard.putBoolean("Flor", b_flor);
  }

  //NON TIMED COMMANDS
  public void Piston(){
    if (!b_pist){
      RobotMap.piston.set(Value.kReverse);
      b_pist = true;
      SmartDashboard.putBoolean("Piston", b_pist);
    }
    else if (b_pist){
      RobotMap.piston.set(Value.kForward);
      b_pist = false;
      SmartDashboard.putBoolean("Piston", b_pist);
    }
    else{
      RobotMap.piston.set(Value.kOff);
      b_pist = false;
      SmartDashboard.putBoolean("Piston", b_pist);
    }
  }

  public void Flor(){
    if (!b_flor){
      RobotMap.flor.set(Value.kForward);
      b_flor = true;
      SmartDashboard.putBoolean("Flor", b_flor);
    }
    else if (b_flor){
      RobotMap.flor.set(Value.kReverse);
      b_flor = false;
      SmartDashboard.putBoolean("Flor", b_flor);
    }
    else{
      RobotMap.flor.set(Value.kOff);
      b_flor = false;
      SmartDashboard.putBoolean("Flor", b_flor);
    }
  }

  public void DockShift(){
    if (!b_shift){
      RobotMap.dockshift.set(Value.kForward);
      b_shift = true;
      SmartDashboard.putBoolean("DockShift", b_shift);
    }
    else if (b_shift){
      RobotMap.dockshift.set(Value.kReverse);
      b_shift = false;
      SmartDashboard.putBoolean("DockShift", b_shift);
    }
    else{
      RobotMap.dockshift.set(Value.kOff);
      b_shift = false;
      SmartDashboard.putBoolean("DockShift", b_shift);
    }
  }
}
