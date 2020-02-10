/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public static TalonFX leftShooterMotor = new TalonFX(Constants.leftShooterMotorPort);
  public static TalonFX rightShooterMotor = new TalonFX(Constants.rightShooterMotorPort);

  public static CANSparkMax turretMotor = new CANSparkMax(Constants.turretMotorPort, MotorType.kBrushless);
  public static CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorPort, MotorType.kBrushless);
  
  public static DigitalInput leftLimitSwitch = new DigitalInput(Constants.leftLimitSwitchPort);
  public static DigitalInput centreLimitSwitch = new DigitalInput(Constants.centreLimitSwitchPort);
  public static DigitalInput rightLimitSwitch = new DigitalInput(Constants.rightLimitSwitchPort);

  //Shooter PID Constants
  

  //Turret PID Constants
  double kP_turret = 0.00016;//0.006;
  double kI_turret = 0;//0.000002;
  double kD_turret = 0;//0.004;//0.2;
  double kFF_turret = 0.000156;
  double MaxOutput_turret = 1;
  double MinOutput_turret = -1;
  double maxAccel_turret = 3000;
  int slotID_turret = 0;
  int maxVel_turret = 7000;
  int minVel_turret = 0;
  double allowedErr_turret = 0.1;

  //Hood PID Constants
  double kP_hood = 0.00016;//0.006;
  double kI_hood = 0;//0.000002;
  double kD_hood = 0;//0.004;//0.2;
  double kFF_hood = 0.000156;
  double MaxOutput_hood = 1;
  double MinOutput_hood = -1;
  double maxAccel_hood = 3000;
  int slotID_hood = 0;
  int maxVel_hood = 7000;
  int minVel_hood = 0;
  double allowedErr_hood = 0.1;
  
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    turretMotor.getPIDController().setP(kP_turret, slotID_turret);
    turretMotor.getPIDController().setI(kI_turret, slotID_turret);
    turretMotor.getPIDController().setD(kD_turret, slotID_turret);
    turretMotor.getPIDController().setFF(kFF_turret, slotID_turret);
    turretMotor.getPIDController().setOutputRange(MinOutput_turret, MaxOutput_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMaxAccel(maxAccel_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMaxVelocity(maxVel_turret, slotID_turret);
    turretMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel_turret, slotID_turret);

    hoodMotor.getPIDController().setP(kP_hood, slotID_hood);
    hoodMotor.getPIDController().setI(kI_hood, slotID_hood);
    hoodMotor.getPIDController().setD(kD_hood, slotID_hood);
    hoodMotor.getPIDController().setFF(kFF_hood, slotID_hood);
    hoodMotor.getPIDController().setOutputRange(MinOutput_hood, MaxOutput_hood, slotID_hood);
    hoodMotor.getPIDController().setSmartMotionMaxAccel(maxAccel_hood, slotID_hood);
    hoodMotor.getPIDController().setSmartMotionAllowedClosedLoopError(allowedErr_hood, slotID_hood);
    hoodMotor.getPIDController().setSmartMotionMaxVelocity(maxVel_hood, slotID_hood);
    hoodMotor.getPIDController().setSmartMotionMinOutputVelocity(minVel_hood, slotID_hood);
  }

  /**
   * Spins the motor at a given speed in RPM
   * @param speed RPM to spin motor at
   */
  public void spinMotors(double speed){
    leftShooterMotor.set(ControlMode.Velocity, speed);//TODO Check direction for both shooter motors
    rightShooterMotor.set(ControlMode.Velocity, -speed);
  }

  /**
   * Moves hood to shoot at certain angle
   * @param position angle for the hood
   */
  public void moveHood(double position){ //TODO add functionality to accept angles to move hood to
    hoodMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_hood);
  }

  /**
   * Moves the turret to an angle
   * @param position angle to move turret to
   */
  public void aimTurret(double position){ //TODO add functionality to accept angles to move turret to
    if(leftLimitSwitch.get() == true){
      //turretMotor.getPIDController().setReference(0, ControlType.kDutyCycle, slotID_turret);
      if(position <= Constants.turretEncoderLeftSoftLimit){ //TODO check which direction is positive/negative
        turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_turret);
      }
    } else if(rightLimitSwitch.get() == true){
      if(position <= Constants.turretEncoderRightSoftLimit){
        turretMotor.getPIDController().setReference(position, ControlType.kSmartMotion, slotID_turret);
      }
    }
    else{
      turretMotor.getPIDController().setReference(0, ControlType.kDutyCycle, slotID_turret);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
