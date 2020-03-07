package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TurretAlign extends CommandBase {

  private boolean[] defaultArray = {false, false, false, false};
  private boolean[] movement;
  private double x_offset; 
  private double x_offset_temp; 
  private double target; 

  public TurretAlign() {
    addRequirements(RobotContainer.turret);
  }

  @Override
  public void initialize() {
    movement = Constants.visionTable.getEntry("movement_array").getBooleanArray(defaultArray);
    x_offset_temp = (double)Constants.visionTable.getEntry("2020-High-Target_x_offset").getNumber(0);
    
    target = RobotContainer.turret.getPosition() - (x_offset_temp/-10);
  }

  @Override
  public void execute() {
    movement = Constants.visionTable.getEntry("movement_array").getBooleanArray(defaultArray);
    x_offset = (double)Constants.visionTable.getEntry("2020-High-Target_x_offset").getNumber(0);

    // System.out.println("Turn left: " + movement[0] + ", Turn right: " + movement[1] + ", Move Back: " + movement[2] + ", Move Forwards: " + movement[3]);
    System.out.println("X offset " + x_offset + ", Position " + RobotContainer.turret.getPosition());
    //I think we always have to set the same target, because we did this before when testing just Smart Motion on the turret before
    RobotContainer.turret.aimTurret(target); 

    if (movement[0] == true){
      // Turn Left
      // RobotContainer.drivetrain.setLeftMotorSpeed(-0.3);
      // RobotContainer.drivetrain.setRightMotorSpeed(0.3);

      // RobotContainer.turret.aimTurret(RobotContainer.turret.getPosition()+10);

      // RobotContainer.turret.moveTurretLeft();
    }

    if (movement[1] == true){
      // Turn Right
      // RobotContainer.drivetrain.setLeftMotorSpeed(0.3);
      // RobotContainer.drivetrain.setRightMotorSpeed(-0.3);

      // RobotContainer.turret.aimTurret(RobotContainer.turret.getPosition()-10);

      // RobotContainer.turret.moveTurretRight();
    }

    if (movement[2] == true){
      // Move backwards
      // RobotContainer.drivetrain.setLeftMotorSpeed(-0.3);
      // RobotContainer.drivetrain.setRightMotorSpeed(-0.3);
    }

    if (movement[3] == true){
      // Move forwards
      // RobotContainer.drivetrain.setLeftMotorSpeed(0.3);
      // RobotContainer.drivetrain.setRightMotorSpeed(0.3);
    }

  }

  @Override
  public void end(boolean interrupted) {
    // RobotContainer.drivetrain.setLeftMotorSpeed(0);
    // RobotContainer.drivetrain.setRightMotorSpeed(0);
    
    // RobotContainer.turret.aimTurret(lastPosition);
  }

  // Returns true when the command should end
  @Override
  public boolean isFinished() {
   if(x_offset <= 1 && x_offset >=-1){
     System.out.println("Finished " + x_offset);
     return true; 
   }else{
     return false; 
   } 
  }
}


