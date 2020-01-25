/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ChassisDrive;
import edu.wpi.first.wpilibj.Timer;

public class Chassis extends PIDSubsystem {

  // Encoder Variables
  public double encoderAverage;

  // NavX
  public AHRS NavX = new AHRS(SPI.Port.kMXP);
  
  // Differential Drive
  DifferentialDrive m_Drive = new DifferentialDrive(RobotMap.leftMotor, RobotMap.rightMotor);

  // PID Variables
  double rotate;

  // Acceleration Variables
  double previousX = 0;
	double dx = 0.3;

	double previousY = 0;
	double dy = 0.3;

	double maxX = 0.85;
  double maxY = 0.95;

  //VISION
  public NetworkTableEntry yaw_angle;
  public double RPIangle;
  public double PreviousRPIangle;
    
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ChassisDrive());
  }

  // PID Genesis
  public Chassis() {
    super("Chassis", 0.1, 0.01, 0.3);
    getPIDController().setAbsoluteTolerance(2.0f);
    getPIDController().setInputRange(-180.0f, 180.0f);
    getPIDController().setContinuous(true);
    getPIDController().setOutputRange(-1.0, 1.0);
    getPIDController().disable();
  }

  // PID Entry Point
  protected double returnPIDInput() {
    return NavX.getYaw();
}

// Result of PID
protected void usePIDOutput(double output) {
  rotate = output;
}

// Teleop Drive
public void Drive(Joystick manejator) {
  // Restict Y
  double y = Robot.m_oi.nav.getRawAxis(1) * maxY;
  if (y > previousY + dy) {
    y = previousY + dy;
  } else if (y < previousY - dy) {
    y = previousY - dy;
  }
  previousY = y;
  // Restrict X
  double x = Robot.m_oi.nav.getRawAxis(4) * maxX;
  if (x > previousX + dx) {
    x = previousX + dx;
  } else if (x < previousX - dx) {
    x = previousX - dx;
  }
  previousX = x;

  m_Drive.arcadeDrive(y, x);
  getPIDController().disable();
  Timer.delay(0.005);
  }

  // PID Turn
  public void Turn(double setpoint) {
    if (!getPIDController().isEnabled()) {
		NavX.reset();
      rotate = 0;
      getPIDController().setSetpoint(setpoint);
      getPIDController().enable();
    }
    double rotationValue = rotate;
    m_Drive.arcadeDrive(0, rotationValue*maxY);
  }

  // PID Drive Straight
  public void DriveStraight() {
    if (!getPIDController().isEnabled()) {
      NavX.reset();
      rotate = 0;
      getPIDController().setSetpoint(NavX.getYaw());
      getPIDController().enable();
    }
    double rotationValue = rotate;
    //m_Drive.arcadeDrive(Robot.m_oi.nav.getRawAxis(1)*maxY, rotationValue*maxX);
    m_Drive.arcadeDrive(-0.6, rotationValue*maxX);
  }
    public void DriveBack() {
    if (!getPIDController().isEnabled()) {
      NavX.reset();
      rotate = 0;
      getPIDController().setSetpoint(NavX.getYaw());
      getPIDController().enable();
    }
    double rotationValue = rotate;
    //m_Drive.arcadeDrive(Robot.m_oi.nav.getRawAxis(1)*maxY, rotationValue*maxX);
    m_Drive.arcadeDrive(0.6, rotationValue*maxX);
  }  

  // Chassis Full Stop
  public void DriveStop() {
    m_Drive.arcadeDrive(0, 0);
    getPIDController().disable();
  }

  //VISION COMMANDS
  public void Vision(){
    if (!getPIDController().isEnabled()){
      RPIangle = yaw_angle.getDouble(0.0);
      NavX.reset();
      PreviousRPIangle = RPIangle;
      rotate = 0;
      getPIDController().setSetpoint(PreviousRPIangle-5.28);
      getPIDController().enable();
    }
    double rotationValue = rotate;
    m_Drive.arcadeDrive(0.0, rotationValue*maxY);
  }
}
