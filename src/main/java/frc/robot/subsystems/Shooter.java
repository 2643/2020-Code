/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  static CANSparkMax m_motorOne = new CANSparkMax(21, MotorType.kBrushless);
  static CANSparkMax m_motorTwo = new CANSparkMax(20, MotorType.kBrushless);
  static CANEncoder m_encoderOne;
  static CANEncoder m_encoderTwo;
  private static CANPIDController m_pidControllerOne;
  private static CANPIDController m_pidControllerTwo;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    final double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

    // initialize motor
    /**
     * In order to use PID functionality for a controller, a CANPIDController object
     * is constructed by calling the getPIDController() method on an existing
     * CANSparkMax object
     */

    m_pidControllerOne = m_motorOne.getPIDController();
    m_pidControllerTwo = m_motorTwo.getPIDController();

    // Encoder object created to display position values
    m_encoderOne = m_motorOne.getEncoder();
    m_encoderTwo = m_motorTwo.getEncoder();

    // PID coefficients
    kP = 0.00067; //0.00015
    kI = 0.000001;
    kD = 0.0002;
    kIz = 100;
    kFF = 0.0002;
    kMaxOutput = 0.7;
    kMinOutput = -0.7;
    maxRPM = 5700;


    // set PID coefficients
    m_pidControllerOne.setP(kP);
    m_pidControllerOne.setI(kI);
    m_pidControllerOne.setD(kD);
    m_pidControllerOne.setIZone(kIz);
    m_pidControllerOne.setFF(kFF);
    m_pidControllerOne.setOutputRange(kMinOutput, kMaxOutput);

    m_pidControllerTwo.setP(kP);
    m_pidControllerTwo.setI(kI);
    m_pidControllerTwo.setD(kD);
    m_pidControllerTwo.setIZone(kIz);
    m_pidControllerTwo.setFF(kFF);
    m_pidControllerTwo.setOutputRange(kMinOutput, kMaxOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.print(m_encoderOne.getVelocity()+"  ");
    System.out.println(m_encoderTwo.getVelocity());
  }

  public static void stop() {
    m_pidControllerOne.setReference(0, ControlType.kDutyCycle);
    m_pidControllerTwo.setReference(0, ControlType.kDutyCycle);
  }

  public static void speedUp(int speed) {
    m_pidControllerOne.setReference(speed, ControlType.kVelocity);
    m_pidControllerTwo.setReference(-speed, ControlType.kVelocity);
  }

  public static void setSpeed(double speed) {
    m_motorOne.set(speed);
    m_motorTwo.set(-speed);
  }
}
