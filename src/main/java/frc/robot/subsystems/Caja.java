/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Caja extends Subsystem {
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void CajaInside(){
    RobotMap.caja01.set(-0.3);
    RobotMap.caja02.set(0.3);
  }
  public void CajaOutside(){
    RobotMap.caja01.set(0.3);
    RobotMap.caja02.set(-0.3);
  }
  public void CajaDerecha(){
    RobotMap.caja01.set(0.3);
    RobotMap.caja02.set(0.3);
  }
  public void CajaIzquierda(){
    RobotMap.caja01.set(-0.3);
    RobotMap.caja02.set(-0.3);
  }
  public void CajaStop(){
    RobotMap.caja01.set(0);
    RobotMap.caja02.set(0);
  }
}
