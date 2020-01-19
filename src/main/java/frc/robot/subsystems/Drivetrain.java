/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private static CANSparkMax leftFrontMotor = new CANSparkMax(Constants.leftFrontMotorPort, MotorType.kBrushless);
  private static CANSparkMax leftBackMotor = new CANSparkMax(Constants.leftBackMotorPort, MotorType.kBrushless);

  private static CANSparkMax rightFrontMotor = new CANSparkMax(Constants.rightFrontMotorPort, MotorType.kBrushless);
  private static CANSparkMax rightBackMotor = new CANSparkMax(Constants.rightBackMotorPort, MotorType.kBrushless);


  // Sets the PID and FF variables
  double kP = 0.006;
  double kI = 0.000002;
  double kD = 0.2;
  double kFF = 0.000156;

  // Sets the max and min output for the motor speed
  double MaxOutput = 1;
  double MinOutput = -1;

  // Sets the max acceleration for the motors
  double maxAccel = 50;
  int slotID = 0;
  int maxVel = 100;

  double allowedErr = 0.05;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    // Set the PID Controller for Left Front Motor
    leftFrontMotor.getPIDController().setP(kP);
    leftFrontMotor.getPIDController().setI(kI);
    leftFrontMotor.getPIDController().setD(kD);
    leftFrontMotor.getPIDController().setFF(kFF);
    leftFrontMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    leftFrontMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    leftFrontMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    leftFrontMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);

    // Set the PID Controller for Left Back Motor
    leftBackMotor.getPIDController().setP(kP);
    leftBackMotor.getPIDController().setI(kI);
    leftBackMotor.getPIDController().setD(kD);
    leftBackMotor.getPIDController().setFF(kFF);
    leftBackMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    leftBackMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    leftBackMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    leftBackMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);

    // Set the PID Controller for Right Front Motor
    rightFrontMotor.getPIDController().setP(kP);
    rightFrontMotor.getPIDController().setI(kI);
    rightFrontMotor.getPIDController().setD(kD);
    rightFrontMotor.getPIDController().setFF(kFF);
    rightFrontMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    rightFrontMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    rightFrontMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    rightFrontMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);

    // Set the PID Controller for Right Back Motor
    rightBackMotor.getPIDController().setP(kP);
    rightBackMotor.getPIDController().setI(kI);
    rightBackMotor.getPIDController().setD(kD);
    rightBackMotor.getPIDController().setFF(kFF);
    rightBackMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    rightBackMotor.getPIDController().setSmartMotionMaxAccel(maxAccel, slotID);
    rightBackMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr, slotID);
    rightBackMotor.getPIDController().setSmartMotionMaxVelocity(maxVel, slotID);

    // Sets the back motors to follow the front motors
    // leftBackMotor.follow(leftFrontMotor);
    // rightBackMotor.follow(rightFrontMotor);

  }

  /**
   * Gets the encoder position of the left side of the drivetrain
   * 
   * @return double rotations
   */
  public double getLeftMotorEncoder() {
    return leftFrontMotor.getEncoder().getPosition();
  }

  /**
   * Gets the encoder position of the right side of the drivetrain
   * 
   * @return double rotations
   */
  public double getRightMotorEncoder() {
    return rightFrontMotor.getEncoder().getPosition();
  }

  /**
   * Sets the speed of the left side motors using Duty Cycle
   * 
   * @param speed from -1 to 1, speed to set motor
   */
  public void setLeftMotorSpeed(double speed) {
    leftFrontMotor.getPIDController().setReference(-speed, ControlType.kDutyCycle);
    leftBackMotor.getPIDController().setReference(-speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the right side motors using Duty Cycle
   * 
   * @param speed -1 to 1, speed to set motor
   */
  public void setRightMotorSpeed(double speed) {
    rightFrontMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
    rightBackMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the drivetrain using Duty Cycle
   * 
   * @param speed -1 to 1, speed to set motor
   */
  public void setMotorSpeed(double speed) {
    setLeftMotorSpeed(speed);
    setRightMotorSpeed(speed);
  }

  /**
   * Sets the position of the left side of the drivetrain using Position
   * 
   * @param rotations
   */
  public void setLeftMotorPosition(double rotations) {
    leftFrontMotor.getPIDController().setReference(rotations, ControlType.kPosition);
    leftBackMotor.getPIDController().setReference(rotations,ControlType.kPosition);
  }

  /**
   * Sets the position of the right side of the drivetrain using Position
   * 
   * @param rotations
   */
  public void setRightMotorPosition(double rotations) {
    rightFrontMotor.getPIDController().setReference(-rotations, ControlType.kPosition);
    rightBackMotor.getPIDController().setReference(-rotations,ControlType.kPosition);
  }

  public void setAllMotorPosition(double rotations) {
    setRightMotorPosition(rotations);
    setLeftMotorPosition(rotations);
  }

  /**
   * Resets the left encoder
   */
  public void resetLeftEncoder() {
    leftFrontMotor.getEncoder().setPosition(0);
    leftBackMotor.getEncoder().setPosition(0);
  }

  /**
   * Resets the right encoder
   */
  public void resetRightEncoder() {
    rightFrontMotor.getEncoder().setPosition(0);
    rightBackMotor.getEncoder().setPosition(0);
  }

  public void resetAllEncoder() {
    resetLeftEncoder();
    resetRightEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
