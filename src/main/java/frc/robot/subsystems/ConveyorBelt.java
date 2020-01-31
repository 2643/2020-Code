/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ConveyorBelt extends SubsystemBase {

  public static WPI_TalonSRX conveyorBeltMotor = new WPI_TalonSRX(Constants.conveyorBeltMotorPort);
  public static DigitalInput conveyoriRSensor1 = new DigitalInput(Constants.conveyoriRSensor1Channel);
  public static DigitalInput conveyoriRSensor2 = new DigitalInput(Constants.conveyoriRSensor2Channel);
  public static DigitalInput conveyoriRSensor3 = new DigitalInput(Constants.conveyoriRSensor3Channel);
  public static DigitalInput conveyoriRSensor4 = new DigitalInput(Constants.conveyoriRSensor4Channel);
  public static DigitalInput conveyoriRSensor5 = new DigitalInput(Constants.conveyoriRSensor5Channel);
  public static DigitalInput[] conveyoriRSensors = {conveyoriRSensor1,conveyoriRSensor2, conveyoriRSensor3, conveyoriRSensor4, conveyoriRSensor5};


  /**
   * Creates a new ConveyorBelt.
   */
  public ConveyorBelt() {
    
  }

  public DigitalInput[] getConveyorIRs(){
    return conveyoriRSensors;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setConveyorBeltSpeed(){
    conveyorBeltMotor.set(Constants.conveyorBeltSpeed);
  }
}
