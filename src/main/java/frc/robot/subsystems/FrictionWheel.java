/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FrictionWheel extends SubsystemBase {
  DoubleSolenoid frictionWheelPiston = new DoubleSolenoid(Constants.doubleSolenoidPort1, Constants.doubleSolenoidPort2);
  WPI_TalonSRX frictionWheelMotor = new WPI_TalonSRX(Constants.frictionWheelMotorPort);
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  public final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  public final ColorMatch m_colorMatcher = new ColorMatch();
  public String globalColor;

  
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
  private void detectColor() {
    final int proximity = m_colorSensor.getProximity();
    final Color detectedColor = m_colorSensor.getColor();
    final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    String colorString = "initialized colorstring";
    if (proximity > Constants.colorSensorOptimalRange)
    {
      if (match.color == Constants.kBlueTarget) 
      {
        colorString = "Blue";
      } else if (match.color == Constants.kRedTarget) 
      {
        colorString = "Red";
      } else if (match.color == Constants.kGreenTarget) 
      {
        colorString = "Green";
      } else if (match.color == Constants.kYellowTarget) 
      {
        colorString = "Yellow";
      }
      else
      {
        colorString = "Unknown";
      }
      
      globalColor = colorString;

      for (int i = 999; i > 0; i--)
      {
        
      }
      final Color detectedColor_temp = m_colorSensor.getColor();
      final ColorMatchResult match_temp = m_colorMatcher.matchClosestColor(detectedColor_temp);
      String colorString_temp = "initialized coloring temp";
      if (match_temp.color == Constants.kGreenTarget) {
        colorString_temp = "Blue";
      } else if (match_temp.color == Constants.kRedTarget) {
        colorString_temp = "Red";
      } else if (match_temp.color == Constants.kGreenTarget) {
        colorString_temp = "Green";
      } else if (match_temp.color == Constants.kYellowTarget) {
        colorString_temp = "Yellow";
      }


      if (!colorString_temp.equals(colorString))
      {

          if (colorString.equals("Yellow"))
          {
            if (colorString_temp.equals("Blue") && !colorString_temp.equals("Green"))
            {
                globalColor = "Blue";
            }
          }
          else if (colorString.equals("Green"))
          {
            if (colorString_temp.equals("Red") && !colorString_temp.equals("Yellow"))
            {
              globalColor = "Red";
            }
          }
          else if (colorString.equals("Red"))
          {
            if (colorString_temp.equals("Yellow"))
            {
              globalColor = "Yellow";
            }
          }
          else if (colorString.equals("Blue"))
          {
            if (colorString_temp.equals("Green"))
            {
                globalColor = "Green";
            }
          }
      }
    }
    else
    {
      globalColor = "Too Far Away";
    }
    SmartDashboard.putString("Detected Color", globalColor);
  }

  /**
   * Give the color detected by the color sensor
   * @return String color
   */
  public String getColor(){
    return globalColor;
  }

  public void setBrakeMode(){
    frictionWheelMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void neutralOutput(){
    frictionWheelMotor.stopMotor();
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
  public void setMotorSpeed(final double speed){
    frictionWheelMotor.set(speed);
  }

  private void colorForPositionControl(){
    String message = DriverStation.getInstance().getGameSpecificMessage();

    if(message.length() > 0){
      if(message.charAt(0) == 'B'){
        Constants.colorString = "Blue";
      }else if(message.charAt(0) == 'G'){
        Constants.colorString =  "Green";
      }else if(message.charAt(0) == 'R'){
        Constants.colorString = "Red";
      }else if(message.charAt(0) == 'Y'){
        Constants.colorString = "Yellow";
      }
    }
  }

  @Override
  public void periodic() {
    detectColor();

    if(!Constants.colorString.equals("Green") 
    || !Constants.colorString.equals("Red")
    || !Constants.colorString.equals("Blue")
    || !Constants.colorString.equals("Yellow")){
      colorForPositionControl(); 
    }
  }

}
