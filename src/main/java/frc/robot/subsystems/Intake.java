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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private static DigitalInput intakeIR = new DigitalInput(Constants.intakeIRChannel);
  private static CANSparkMax intakeMotor = new CANSparkMax(Constants.intakeMotorPort, MotorType.kBrushless);
  private static DoubleSolenoid IntakePiston = new DoubleSolenoid(Constants.intakeSolenoidPort1, Constants.intakeSolenoidPort2);
  /**
   * Creates a new Intake.
   */
  public Intake() {
    
  }

  /**
   * Checks if the ball is passing through the intake 
   */
  public boolean isBallThere(){
    //TODO Does this give the conveyor belt enough time to start moving?
    if(intakeIR.get() == true){
      return true;
    }else{
      return false;
    }
  }

  /**
   * Intakes the ball
   */
  public void intake(){
    intakeMotor.set(Constants.intakeSpeed);
  }

  /**
   * Runs the intake in reverse
   */
  public void reverseIntake(){
    intakeMotor.set(Constants.reverseIntakeSpeed);
  }
  /**
   * Retracts the intake piston
   */
  public void RetractIntakePiston(){
    IntakePiston.set(Value.kForward);//TODO Check which direction 
  }
  /**
   * Extends the intake piston
   */
  public void ExtendIntakePiston(){
    IntakePiston.set(Value.kReverse); // TODO Check which direction
  }
  /**
   * Stops running the intake
   */
  public void stopIntake(){
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
