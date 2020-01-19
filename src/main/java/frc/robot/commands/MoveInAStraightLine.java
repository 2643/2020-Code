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

public class MoveInAStraightLine extends CommandBase {
  double rotationsForward; 

  /**
   * Creates a new MoveForward.
   */
  public MoveInAStraightLine(double rotations) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);

    rotationsForward = rotations;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.drivetrain.resetLeftEncoder();
    RobotContainer.drivetrain.resetRightEncoder(); 

    RobotContainer.drivetrain.setLeftMotorPosition(rotationsForward);
    RobotContainer.drivetrain.setRightMotorPosition(rotationsForward);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(RobotContainer.drivetrain.getLeftMotorEncoder() + " " + RobotContainer.drivetrain.getRightMotorEncoder());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {    
      RobotContainer.drivetrain.setLeftMotorSpeed(0);
      RobotContainer.drivetrain.setRightMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    //TODO test the logic for stopping forward/backward movement
    if((Math.abs(RobotContainer.drivetrain.getLeftMotorEncoder()) <= (rotationsForward + Constants.allowedError)) && (Math.abs(RobotContainer.drivetrain.getLeftMotorEncoder()) >= (rotationsForward - Constants.allowedError))){
      if((Math.abs(RobotContainer.drivetrain.getRightMotorEncoder()) <= (rotationsForward + Constants.allowedError)) && (Math.abs(RobotContainer.drivetrain.getRightMotorEncoder()) >= (rotationsForward - Constants.allowedError))){
        System.out.println("finished");
        return true; 
      }
    }
    return false; 
  }
}
