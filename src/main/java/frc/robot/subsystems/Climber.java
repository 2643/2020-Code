/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  public static TalonFX leftWinchMotor = new TalonFX(Constants.leftWinchPort);
  public static TalonFX rightWinchMotor = new TalonFX(Constants.rightWinchPort);

  //The climber delivery motors might become NEOs or NEO 550s
  public static WPI_TalonSRX climberDeliveryMotor1 = new WPI_TalonSRX(Constants.climberDeliveryMotorPort1);
  public static WPI_TalonSRX climberDeliveryMotor2 = new WPI_TalonSRX(Constants.climberDeliveryMotorPort2);
  
  //TODO Implement soft limits for delivery and winch

  /**
   * Creates a new Climber.
   */
  public Climber() {
    
  }

  /**
   * Raises the climber delivery hook
   */
  public void setDeliveryMotorSpeed(double speed){
    climberDeliveryMotor1.set(speed); //TODO check whether climber delivery motors will be running in the same direction
    climberDeliveryMotor2.set(speed);
  }

  /**
   * Makes the climber motor stay at the height it was released at
   */
  public void stay(){
    climberDeliveryMotor1.setNeutralMode(NeutralMode.Brake);
    climberDeliveryMotor2.setNeutralMode(NeutralMode.Brake);
  }

  /**
   * Sets the speed of both the winches to pull up the robot
   * @param speed double from -1 to 1
   */
  public void setBothWinch(double speed){
    leftWinchMotor.set(ControlMode.PercentOutput, speed);
    rightWinchMotor.set(ControlMode.PercentOutput, speed);
  }

  /**
   * Sets the speed of the right winch to pull up the robot
   * @param speed double from -1 to 1
   */
  public void setRightWinch(double speed){
    rightWinchMotor.set(ControlMode.PercentOutput, speed);
  }

  /**
   * Sets the speed of the left winch to pull up the robot
   */
  public void setLeftWinch(double speed){
    leftWinchMotor.set(ControlMode.PercentOutput, speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
