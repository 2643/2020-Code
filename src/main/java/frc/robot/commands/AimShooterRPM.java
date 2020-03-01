 package frc.robot.commands;

 import edu.wpi.first.wpilibj2.command.CommandBase;
 import frc.robot.Constants;
 import frc.robot.RobotContainer;
 import java.lang.Math;

 public class AimShooterRPM extends CommandBase {

     private boolean finished = false;

     public AimShooterRPM() {
         addRequirements(RobotContainer.shooter);
         addRequirements(RobotContainer.hood);
         addRequirements(RobotContainer.tfmini);
     }

     @Override
     public void initialize() {
     }

     @Override
     public void execute() {
         // Find distance from the target
         private double XfromTarget = RobotContainer.tfmini.getDistance();

         // Compute shooter RPM
         // Linear function:
         //double MaxshooterRPM = (1.14 * XfromTarget) + 1513;
         //double MinshooterRPM = (1.27 * XfromTarget) + 1074;

         // Exponential function:
         double MaxshooterRPM = 1577*(Math.exp(5.25*(10**-4)*XfromTarget));
         double MinshooterRPM = 1160*(Math.exp(7.11*(10**-4)*XfromTarget));
         double shooterRPM = (MaxshooterRPM + MinshooterRPM) / 2;

         // Compute hood angle value
         // logorithmic function
         double hoodRotation = -15.7 + 5.71*Math.log(XfromTarget);

         // Convert rotation to encoder ticks (42 ticks per rotation)
         double hoodAngle = (hoodRotation * 42);
         if (num % 5 < 2.5) {
             hoodAngle = hoodAngle - hoodAngle % 5;
         }
         else if (num % 5 > 2.5)
             hoodAngle = hoodAngle + (5 - hoodAngle % 5);

         // Shoot Bruh
         RobotContainer.hood.moveHood(hoodAngle);
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


