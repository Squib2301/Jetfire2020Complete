/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorCommand;

/**
 * Add your docs here.
 */
public class Elevador extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorCommand());
  }

  public void ElevatorDown(){
    RobotMap.elevIzq.set(-0.15);
    RobotMap.elevDer.set(0.15);
  }
  public void ElevatorStay(){
    RobotMap.elevIzq.set(0.3);
    RobotMap.elevDer.set(-0.3);
  }
  public void ElevatorUp(){
    RobotMap.elevIzq.set(0.7);
    RobotMap.elevDer.set(-0.7);

  }
  public void ElevatorSTOP(){
    RobotMap.elevIzq.set(0);
    RobotMap.elevDer.set(0);
  }

  public void ElevatorTriggers(){
    //UP
    RobotMap.elevIzq.set(Robot.m_oi.nav.getRawAxis(3)*0.7);
    RobotMap.elevDer.set(Robot.m_oi.nav.getRawAxis(3)*-0.7);
    //DOWN
    RobotMap.elevIzq.set(Robot.m_oi.nav.getRawAxis(2)*-0.15);
    RobotMap.elevDer.set(Robot.m_oi.nav.getRawAxis(2)*0.15);
  }
}
