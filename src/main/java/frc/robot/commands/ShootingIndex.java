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

public class ShootingIndex extends CommandBase {
  private int lastIRActivated = 0;
  private boolean finished = false; 

  /**
   * Creates a new ShootingIndex.
   */
  public ShootingIndex() {
    // Use addRequirements() here to declare subsystem dependencies.'
    addRequirements(RobotContainer.conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastIRActivated = RobotContainer.conveyorBelt.lastIndex();
    //If the fifth iRSensor is activated, then the command ends 
    if(lastIRActivated == 4){
      finished = true; 
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.conveyorBelt.setSpeed(Constants.conveyorBeltForwardSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.conveyorBelt.setSpeed(0);
    finished = false; 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //If the iRSensor after the one last activated is activated, the command ends.
    if(RobotContainer.conveyorBelt.getConveyorIRs()[lastIRActivated + 1].get() == true){
      finished = true; 
    }
    return finished; 
  }
}
