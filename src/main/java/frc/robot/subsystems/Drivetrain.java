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

public class Drivetrain extends SubsystemBase {
  private static CANSparkMax leftFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
  private static CANSparkMax leftBackMotor = new CANSparkMax(1, MotorType.kBrushless);

  double leftkP = 0; 
  double leftkI = 0;
  double leftkD = 0;
  double leftkFF = 0; 

  private static CANSparkMax rightFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
  private static CANSparkMax rightBackMotor = new CANSparkMax(3, MotorType.kBrushless);

  double rightkP = 0;
  double rightkI = 0;
  double rightkD = 0; 
  double rightkFF = 0;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    leftFrontMotor.getPIDController().setP(leftkP);
    leftFrontMotor.getPIDController().setI(leftkI);
    leftFrontMotor.getPIDController().setD(leftkD);
    leftFrontMotor.getPIDController().setFF(leftkFF);

    leftBackMotor.getPIDController().setP(leftkP);
    leftBackMotor.getPIDController().setI(leftkI);
    leftBackMotor.getPIDController().setD(leftkD);
    leftBackMotor.getPIDController().setFF(leftkFF);

    rightFrontMotor.getPIDController().setP(rightkP);
    rightFrontMotor.getPIDController().setI(rightkI);
    rightFrontMotor.getPIDController().setD(rightkD);
    rightFrontMotor.getPIDController().setFF(rightkFF);

    rightBackMotor.getPIDController().setP(rightkP);
    rightBackMotor.getPIDController().setI(rightkI);
    rightBackMotor.getPIDController().setD(rightkD);
    rightBackMotor.getPIDController().setFF(rightkFF);
  }


  /**
   * Sets the speed of the left side motors using Duty Cycle
   * @param speed from -1 to 1, speed to set motor
   */
  public static void setLeftMotorSpeed(double speed){
    leftFrontMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
    leftBackMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the right side motors using Duty Cycle
   * @param speed -1 tp 1, speed to set motor
   */
  public static void setRightMotorSpeed(double speed){
    rightFrontMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
    rightBackMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);
  }

  /**
   * Sets the speed of the drivetrain using Duty Cycle
   * @param speed -1 to 1, speed to set motor
   */
  public static void setMotorSpeed(double speed){
    setLeftMotorSpeed(speed);
    setRightMotorSpeed(speed);
  }

  /**
   * Sets the position of the left side of the drivetrain using Position
   * @param rotations 
   */
  public static void setLeftMotorPosition(double rotations){
    leftFrontMotor.getPIDController().setReference(rotations, ControlType.kPosition);
  }
  /**
   * Sets the position of the right side of the drivetrain using Position
   * @param rotations
   */
  public static void setRightMotorPosition(double rotations){
    rightFrontMotor.getPIDController().setReference(rotations, ControlType.kPosition);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
