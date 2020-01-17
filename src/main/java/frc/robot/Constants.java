/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int leftFrontMotorPort = 1;
    public static int leftBackMotorPort = 2;
    public static int rightFrontMotorPort = 3; 
    public static int rightBackMotorPort = 4; 

    public static int driveStickPort = 0; 
    public static int opBoardPort = 1;

    public static final int leftAxis = 1;
    public static final int rightAxis = 5; 

    public static final int rotate90Left = -13; //TODO determine encoder value for the 90 degree turn on the left side of the drivtrain
    public static final int rotate90Right = 13; 

    public static final int rotate180 = 26; //TODO determine encoder value for the 180 degree turn on the left side of the drivetrain

    public static final int rotate235Left = 0; //TODO determine encoder value for the 235 degree turn on the left side of the drivetrain
    public static final int rotate235Right = 0;

    public static final double allowedError = 0.09;

}
