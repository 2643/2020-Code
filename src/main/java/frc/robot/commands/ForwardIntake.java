/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ForwardIntake extends CommandBase {

  public ForwardIntake() {
    addRequirements(RobotContainer.intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    // Starts the intake
    RobotContainer.intake.intake();
  }

  @Override
  public void end(boolean interrupted) {
    // Stops the intake
    RobotContainer.intake.stopIntake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
