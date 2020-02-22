/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private static DigitalInput intakeIR = new DigitalInput(Constants.intakeIRChannel);
  private static WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.intakeMotorPort);

  private static DoubleSolenoid intakePiston = new DoubleSolenoid(Constants.intakeSolenoidPort1, Constants.intakeSolenoidPort2);
  
  /**
   * Creates a new Intake.
   */
  public Intake() {
    
  }

  /**
   * Checks if the ball is passing through the intake 
   */
  public boolean isBallThere(){
    if(intakeIR.get() == false){
      return true;
    }else{
      return false;
    }
  }

  /**
   * Intakes the ball
   */
  public void setSpeed(double speed){
    intakeMotor.set(speed);
  }

    
  /**
   * Retracts the intake piston
   */
  public void retract(){
    intakePiston.set(Value.kForward);//TODO Check which direction to retract the intake pistons
  }

   
  /**
   * Extends the intake piston
   */
  public void extend(){
    intakePiston.set(Value.kReverse); // TODO Check which direction to extend the intake pistons
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
