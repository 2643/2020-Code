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

    public static final int extrudeButton = 1;


    //Drivetrain Constants
    public static int leftFrontMotorPort = 1;
    public static int leftBackMotorPort = 2;
    public static int rightFrontMotorPort = 3; 
    public static int rightBackMotorPort = 4; 

    public static final int rotate90Left = -13; //TODO determine encoder value for the 90 degree turn on the left side of the drivetrain
    public static final int rotate90Right = 13; 

    public static final int rotate180 = 26; //TODO determine encoder value for the 180 degree turn on the left side of the drivetrain

    public static final double rotate235Left = -32.5; //TODO determine encoder value for the 235 degree turn on the left side of the drivetrain
    public static final double rotate235Right = 32.5;

    public static final double allowedError = 0.05;


    //Friction Wheel Constants
    public static final int frictionWheelMotorPort = 7;

    public static final int doubleSolenoidPort1 = 5;
    public static final int doubleSolenoidPort2 = 5;

    public static final int frictionWheelSpeed = 1;
    
    public static final int pistonTimer = 1;

    public static String colorString = "";

    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    //Climber Constants
    public static final int leftClimberPort = 0; //TODO find the port of the left climber port
    public static final int rightClimberPort = 0; //TODO find the port of the right climber port
    public static final int climberDeliveryMotorPort = 0; //TODO find the port of the climber delivery
}
