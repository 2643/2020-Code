// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.ControlType;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;
// import frc.robot.RobotContainer;

// public class Hood extends SubsystemBase {
//   private static CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorPort, MotorType.kBrushless);
//   private static DigitalInput hoodLimit = new DigitalInput(Constants.hoodLimitPort); //TODO incorporate soft limits for the hood

//   //Hood PID Constants
//   double kP_hood = 0.00016;//0.006;
//   double kI_hood = 0;//0.000002;
//   double kD_hood = 0;//0.004;//0.2;
//   double kFF_hood = 0.000156;
//   double MaxOutput_hood = 1;
//   double MinOutput_hood = -1;
//   double maxAccel_hood = 3000;
//   int slotID_hood = 0;
//   int maxVel_hood = 7000;
//   int minVel_hood = 0;
//   double allowedErr_hood = 0.1;
//   int index = 0;
//   double[] position = {1, 2, 3, 4};//TODO add specific encoder ticks for the hood to turn to
//   /**
//    * Creates a new Hood.
//    */
//   public Hood() {
//     hoodMotor.getPIDController().setP(kP_hood, slotID_hood);
//     hoodMotor.getPIDController().setI(kI_hood, slotID_hood);
//     hoodMotor.getPIDController().setD(kD_hood, slotID_hood);
//     hoodMotor.getPIDController().setFF(kFF_hood, slotID_hood);
//     hoodMotor.getPIDController().setOutputRange(MinOutput_hood, MaxOutput_hood, slotID_hood);
//     hoodMotor.getPIDController().setSmartMotionMaxAccel(maxAccel_hood, slotID_hood);
//     hoodMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr_hood, slotID_hood);
//     hoodMotor.getPIDController().setSmartMotionMaxVelocity(maxVel_hood, slotID_hood);
//     hoodMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel_hood, slotID_hood);
//   }

//   /**
//    * Moves hood to shoot at certain angle
//    * @param position angle for the hood
//    */
//   public void moveHood(double position){ //TODO add functionality to accept angles to move hood to
//     hoodMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_hood);
//   }

//   /**
//    * Gets the current position of the encoder
//    * @return double position
//    */
//   public double getPosition(){
//     return hoodMotor.getEncoder().getPosition();
//   }

//   /**
//    * Resets the encoder
//    * SHOULD ONLY BE USED IN ROBOTINIT
//    */
//   public void resetEncoder(){
//     hoodMotor.getEncoder().setPosition(0);
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run

//     if (RobotContainer.driveStick.getPOV()==0){
//       if (index >=0 && index<= position.length-1) {
//         index = index + 1;
//         moveHood(position[index]);
//       }
//     }
//     else if (RobotContainer.driveStick.getPOV()==180){
//       if (index >=0 && index<= position.length-1) {
//         index = index - 1;
//         moveHood(position[index]); 
//       }
//     }
//   }
// }
