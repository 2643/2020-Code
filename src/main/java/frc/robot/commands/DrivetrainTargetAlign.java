import edu.wpi.first.wplibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DrivetrainTargetAlign {

  public DrivetrainTargetAlign() {
    requires(Robot.drive);
  }

  @Override
  protected void interrupted() {
    end();
  }

  @Override
  protected void end() {
    Robot.drive.setAllSpeed(0, 0);
  }

  @Override
  protected boolean isFinished() {
    return Robot.drive.isStuck();
  }
}

// TODO Literlly write all the code, DW it will get done...



