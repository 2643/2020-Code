/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  public static DigitalInput intakeiRSensor1 = new DigitalInput(Constants.intakeiRSensor1Channel);
  public static DigitalInput intakeiRSensor2 = new DigitalInput(Constants.intakeiRSensor2Channel);
  public static CANSparkMax intakeMotor = new CANSparkMax(Constants.intakeMotorPort, MotorType.kBrushless);

  /**
   * Creates a new Intake.
   */
  public Intake() {
    
  }

  public boolean isBallThere(){
    if(intakeiRSensor1.get() == true && intakeiRSensor2.get() == true){ //TODO make this work
      return true;
    }else{
      return false;
    }
  }

  public void intake(){
    intakeMotor.set(Constants.intakeSpeed);
  }

  public void reverseIntake(){
    intakeMotor.set(Constants.reverseIntakeSpeed);
  }

  public void stopIntake(){
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
