/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FrictionWheel extends SubsystemBase {
  DoubleSolenoid frictionWheelPiston = new DoubleSolenoid(Constants.doubleSolenoidPort1, Constants.doubleSolenoidPort2);
  WPI_TalonSRX frictionWheelMotor = new WPI_TalonSRX(Constants.frictionWheelMotorPort);
  
  /**
   * Creates a new FrictionWheel.
   */

  public FrictionWheel() {

  }

  public void extendPiston(){
    frictionWheelPiston.set(Value.kForward);//TODO Check direction
  }
  public void retractPiston(){
    frictionWheelPiston.set(Value.kReverse);//TODO Check direction
  }
  public void setMotorSpeed(double speed){
    frictionWheelMotor.set(speed);
  }
  @Override
  public void periodic() {
    /*
    if(Diston_button.get()==0){
      frictionWheelPiston.set(DoubleSolenoid.Value.kOff);
    }else if(Diston_button.get()==1){
      frictionWheelPiston.set(DoubleSolenoid.Value.kForward);
    }else if(Diston_button.get()==2){
      frictionWheelPiston.set(DoubleSolenoid.Value.kReverse);
    }
    */
  }
}
