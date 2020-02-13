/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//turns the wheel 7 times over a singular color

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RotationControl extends CommandBase {
  int x=0;
  boolean keepgoing;
  /**
   * Creates a new RotationControl
   */
  public RotationControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.frictionWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Starting the counter
    x=0;
    keepgoing=true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //make the control panel pass 7 times over Green
    if(x<7){
      if(RobotContainer.frictionWheel.getColor().equals("Green")){
        keepgoing=true;
      }
      if(RobotContainer.frictionWheel.getColor().equals("Green") && keepgoing==true){
        x+=1;
        keepgoing=false;
      }
      RobotContainer.frictionWheel.setMotorSpeed(Constants.frictionWheelSpeed);
    }else{
      RobotContainer.frictionWheel.setMotorSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.frictionWheel.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (x==10){
      return true;
    }
    return false;
  }
}
