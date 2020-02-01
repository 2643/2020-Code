/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.sensors.PigeonIMU;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class RotateX extends CommandBase {

  private double angle;

  public RotateX(int a) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
    angle = a;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Creates a new instance of PigeonIMU
    PigeonIMU gyro = new PigeonIMU(0);

    // Reset the drivetrain encoders
    RobotContainer.drivetrain.resetLeftEncoder();
    RobotContainer.drivetrain.resetRightEncoder();
    RobotContainer.drivetrain.setRightMotorPosition(-Constants.rotateX());
    RobotContainer.drivetrain.setLeftMotorPosition(Constants.rotateX());

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
      RobotContainer.drivetrain.setLeftMotorSpeed(0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //TODO Make sure if logic works 
    if((RobotContainer.drivetrain.getLeftMotorEncoder() == Constants.rotate180) && (RobotContainer.drivetrain.getRightMotorEncoder() == Constants.rotatex()))
      return true;    
    return false;
  }
}
