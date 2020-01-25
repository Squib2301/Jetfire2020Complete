/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Caja;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Elevador;
import frc.robot.subsystems.Misc;
import frc.robot.subsystems.Neumatica;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Timer timer = new Timer();
  public static Compressor comp = new Compressor();
  public static OI m_oi;
  public static Neumatica m_neumatica = new Neumatica();
  public static Caja m_caja = new Caja();
  public static Elevador m_elevador = new Elevador();
  public static Chassis m_chassis = new Chassis();
  public static Misc m_misc = new Misc();

  public static UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
  Command m_autonomousCommand;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
      //Network Table Setup
      NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
      NetworkTable table = ntinst.getTable("tablaCool");
      m_chassis.yaw_angle = table.getEntry("YawAngle");
      m_chassis.yaw_angle.setDefaultDouble(0);
    //TIMER
    timer.reset();
    timer.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    comp.setClosedLoopControl(true);
    //Vision Values Display
    m_chassis.RPIangle = m_chassis.yaw_angle.getDouble(0.0);
    SmartDashboard.putNumber("Heading", m_chassis.NavX.getYaw());
    SmartDashboard.putNumber("Raspberry Angle", m_chassis.RPIangle);
    SmartDashboard.putNumber("Previous Raspberry Angle", m_chassis.PreviousRPIangle);
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
