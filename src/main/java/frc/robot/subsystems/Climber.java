/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  //two TalonFX for climbing
  //one WPI_TalonSRX/SparkMax for climber delivery
  
  public static TalonFX leftClimberMotor = new TalonFX(Constants.leftClimberPort); 
  public static TalonFX rightClimberMotor = new TalonFX(Constants.rightClimberPort);

  public static WPI_TalonSRX climberDeliveryMotor = new WPI_TalonSRX(Constants.climberDeliveryMotorPort);
  
  
  /**
   * Creates a new Climber.
   */
  public Climber() {
  

  }
  public void deliverHook(double speed){
    climberDeliveryMotor.set(speed);
  }
  public void pullUpRobot(double speed){
    leftClimberMotor.set(ControlMode.PercentOutput, speed);
    rightClimberMotor.set(ControlMode.PercentOutput, speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
