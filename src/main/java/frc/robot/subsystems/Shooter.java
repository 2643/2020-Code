/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public static TalonFX leftShooterMotor = new TalonFX(Constants.leftShooterMotorPort);
  public static TalonFX rightShooterMotor = new TalonFX(Constants.rightShooterMotorPort);

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
    leftShooterMotor.set(ControlMode.Velocity, speed);//TODO Check direction for both shooter motors
    rightShooterMotor.set(ControlMode.Velocity, -speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
