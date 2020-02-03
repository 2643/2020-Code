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

public class Rotate235 extends CommandBase {
  private String direction;
  private String compare;
  /**
   * Creates a new Rotate235.
   */
  public Rotate235(String Which) {
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
      RobotContainer.drivetrain.setLeftMotorPosition(Constants.rotate235Left);
      RobotContainer.drivetrain.setRightMotorPosition(-Constants.rotate235Left);
    } else {
      RobotContainer.drivetrain.setLeftMotorPosition(Constants.rotate235Right);
      RobotContainer.drivetrain.setRightMotorPosition(-Constants.rotate235Right);
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
    if(interrupted == true){
      RobotContainer.drivetrain.setLeftMotorSpeed(0);
      RobotContainer.drivetrain.setRightMotorSpeed(0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if((Math.abs(RobotContainer.drivetrain.getLeftMotorEncoder()) == Math.abs(Constants.rotate235Left)) 
    && (Math.abs(RobotContainer.drivetrain.getRightMotorEncoder()) == Math.abs(Constants.rotate235Left)))
      return true;    
    return false;
  }
}
