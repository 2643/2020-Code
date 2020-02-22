package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AimShooterAngle extends CommandBase {

    private boolean finished = false;
    private int hoodAngle;
    private float XfromTarget = RobotContainer.tfmini.getDistance();

    public AimShooterAngle() {
        addRequirements(RobotContainer.shooter);
        addRequirements(RobotContainer.tfmini);
    }

    @Override
    public void initialize() {
    }    
    
    @Override
    public void execute() {
        
    }

    @Override
    public void end (boolean interrupted) {
        RobotContainer.shooter.stopMotor(); 
    }

    @Override
    public boolean isFinished() {

    }
}


