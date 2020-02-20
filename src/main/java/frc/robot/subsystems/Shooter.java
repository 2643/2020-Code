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

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// TODO uncomment when shooter is added to the robot
// public class Shooter extends SubsystemBase {
//   public static CANSparkMax leftShooterMotor = new CANSparkMax(Constants.leftShooterMotorPort, MotorType.kBrushless);
//   public static CANSparkMax rightShooterMotor = new CANSparkMax(Constants.rightShooterMotorPort, MotorType.kBrushless);

//   //Shooter PID Constants
//   private static final double kP = 0.00015;
//   private static final double kI = 0;
//   private static final double kD = 0;
//   private static final double kIz = 0;
//   private static final double kFF = 0.000015;
//   private static final double kMaxOutput = 1;
//   private static final double kMinOutput = -1;
//   private static final double maxRPM = 5700;
  
//   private static int slotID = 0; 
//   /**
//    * Creates a new Shooter.
//    */
//   public Shooter() {
//     leftShooterMotor.getPIDController().setP(kP, slotID);
//     leftShooterMotor.getPIDController().setI(kI, slotID);
//     leftShooterMotor.getPIDController().setD(kD, slotID);
//     leftShooterMotor.getPIDController().setIZone(kIz, slotID);
//     leftShooterMotor.getPIDController().setFF(kFF, slotID);
//     leftShooterMotor.getPIDController().setOutputRange(kMinOutput, kMaxOutput, slotID);

//     rightShooterMotor.getPIDController().setP(kP, slotID);
//     rightShooterMotor.getPIDController().setI(kI, slotID);
//     rightShooterMotor.getPIDController().setD(kD, slotID);
//     rightShooterMotor.getPIDController().setIZone(kIz, slotID);
//     rightShooterMotor.getPIDController().setFF(kFF, slotID);
//     rightShooterMotor.getPIDController().setOutputRange(kMinOutput, kMaxOutput, slotID);
//   }

//   /**
//    * Spins the motor at a given speed in RPM
//    * @param speed RPM to spin motor at
//    */
//   public void spinMotors(double speed){
//     leftShooterMotor.getPIDController().setReference(speed, ControlType.kVelocity);
//     rightShooterMotor.getPIDController().setReference(-speed, ControlType.kVelocity);
//   }


//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }
// }
