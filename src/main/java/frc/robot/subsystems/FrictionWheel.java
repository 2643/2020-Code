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
  public String theColor;

  
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
  public String getColor() {
    int proximity = m_colorSensor.getProximity();
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    String colorString = "initialized colorstring";
    if (proximity > 190)
    {
      if (match.color == Constants.kBlueTarget) {
        colorString = "Blue";
      } else if (match.color == Constants.kRedTarget) {
        colorString = "Red";
      } else if (match.color == Constants.kGreenTarget) {
        colorString = "Green";
      } else if (match.color == Constants.kYellowTarget) {
        colorString = "Yellow";
      }
      else
      {
        colorString = "Unknown";
      }
      
      theColor = colorString;

      for (int i = 999; i > 0; i--)
      {

      }
      Color detectedColor_temp = m_colorSensor.getColor();
      ColorMatchResult match_temp = m_colorMatcher.matchClosestColor(detectedColor_temp);
      String colorString_temp = "initialized coloring temp";
      if (match_temp.color == Constants.kBlueTarget) {
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
       // while (true)
       //{
          if (colorString.equals("Yellow"))
          {
            if (colorString_temp.equals("Blue") && !colorString_temp.equals("Green"))
            {
            //  while(!colorString_temp.equals("Blue") || colorString_temp.equals("Green"))
              //{
                theColor = "Blue";
              //}
            }
          }
          else if (colorString.equals("Green"))
          {
            if (colorString_temp.equals("Red") && !colorString_temp.equals("Yellow"))
            {
              theColor = "Red";
            }
          }
          else if (colorString.equals("Red"))
          {
            if (colorString_temp.equals("Yellow"))
            {
              theColor = "Yellow";
            }
          }
          else if (colorString.equals("Blue"))
          {
            if (colorString_temp.equals("Green"))
            {
                theColor = "Green";
            }
          }
        //  }
      }
    }
    else
    {
      theColor = "Too Far Away";
    }
    SmartDashboard.putString("Detected Color", theColor);
    return theColor;
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

  public String shiftColor() 
  {
    int proximity = m_colorSensor.getProximity();
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    String colorString = "initialized colorstring";
    if (proximity > 190)
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
      
      theColor = colorString;

      Color detectedColor_temp = m_colorSensor.getColor();
      ColorMatchResult match_temp = m_colorMatcher.matchClosestColor(detectedColor_temp);
      String colorString_temp = "initialized coloring temp";
      if (match_temp.color == Constants.kBlueTarget) {
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
                theColor = "Blue";
            }
          }
          else if (colorString.equals("Green"))
          {
            if (colorString_temp.equals("Red") && !colorString_temp.equals("Yellow"))
            {
              theColor = "Red";
            }
          }
          else if (colorString.equals("Red"))
          {
            if (colorString_temp.equals("Yellow"))
            {
              theColor = "Yellow";
            }
          }
          else if (colorString.equals("Blue"))
          {
            if (colorString_temp.equals("Green"))
            {
                theColor = "Green";
            }
          }
      }
    }
    else
    {
      theColor = "Too Far Away";
    }
    SmartDashboard.putString("Detected Color", theColor);
    return theColor;
}
}
