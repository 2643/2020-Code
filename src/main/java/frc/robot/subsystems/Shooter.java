/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  //one talonfx motor for the shooter
  //one neo 550 for the turret
  //three limit switches for the turret
  //one motor (?) for the hood on the shooter
  public static TalonFX leftShooterMotor = new TalonFX(Constants.leftShooterMotorPort);
  public static TalonFX rightShooterMotor = new TalonFX(Constants.rightShooterMotorPort);
  public static CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorPort, MotorType.kBrushless);
  public static CANSparkMax turretMotor = new CANSparkMax(Constants.turretMotorPort, MotorType.kBrushless);

  public static DigitalInput leftLimitSwitch = new DigitalInput(Constants.leftLimitSwitchPort);
  public static DigitalInput centreLimitSwitch = new DigitalInput(Constants.centreLimitSwitchPort);
  public static DigitalInput rightLimitSwitch = new DigitalInput(Constants.rightLimitSwitchPort);

    // Sets the PID and FF variables
    double kP = 0.00016;//0.006;
    double kI = 0;//0.000002;
    double kD = 0;//0.004;//0.2;
    double kFF = 0.000156;
  
    // Sets the max and min output for the motor speed
    double MaxOutput = 1;
    double MinOutput = -1;
  
    // Sets the max acceleration for the motors
    double maxAccel = 3000;
    int slotID = 0;
    int maxVel = 7000;
    int minVel = 0;
  
    double allowedErr = 0.1;
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    hoodMotor.getPIDController().setP(kP, slotID);
    hoodMotor.getPIDController().setI(kI, slotID);
    hoodMotor.getPIDController().setD(kD, slotID);
    hoodMotor.getPIDController().setFF(kFF, slotID);
    hoodMotor.getPIDController().setOutputRange(MinOutput, MaxOutput, slotID);
    hoodMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    hoodMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    hoodMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);
    hoodMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel, slotID);

    turretMotor.getPIDController().setP(kP, slotID);
    turretMotor.getPIDController().setI(kI, slotID);
    turretMotor.getPIDController().setD(kD, slotID);
    turretMotor.getPIDController().setFF(kFF, slotID);
    turretMotor.getPIDController().setOutputRange(MinOutput, MaxOutput, slotID);
    turretMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    turretMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    turretMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);
    turretMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel, slotID);

  }
public void spinMotors(final double speed){
  leftShooterMotor.set(ControlMode.PercentOutput, speed);//TODO Check direction for both motors
  rightShooterMotor.set(ControlMode.PercentOutput, -speed);
}
public void moveHood(final double position){
hoodMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID);
}
public void aimHood(final double position){
  if(leftLimitSwitch.get() == true || rightLimitSwitch.get() == true){
    turretMotor.set(0);
  }
  else{
    turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID);
  }
//TODO make it possible to turn certain angles
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
