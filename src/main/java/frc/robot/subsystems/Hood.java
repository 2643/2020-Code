/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Hood extends SubsystemBase {
  private static CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorPort, MotorType.kBrushless);
  //private static DigitalInput upperHoodLimit = new DigitalInput(Constants.upperHoodLimitPort);  //TODO implement limit switches for hood
  //private static DigitalInput lowerHoodLimit = new DigitalInput(Constants.lowerHoodLimitPort);

  //Hood PID Constants
  double kP_hood = 0.095;//0.006;
  double kI_hood = 0;//0.000002;
  double kD_hood = 0;//0.004;//0.2;
  double kFF_hood = 0;
  double MaxOutput_hood = 0.3;
  double MinOutput_hood = -0.3;
  double maxAccel_hood = 300;
  int slotID_hood = 0;
  int maxVel_hood = 2000;
  int minVel_hood = 0;
  double allowedErr_hood = 0.05;



  int index = 0;
  double[] position = {1, 5, 10, 15, 20, 25};
  boolean pressed1 = false; 
  boolean pressed2 = false; 

  /**
   * Creates a new Hood.
   */
  public Hood() {
    hoodMotor.getPIDController().setP(kP_hood, slotID_hood);
    hoodMotor.getPIDController().setI(kI_hood, slotID_hood);
    hoodMotor.getPIDController().setD(kD_hood, slotID_hood);
    hoodMotor.getPIDController().setFF(kFF_hood, slotID_hood);
    hoodMotor.getPIDController().setOutputRange(MinOutput_hood, MaxOutput_hood, slotID_hood);
  }

  /**
   * Moves hood to shoot at certain angle
   * @param position angle for the hood
   */
  public void moveHood(double position){
    if(position >=0 && position <= 26)
      hoodMotor.getPIDController().setReference(position, ControlType.kPosition, slotID_hood);
  }

  /**
   * Gets the current position of the encoder
   * @return double position
   */
  public double getPosition(){
    return hoodMotor.getEncoder().getPosition();
  }

  /**
   * Resets the encoder
   */
  public void resetEncoder(){
    hoodMotor.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //TODO test this hood movement code with a gamepad
    if (RobotContainer.driveStick.getPOV()==0 && pressed1 == false){
      if (index >= 0 && index < position.length-1) {
        index = index + 1; 
      }
      pressed1 = true;
    }else{
      pressed1 = false; 
    }

    if (RobotContainer.driveStick.getPOV()==180 && pressed2 == false){
      if (index > 0 && index <= position.length-1) {
        index = index - 1;
      }
      pressed2 = true; 
    }else{
      pressed2 = false; 
    }

    moveHood(position[index]);
  }
}
