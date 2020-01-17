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

  double leftkP = 0.1; 
  double leftkI = 0;
  double leftkD = 0;
  double leftkFF = 0; 

  private static CANSparkMax rightFrontMotor = new CANSparkMax(Constants.rightFrontMotorPort, MotorType.kBrushless);
  private static CANSparkMax rightBackMotor = new CANSparkMax(Constants.rightBackMotorPort, MotorType.kBrushless);

  double rightkP = 0.1;
  double rightkI = 0;
  double rightkD = 0; 
  double rightkFF = 0;

  double MaxOutput = 0.1;
  double MinOutput = -0.1;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    leftFrontMotor.getPIDController().setP(leftkP);
    leftFrontMotor.getPIDController().setI(leftkI);
    leftFrontMotor.getPIDController().setD(leftkD);
    leftFrontMotor.getPIDController().setFF(leftkFF);
    leftFrontMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    
    leftBackMotor.getPIDController().setP(leftkP);
    leftBackMotor.getPIDController().setI(leftkI);
    leftBackMotor.getPIDController().setD(leftkD);
    leftBackMotor.getPIDController().setFF(leftkFF);
    leftBackMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);

    rightFrontMotor.getPIDController().setP(rightkP);
    rightFrontMotor.getPIDController().setI(rightkI);
    rightFrontMotor.getPIDController().setD(rightkD);
    rightFrontMotor.getPIDController().setFF(rightkFF);
    rightFrontMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);

    rightBackMotor.getPIDController().setP(rightkP);
    rightBackMotor.getPIDController().setI(rightkI);
    rightBackMotor.getPIDController().setD(rightkD);
    rightBackMotor.getPIDController().setFF(rightkFF);
    rightBackMotor.getPIDController().setOutputRange(MinOutput, MaxOutput);
    /*
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);
    */
  }

  /**
   * Gets the encoder position of the left side of the drivetrain 
   * @return double rotations
   */
  public double getLeftMotorEncoder(){
    return leftFrontMotor.getEncoder().getPosition();
  }

  /**
   * Gets the encoder position of the right side of the drivetrain
   * @return double rotations
   */
  public double getRightMotorEncoder(){
    return rightFrontMotor.getEncoder().getPosition(); 
  }

  /**
   * Sets the speed of the left side motors using Duty Cycle
   * @param speed from -1 to 1, speed to set motor
   */
  public void setLeftMotorSpeed(double speed){
    leftFrontMotor.getPIDController().setReference(-speed, ControlType.kDutyCycle);
    leftBackMotor.getPIDController().setReference(-speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the right side motors using Duty Cycle
   * @param speed -1 to 1, speed to set motor
   */
  public void setRightMotorSpeed(double speed){
    rightFrontMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
    rightBackMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the drivetrain using Duty Cycle
   * @param speed -1 to 1, speed to set motor
   */
  public void setMotorSpeed(double speed){
    setLeftMotorSpeed(speed);
    setRightMotorSpeed(speed);
  }

  /**
   * Sets the position of the left side of the drivetrain using Position
   * @param rotations 
   */
  public void setLeftMotorPosition(double rotations){
    leftFrontMotor.getPIDController().setReference(rotations, ControlType.kPosition);
    leftBackMotor.getPIDController().setReference(rotations, ControlType.kPosition);
  }
  /**
   * Sets the position of the right side of the drivetrain using Position
   * @param rotations
   */
  public void setRightMotorPosition(double rotations){
    rightFrontMotor.getPIDController().setReference(-rotations, ControlType.kPosition);
    rightBackMotor.getPIDController().setReference(-rotations, ControlType.kPosition);
  }


  public void setAllMotorPosition(double rotations){
    setRightMotorPosition(rotations);
    setLeftMotorPosition(rotations);
  }

  /**
   * Resets the left encoder
   */
  public void resetLeftEncoder(){
    leftFrontMotor.getEncoder().setPosition(0);
    leftBackMotor.getEncoder().setPosition(0);
  }

  /**
   * Resets the right encoder
   */
  public void resetRightEncoder(){
    rightFrontMotor.getEncoder().setPosition(0);
    rightBackMotor.getEncoder().setPosition(0);
  }

  public void resetAllEncoder(){
    resetLeftEncoder();
    resetRightEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
