/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.CajaDer;
import frc.robot.commands.CajaIn;
import frc.robot.commands.CajaIzq;
import frc.robot.commands.CajaOut;
import frc.robot.commands.CajaStop;
import frc.robot.commands.ChassisDrive;
import frc.robot.commands.DockShiftCommand;
import frc.robot.commands.DriveStop;
import frc.robot.commands.ElevatorDown;
import frc.robot.commands.ElevatorStay;
import frc.robot.commands.ElevatorStop;
import frc.robot.commands.ElevatorUp;
import frc.robot.commands.FlorCommand;
import frc.robot.commands.LEDSCommand;
import frc.robot.commands.LEDSOff;
import frc.robot.commands.LEDSOn;
import frc.robot.commands.PIDStraight;
import frc.robot.commands.PIDTurn;
import frc.robot.commands.PRUEBA;
import frc.robot.commands.PistonCommand;
import frc.robot.commands.PistonGroupIN;
import frc.robot.commands.PistonGroupOUT;
import frc.robot.commands.VisionAutonomo;
import frc.robot.commands.VisionAutonomo2;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.VisionCommandGroup;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
 
  public Joystick nav = new Joystick(0);
  Button aBut = new JoystickButton(nav, 1);
  Button bBut = new JoystickButton(nav, 2);
  Button xBut = new JoystickButton(nav, 3);
  Button yBut = new JoystickButton(nav, 4);
  Button LB = new JoystickButton(nav, 5);
  Button RB = new JoystickButton(nav, 6);
  Button select = new JoystickButton(nav, 7);
  Button start = new JoystickButton(nav, 8);
  Button LS = new JoystickButton(nav, 9);
  Button RS = new JoystickButton(nav, 10);
  POVButton LeftD = new POVButton(nav, 270);
  POVButton UpD = new POVButton(nav, 0);
  POVButton RightD = new POVButton(nav, 90);
  POVButton DownD = new POVButton(nav, 180);
  

  public OI(){
    //Neumatica
    LS.whenPressed(new DockShiftCommand());

    LB.whileHeld(new PistonGroupOUT());
    LB.whenReleased(new PistonGroupIN());

    //Caja
    aBut.whileHeld(new CajaIn());
    aBut.whenReleased(new CajaStop());

    bBut.whileHeld(new CajaDer());
    bBut.whenReleased(new CajaStop());

    xBut.whileHeld(new CajaIzq());
    xBut.whenReleased(new CajaStop());

    yBut.whileHeld(new CajaOut());
    yBut.whenReleased(new CajaStop());

    //Elevador
    RB.whileHeld(new ElevatorStay());
    RB.whenReleased(new ElevatorStop());
    
    //LEDS
    RS.whenPressed(new LEDSCommand());

    //PID 
    RightD.whenPressed(new PIDTurn(90,2));
    DownD.whenPressed(new PIDTurn(180,2));
    LeftD.whenPressed(new PIDTurn(-90,1.7));
    
    UpD.whileHeld(new PIDStraight());
    UpD.whenReleased(new ChassisDrive());

    //AUTONOMO(?)
    select.toggleWhenPressed(new VisionAutonomo());
    start.toggleWhenPressed(new VisionAutonomo2());
    
  }
}
