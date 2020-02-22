package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AimShooterRPM extends CommandBase {

    private boolean finished = false;
    private int shooterRPM;
    private double XfromTarget = RobotContainer.tfmini.getDistance();

    public AimShooterRPM() {
        addRequirements(RobotContainer.shooter);
        addRequirements(RobotContainer.tfmini);
    }

    @Override
    public void initialize() {
    }    
    
    @Override
    public void execute() {
        double MaxshooterRPM = (1.14 * XfromTarget) + 1513;
        double MinshooterRPM = (1.27 * XfromTarget) + 1074;
        shooterRPM = (MaxshooterRPM + MinshooterRPM) / 2;
        RobotContainer.shooter.spinMotors(shooterRPM);
        finished = true;
    }

    @Override
    public void end (boolean interrupted) {
        RobotContainer.shooter.spinMotors(0);
    }

    @Override
    public boolean isFinished() {
        if (finished){
            return true;
        }
        else {
            return false;
        }
    }
}


