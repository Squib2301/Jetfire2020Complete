/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Relay;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //CHASSIS
  public static PWMVictorSPX leftMotor = new PWMVictorSPX(1);
  public static PWMVictorSPX rightMotor = new PWMVictorSPX(0);

  //ELEVADOR
  public static PWMVictorSPX elevIzq = new PWMVictorSPX(6);
  public static PWMVictorSPX elevDer = new PWMVictorSPX(5);

  //NEUMATICA
  public static DoubleSolenoid piston = new DoubleSolenoid(0, 1);
  public static DoubleSolenoid flor = new DoubleSolenoid(2, 3);
  public static DoubleSolenoid dockshift = new DoubleSolenoid(4, 5);

  //CAJA
  public static PWMVictorSPX caja01 = new PWMVictorSPX(2);
  public static PWMVictorSPX caja02 = new PWMVictorSPX(3);

  //Relay
  public static Relay LEDS = new Relay(0);
}
