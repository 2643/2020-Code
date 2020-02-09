/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//turns the wheel 7 times over a singular color

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class InitFrictionWheelRotation extends CommandBase {
  int x=0;
  Timer timer = new Timer();
  /**
   * Creates a new InitFrictionWheelRotation.
   */
  public InitFrictionWheelRotation() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    x=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //make it pass 7 times over one color
    if(x<7){
      if(RobotContainer.frictionWheel.getColor().equals("Green")){
        x+=1;
      }
      RobotContainer.frictionWheel.setMotorSpeed(Constants.frictionWheelSpeed);
    }
    // x=0;
    // if(x<5){
    //   x+=1;
    //   if(!RobotContainer.frictionWheel.shiftColor().equals(Constants.frictionWheelInputColor)){
    //     RobotContainer.frictionWheel.setMotorSpeed(Constants.frictionWheelSpeed);
    //   }else{
    //     RobotContainer.frictionWheel.setMotorSpeed(0);
    //   }
    // }
    x=10;
  }
    
    

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
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
