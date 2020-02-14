/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    //OI Constants
    public static int driveStickPort = 0; 
    public static int opBoardPort = 1;

    public static final int leftAxis = 1;
    public static final int rightAxis = 5; 


    //Drivetrain Constants
    public static int leftFrontMotorPort = 1;
    public static int leftBackMotorPort = 2;
    public static int rightFrontMotorPort = 3; 
    public static int rightBackMotorPort = 4; 

    /**
     * Determines the number of encoder ticks necessary for drivetrain to turn at certain angle
     * @param angle the angle to turn
     * @return number of encoder ticks for the each side of the drivetrain to turn 
     */
    public static double rotateX(double angle){
      double encoderTicks = ((13/90)* angle);
      return encoderTicks;
    }

    public static final double allowedError = 0.05;


    //Shooter Constants
    public static int rightShooterMotorPort = 5;
    public static int leftShooterMotorPort = 6;
    public static int hoodMotorPort = 7;
    public static int turretMotorPort = 8;

    public static int leftLimitSwitchPort = 1;
    public static int centreLimitSwitchPort = 2;
    public static int rightLimitSwitchPort = 3;



    //Friction Wheel Constants

    public static final int wheelTimer_7turns =1;//TODO find out how long to spin wheel 3.5 times
    public static final double wheelTimer_move1=0.25;//TODO find out how long to spin over one color
    public static String frictionWheelInputColor;//TODO create program to actually input the color yknow

    public static final int frictionWheelMotorPort = 7;

    public static final int doubleSolenoidPort1 = 2;
    public static final int doubleSolenoidPort2 = 3;
    public static final int doubleSolenoidPort3 = 0;
    public static final int doubleSolenoidPort4 = 1;
    public static final double maxRPM = 5500;
    public static final double frictionWheelSpeed = 0.3; 
    
    public static final int pistonTimer = 1;

    public static int colorSensorOptimalRange = 190; //TODO determine sensing distance that the color sensor will be at

    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public static String colorString; 

    //Climber Constants
    public static final int leftClimberPort = 0; //TODO find the port of the left climber motor
    public static final int rightClimberPort = 0; //TODO find the port of the right climber motor
    public static final int climberDeliveryMotorPort = 0; //TODO find the port of the climber delivery motor
    
    //Intake Constants
    public static final int intakeMotorPort = 0; //TODO Change to correct port for intake motor
    public static final int intakeiRSensorChannel = 0; //TODO change to correct port for intake infrared sensor

    public static final double intakeSpeed = 0.3;
    public static final double reverseIntakeSpeed = -0.3;

    public static final int intakeSolenoidPort1 = 0;
    public static final int intakeSolenoidPort2 = 1;
    
    //Conveyor Constants
    public static final int conveyorBeltMotorPort = 0; //TODO change to correct port for conveyor belt

    public static final double conveyorBeltForwardSpeed = 0.3; //TODO check if this speed works to move conveyor belt forward
    public static final double conveyorBeltBackwardSpeed = -0.3; //TODO check if this speed works to move conveyor belt backward

    public static final int conveyoriRSensor1Channel = 0; //TODO Change to correct channel for IR 1
    public static final int conveyoriRSensor2Channel = 0; //TODO Change to correct channel for IR 2
    public static final int conveyoriRSensor3Channel = 0; //TODO Change to correct channel for IR 3
    public static final int conveyoriRSensor4Channel = 0; //TODO Change to correct channel for IR 4
    public static final int conveyoriRSensor5Channel = 0; //TODO Change to correct channel for IR 5

    public static final int turretEncoderLeftSoftLimit = 0; 
    public static final int turretEncoderRightSoftLimit = 0; 
}
