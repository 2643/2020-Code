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

public class Tankdrive extends CommandBase {
  double leftSpeed = 0;
  double rightSpeed = 0;
  boolean finished = false;

  /**
   * Creates a new Tankdrive.
   */
  public Tankdrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Math.abs(RobotContainer.driveStick.getRawAxis(Constants.leftAxis)) < 0.05) {
      if (Math.abs(RobotContainer.driveStick.getRawAxis(Constants.rightAxis)) < 0.05) {
        finished = true;
      }
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(RobotContainer.driveStick.getRawAxis(Constants.leftAxis)) > 0.03) {
      leftSpeed = (RobotContainer.driveStick.getRawAxis(Constants.leftAxis) * Constants.maxRPM);
    }
    else{
      leftSpeed = 0;
    }

    if (Math.abs(RobotContainer.driveStick.getRawAxis(Constants.rightAxis)) > 0.03) {
      rightSpeed = (RobotContainer.driveStick.getRawAxis(Constants.rightAxis) * Constants.maxRPM);
    }
    else{
      rightSpeed = 0;
    }
    
    RobotContainer.drivetrain.setLeftMotorSpeed(leftSpeed);
    RobotContainer.drivetrain.setRightMotorSpeed(rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.setLeftMotorSpeed(0);
    RobotContainer.drivetrain.setRightMotorSpeed(0);
    finished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
