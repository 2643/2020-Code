/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Rotate90 extends CommandBase {
  String direction;
  String compare;

  /**
   * Creates a new Rotate.
   */
  public Rotate90(String Which) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
    direction = Which;
    compare = "Left";

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.drivetrain.resetLeftEncoder();
    RobotContainer.drivetrain.resetRightEncoder();
    if ((direction.compareToIgnoreCase(compare)) == 0) {
      RobotContainer.drivetrain.setRightMotorPosition(-Constants.rotate90Left);
      RobotContainer.drivetrain.setLeftMotorPosition(Constants.rotate90Left);
    } else {
      RobotContainer.drivetrain.setRightMotorPosition(-Constants.rotate90Right);
      RobotContainer.drivetrain.setLeftMotorPosition(Constants.rotate90Right);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.setLeftMotorPosition(RobotContainer.drivetrain.getLeftMotorEncoder());
    RobotContainer.drivetrain.setRightMotorPosition(RobotContainer.drivetrain.getRightMotorEncoder());

    if (interrupted == true) {
      RobotContainer.drivetrain.setLeftMotorSpeed(0);
      RobotContainer.drivetrain.setLeftMotorSpeed(0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO Make sure if logic works
    if ((RobotContainer.drivetrain.getLeftMotorEncoder() == Constants.rotate90Left)
        && (RobotContainer.drivetrain.getRightMotorEncoder() == Constants.rotate90Left))
      return true;
    return false;
  }
}
