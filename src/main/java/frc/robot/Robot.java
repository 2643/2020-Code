/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private static RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    RobotContainer.hood.resetEncoder();
    RobotContainer.drivetrain.resetAllEncoder();
    RobotContainer.conveyorBelt.updateBallsHeld();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    CommandScheduler.getInstance().setDefaultCommand(RobotContainer.drivetrain, new Tankdrive());
    CommandScheduler.getInstance().setDefaultCommand(RobotContainer.turret, new TurretPOVControl());
    CommandScheduler.getInstance().setDefaultCommand(RobotContainer.hood, new HoodPOVControl());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {

  }

  /**
   * This function is called periodically each time the robot enters Disabled mode. 
   */
  @Override
  public void disabledPeriodic() {
    RobotContainer.hood.resetEncoder();
    //System.out.println(RobotContainer.turret.getPosition());


  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    RobotContainer.drivetrain.resetAllEncoder();
    RobotContainer.conveyorBelt.updateBallsHeld();
    RobotContainer.hood.resetEncoder();

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    RobotContainer.conveyorBelt.updateBallsHeld();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    //System.out.println(RobotContainer.tfmini.getDistance());
  }

  /**
   * This function is called once at the beginning of test mode. 
   */
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }


  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    /**
     * Drivetrain Testing
     */
    //Check if encoders have reset
    //System.out.println(RobotContainer.drivetrain.getLeftMotorEncoder() + " " + RobotContainer.drivetrain.getRightMotorEncoder());
    //Test MoveForward with the new allowed error -- schedule this in AutonomousInit
    //Test RotateX to make sure it turns in the right direction - schedule this in AutonomousInit
    //Make/test autonomous routine - with/without shooting

    /**
     * Shooter Testing
     */


    /**
     * Turret Testing
     */
    System.out.println(RobotContainer.turret.getPosition());

    RobotContainer.turret.aimTurret(-5);


    /**
     * Hood Testing 
     */

 

    /**
     * Intake + Conveyor Belt
     */

    /**
     * Friction Wheel Testing
     */
    
    /**
     * Climber Testing
     */
    //test soft stops for delivery 
  }
}
