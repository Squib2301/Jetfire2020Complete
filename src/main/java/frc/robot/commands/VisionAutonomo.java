/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionAutonomo extends CommandGroup {
  /**
   * Add your docs here.
   */
  public VisionAutonomo() {
    //addSequential(new PIDStraight(),2);
    addSequential(new PIDTurn(-90,2));
    addParallel(new PistonCommand(.5));
    addSequential(new VisionCommand(2.5));
    addSequential(new PIDStraight(),5);
  }
}
