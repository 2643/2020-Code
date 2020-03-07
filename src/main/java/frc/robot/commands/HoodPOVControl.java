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

public class HoodPOVControl extends CommandBase {
  private boolean pressed1 = false;
  private boolean pressed2 = false; 
  private double[] position = {1, 5, 10, 15, 20, 25};

  /**
   * Creates a new HoodPOVControl.
   */
  public HoodPOVControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.driveStick.getPOV()==0){
      if(!pressed1){
        if (Constants.hoodIndex >= 0 && Constants.hoodIndex < position.length-1) {
          Constants.hoodIndex++; 
          RobotContainer.hood.moveHood(position[Constants.hoodIndex]);
        }
        pressed1 = true;
      }
      else{
        pressed1 = false; 
      }
    }

    if(RobotContainer.driveStick.getPOV() == 180){
      if(!pressed2){
        if(Constants.hoodIndex > 0 && Constants.hoodIndex <= position.length-1){
          Constants.hoodIndex--;
          RobotContainer.hood.moveHood(position[Constants.hoodIndex]);
        }
        pressed2 = true;
      }else{
        pressed2 = false; 
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
