/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.BooleanSupplier;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

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
    public static final int leftAxis = 1;
    public static final int rightAxis = 5; 


    //Drivetrain Constants
    public static int leftFrontMotorPort = 1;
    public static int leftBackMotorPort = 2;
    public static int rightFrontMotorPort = 3; 
    public static int rightBackMotorPort = 4; 

    public static NetworkTable visionTable = NetworkTableInstance.getDefault().getTable("vision");

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
    public static int leftShooterMotorPort = 5;
    public static int rightShooterMotorPort = 6;

    //Turret Constants
    public static int turretMotorPort = 7;
    public static int leftLimitSwitchPort = 0; //TODO find port of left limit switch on turret
    public static int rightLimitSwitchPort = 0; //TODO find port of right limit switch on turret

    public static double leftTurretSpeed = 0.2; //TODO determine if this turns the turret left
    public static double rightTurretSpeed = -0.2; //TODO determine if this turns the turret right

    public static final int turretEncoderLeftSoftLimit = 0; //TODO determine encoder value for turret left limit
    public static final int turretEncoderRightSoftLimit = 0; //TODO determine encoder value for turret right limit

    //Hood Constants
    public static int hoodMotorPort = 8;
    public static int hoodLimitPort = 0; //TODO find port of the limit switch on the hood

    //Friction Wheel Constants
    public static final int frictionWheelMotorPort = 9;

    public static final int doubleSolenoidPort1 = 2;
    public static final int doubleSolenoidPort2 = 3;
    public static final int doubleSolenoidPort3 = 0;
    public static final int doubleSolenoidPort4 = 1;

    public static final double maxRPM = 5500;
    public static final double frictionWheelSpeed = 0.3; //TODO check if control panel is spinned in the right direction
    
    public static final int pistonTimer = 1;

    public static final int colorSensorOptimalRange = 190;
    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public static String fieldColorString; 

    public static boolean frictionWheelToggleVariable = false; 
    public static BooleanSupplier frictionWheelToggle = () -> frictionWheelToggleVariable; 

    //Climber Constants
    public static final int climberDeliveryMotorPort1 = 10; 
    public static final int climberDeliveryMotorPort2 = 11;  
    public static final int leftWinchPort = 12;
    public static final int rightWinchPort = 13;
    
    public static final double deliveryHookSpeed = 0.3; //TODO determine speed of hook delivery and retrieval
    
    public static final double leftWinchUpSpeed = 1; //TODO determine speed for the left winch
    public static final double rightWinchUpSpeed = 1; //TODO determine speed for the right winch
    
    public static final double deliveryTopLimit = 0; //TODO determine encoder value for top limit of the winch
    public static final double deliveryBottomLimit = 0; //TODO determine encoder value for bottom limit of the winch

    public static final double winchTopLimit = 0; //TODO determine encoder value for the top limit of the winch
    public static final double winchBottomLimit = 0;//TODO detrmine encoder value fort he bottom limit of the winch

    //Intake Constants
    public static final int intakeMotorPort = 14;
    public static final int intakeIRChannel = 0; //TODO change to correct port for intake infrared sensor

    public static final double intakeSpeed = -0.4;
    public static final double reverseIntakeSpeed = 0.4;

    public static final int intakeSolenoidPort1 = 0;
    public static final int intakeSolenoidPort2 = 1;

    public static final int intakeRaiseTime = 1;

    public static boolean intakingBall = false; 

    public static boolean verticalIntakeToggleVariable = false; 
    public static BooleanSupplier verticalIntakeToggle = () -> verticalIntakeToggleVariable;
    
    //Conveyor Constants
    public static final int conveyorBeltMotorPort = 15;

    public static final double conveyorBeltForwardSpeed = -0.6;
    public static final double conveyorBeltBackwardSpeed = 0.6; 

    public static final int conveyoriRSensor1Channel = 1; 
    public static final int conveyoriRSensor2Channel = 2; 
    public static final int conveyoriRSensor3Channel = 3; 
    public static final int conveyoriRSensor4Channel = 4; 
    public static final int conveyoriRSensor5Channel = 5; 
    public static final int conveyoriRSensor6Channel = 6;
    public static final int conveyoriRSensor7Channel = 7;
    public static final int conveyoriRSensor8Channel = 8; 
    public static final int conveyoriRSensor9Channel = 9;

    public static int ballsHeld = 0; 

}
