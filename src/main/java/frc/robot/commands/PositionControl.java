// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.RobotContainer;

// public class PositionControl extends CommandBase {
//   String theColor; 
//   String destColor; 

//   /**
//    * Creates a new PositionControl.
//    */
//   public PositionControl() {
//     // Use addRequirements() here to declare subsystem dependencies.
//     addRequirements(RobotContainer.frictionWheel);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     destColor = Constants.colorString;

//     if (destColor.equals("Yellow")){
//       destColor = "Green";
//     }else if (destColor.equals("Blue")){
//       destColor = "Red";
//     }else if (destColor.equals("Green")){
//       destColor = "Yellow";
//     }else if (destColor.equals("Red")){
//       destColor = "Blue";
//     }
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     theColor = RobotContainer.frictionWheel.getColor();
    
//     RobotContainer.frictionWheel.setMotorSpeed(0.3);  
//     //0.3 is too fast because of intertia, 0.1 is too slow
//     //Number being set on friction wheel
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     RobotContainer.frictionWheel.setMotorSpeed(0);
//     RobotContainer.frictionWheel.stop();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     if(theColor.equals(destColor)){
//       return true;
//     } 
//     return false;
//   }
// }
