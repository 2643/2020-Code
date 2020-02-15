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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public static CANSparkMax leftShooterMotor = new CANSparkMax(Constants.leftShooterMotorPort, MotorType.kBrushless);
  public static CANSparkMax rightShooterMotor = new CANSparkMax(Constants.rightShooterMotorPort, MotorType.kBrushless);

  //Shooter PID Constants
  
  
  /**
   * Creates a new Shooter.
   */
  public Shooter() {

  }

  /**
   * Spins the motor at a given speed in RPM
   * @param speed RPM to spin motor at
   */
  public void spinMotors(double speed){
    leftShooterMotor.getPIDController().setReference(speed, ControlType.kVelocity);//TODO Check direction for both shooter motors
    rightShooterMotor.getPIDController().setReference(-speed, ControlType.kVelocity);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //TODO: MAYBE write code to turn the shooter wheels backward if the last IR sensor on the conveyor belt is lit up
  }
}
