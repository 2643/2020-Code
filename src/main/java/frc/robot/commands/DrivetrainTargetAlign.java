package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DrivetrainTargetAlign extends CommandBase {
  
  private boolean finished = false;

  public DrivetrainTargetAlign() {
    addRequirements(RobotContainer.drivetrain);
  }
  
  @Override
  public void initialize() {
  }

  @Override
  protected void execute() {
    boolean [] movement = Constants.visionTable.getEntry("movement_array");

    System.out.println("Turn left: "+movement[0]+", Turn right: "+movement[1]+", Move Back: "+movement[2]+", Move Forwards: "+movement[3]);

    if (movement[0] == true){
      // Turn Left
      RobotContainer.drivetrain.setLeftMotorSpeed(-0.3);
      RobotContainer.drivetrain.setRightMotorSpeed(0.3);
    }

    if (movement[1] == true){
      // Turn Right
      RobotContainer.drivetrain.setLeftMotorSpeed(0.3);
      RobotContainer.drivetrain.setRightMotorSpeed(-0.3);
    }

    if (movement[2] == true){
      // Move backwards
      RobotContainer.drivetrain.setLeftMotorSpeed(-0.3);
      RobotContainer.drivetrain.setRightMotorSpeed(-0.3);
    }

    if (movement[3] == true){
      // Move forwards
      RobotContainer.drivetrain.setLeftMotorSpeed(0.3);
      RobotContainer.drivetrain.setRightMotorSpeed(0.3);
    }

    finished = true;
  }

  @Override
  protected void end(boolean interrupted) {
    RobotContainer.drivetrain.setLeftMotorSpeed(0);
    RobotContainer.drivetrain.setRightMotorSpeed(0);
  }

  @Override
  protected boolean isFinished() {
    if (finished == true) {
    return true;
    }

    else {
      return false;
    }
  }
}


