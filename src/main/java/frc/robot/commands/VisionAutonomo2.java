/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionAutonomo2 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public VisionAutonomo2() {
    addSequential(new FlorCommand(.1));
    addSequential(new PIDBack(),2);
    addSequential(new PIDTurn(180,2));
    addSequential(new PIDStraight(),1);
    addSequential(new FlorCommand(.5));
    addSequential(new PistonCommand(.1));

  }
}
