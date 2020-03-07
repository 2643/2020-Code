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

public class Turret extends SubsystemBase {
  private static CANSparkMax turretMotor = new CANSparkMax(Constants.turretMotorPort, MotorType.kBrushless);

  //TODO uncomment turret limit switch functionality
  //private static DigitalInput leftLimitSwitch = new DigitalInput(Constants.leftLimitSwitchPort);  
  //private static DigitalInput rightLimitSwitch = new DigitalInput(Constants.rightLimitSwitchPort);

  //Turret PID Constants
  double kP_turret = 0.0001;
  double kI_turret = 0;
  double kD_turret = 0;
  double kFF_turret = 0;
  double MaxOutput_turret = 0.6;
  double MinOutput_turret = -0.6;
  double maxAccel_turret = 18000;
  int slotID_turret = 0;
  int maxVel_turret = 9000;
  int minVel_turret = 0;
  double allowedErr_turret = 0;

  /**
   * Creates a new Turret.
   */
  public Turret() {
    turretMotor.getPIDController().setP(kP_turret, slotID_turret);
    turretMotor.getPIDController().setI(kI_turret, slotID_turret);
    turretMotor.getPIDController().setD(kD_turret, slotID_turret);
    turretMotor.getPIDController().setFF(kFF_turret, slotID_turret);
    turretMotor.getPIDController().setOutputRange(MinOutput_turret, MaxOutput_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMaxAccel(maxAccel_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMaxVelocity(maxVel_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel_turret, slotID_turret);
  }

  /**
   * Moves the turret to an angle
   * @param position to move turret to
   */
  public void aimTurret(double position){ //TODO add functionality to accept angles to move turret to
    // if(leftLimitSwitch.get() == true){
    //   if(position <= Constants.turretEncoderLeftSoftLimit){ //TODO check which direction is positive/negative
    //     turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_turret);
    //   }
    // } else if(rightLimitSwitch.get() == true){
    //   if(position <= Constants.turretEncoderRightSoftLimit){
    //     turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_turret);
    //   }
    // }
    // else{
    //   turretMotor.getPIDController().setReference(turretMotor.getEncoder().getPosition(), ControlType.kPosition, slotID_turret);
    // }
    if(position <= Constants.turretEncoderLeftSoftLimit && position >= Constants.turretEncoderRightSoftLimit){
      turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_turret);
    }else{
      turretMotor.getPIDController().setReference(turretMotor.getEncoder().getPosition(), ControlType.kSmartMotion, slotID_turret);
    }
  }

  /**
   * Move the turret left using duty cycle
   */
  public void moveTurretLeft(){
    // //If the left limit switch is activated, then don't move to the left
    // if(leftLimitSwitch.get() == false){
    //   stopTurret();
    // }else{
    //   turretMotor.getPIDController().setReference(Constants.leftTurretSpeed, ControlType.kDutyCycle, slotID_turret);
    // }
    
    turretMotor.getPIDController().setReference(Constants.leftTurretSpeed, ControlType.kDutyCycle, slotID_turret);
  }

  /**
   * Move the turret right using duty cycle
   */
  public void moveTurretRight(){
    // //If the right limit switch is activated, then don't move to the right
    // if(rightLimitSwitch.get() == false){
    //   stopTurret();
    // }else{
    //   turretMotor.getPIDController().setReference(Constants.rightTurretSpeed, ControlType.kDutyCycle, slotID_turret);
    // }  

    turretMotor.getPIDController().setReference(Constants.rightTurretSpeed, ControlType.kDutyCycle, slotID_turret);

  }

  /**
   * Stop the turret
   */
  public void stopTurret(){
    turretMotor.getPIDController().setReference(0, ControlType.kDutyCycle, slotID_turret);
  }

  /**
   * Gets the position of the turret
   * @return double rotations
   */
  public double getPosition(){
    return turretMotor.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

