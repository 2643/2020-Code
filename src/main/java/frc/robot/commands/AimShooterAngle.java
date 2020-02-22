package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SetShooter extends CommandBase {

    private boolean finished = false;
    private int hoodAngle;
    private float XfromTarget = TFMini.getDistance();

    public SetShooter() {
        addRequirements(RobotContainer.Shooter);
        addRequirements(RobotContainer.TFMini);
    }

    @Override
    public void initialize() {
    }    
    
    @Override
    public void execute() {
        
    }

    @Override
    public void end (boolean interrupted) {
        RobotContainer.Shooter.se
    }

    @Override
    public void isFinished() {

    }
}


