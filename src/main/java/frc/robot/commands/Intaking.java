/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Intaking extends CommandBase {

  public boolean finished = false;
  public int lastIRActivated = 0;

  /**
   * Creates a new Indexing.
   */
  public Intaking() {
    // TODO Add required subsystem
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(RobotContainer.intake);
    addRequirements(RobotContainer.conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(RobotContainer.intake.isBallThere() == false){
      finished = true;
    }

    lastIRActivated = RobotContainer.conveyorBelt.lastIndex();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){

    RobotContainer.intake.setIntakeSpeed();

    if(RobotContainer.intake.isBallThere() == true && lastIRActivated != 4){
      RobotContainer.conveyorBelt.setConveyorBeltSpeed();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    finished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(RobotContainer.conveyorBelt.getConveyorIRs()[lastIRActivated + 1].get() == true && lastIRActivated != 4){ //TODO fix logic error
      finished = true;
    }
    return finished;
  }
}
