import frc.robot.commands.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class DrivetrainTargetAlign {

  public DrivetrainTargetAlign() {
    requires(Robot.drive);
  }

  @Override
  protected void execute() {
    boolean [] movement = RobotMap.visionTable.getEntry("movement_array");
    System.out.println("Turn left: "+movement[0]+", Turn right: "+movement[1]+", Move Back: "+movement[2]+", Move Forwards: "+movement[3]);

    if (haveToMove == true) {
      if (movement_array[0] == true){
        RotateX(5);
      }

      if (movement_array[1] == true){
        RotateX(-5);
      }

      if (movement_array[2] == true){

      }

      if (movement_array[3] == true){

      }
    }
  }

  @Override
  protected void end() {
    Robot.drive.setAllSpeed(0, 0);
  }

  @Override
  protected void interrupted() {
    end();
  }

  @Override
  protected boolean isFinished() {
    return Robot.drive.isStuck();
  }
}

// TODO Literlly write all the code, DW it will get done...



