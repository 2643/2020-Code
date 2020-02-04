/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FrictionWheel extends SubsystemBase {
  DoubleSolenoid frictionWheelPiston = new DoubleSolenoid(Constants.doubleSolenoidPort1, Constants.doubleSolenoidPort2);
  WPI_TalonSRX frictionWheelMotor = new WPI_TalonSRX(Constants.frictionWheelMotorPort);
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  public final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  public final ColorMatch m_colorMatcher = new ColorMatch();

  
  /**
   * Creates a new FrictionWheel.
   */

  public FrictionWheel() {
    m_colorMatcher.addColorMatch(Constants.kBlueTarget);
    m_colorMatcher.addColorMatch(Constants.kGreenTarget);
    m_colorMatcher.addColorMatch(Constants.kRedTarget);
    m_colorMatcher.addColorMatch(Constants.kYellowTarget);
  }

  /**
   * Returns the color detected by the color sensor
   */
  public String detectColor(){
    ColorMatchResult match = m_colorMatcher.matchClosestColor(m_colorSensor.getColor());
    int proximity = m_colorSensor.getProximity();
    String colorString;
    
    if(proximity >= Constants.colorSensorOptimalRange){
      if (match.color == Constants.kBlueTarget) {
        colorString = "Blue";
      } else if (match.color == Constants.kRedTarget) {
        colorString = "Red";
      } else if (match.color == Constants.kGreenTarget) {
        colorString = "Green";
      } else if (match.color == Constants.kYellowTarget) {
        colorString = "Yellow";
      } else {
        colorString = "Unknown";
      }
    }else{
      colorString = "Too Far Away";
    }
    return colorString; 
  }

  /**
   * Extends the FrictionWheel mechanism
   */
  public void extendMechanism(){
    frictionWheelPiston.set(Value.kForward); //TODO Check direction of piston to extend FrictionWheel
  }
  /**
   * Retracts the FrictionWheel mechanism
   */
  public void retractMechanism(){
    frictionWheelPiston.set(Value.kReverse); //TODO Check direction of piston to retract FrictionWheel
  }

  /**
   * Sets the speed of the friction wheel
   * @param speed
   */
  public void setMotorSpeed(double speed){
    frictionWheelMotor.set(speed);
  }

  
  @Override
  public void periodic() {
    
  }
}
