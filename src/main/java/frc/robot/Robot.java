/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
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

    //RobotContainer.hood.resetEncoder();
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
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    RobotContainer.drivetrain.resetAllEncoder();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    RobotContainer.conveyorBelt.updateBallsHeld();
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
    System.out.println(Constants.ballsHeld);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();

    
  }

  int index = 0;
  double[] position = {5, 10, 15, 20, 25}; //TODO add specific encoder ticks for the hood to turn to

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


    /**
     * Shooter Testing
     */
    //Check whether the shooter goes in the right direction
    // if(RobotContainer.driveStick.getRawButton(1)){
    //   RobotContainer.shooter.spinMotors(0.5);
    // }else{
    //   RobotContainer.shooter.spinMotors(0);
    // }

    /**
     * Turret Testing
     */
    //teleop control using POV
    //RobotContainer.turret.moveTurretLeft(); //These currently stop with duty cycle,
    //RobotContainer.turret.moveTurretRight(); //Check if they need to stop with some kind of PID


    /**
     * Hood Testing 
     */
    //Find out if the encoder in the hood reset when the robot turned on
    //Find hood encoder angles, then put them into the position array above
    //System.out.println(RobotContainer.hood.getPosition());

    //Next test whether this successfully switches between all of positions listed in the array
    // if (RobotContainer.driveStick.getPOV()==0){
    //   if (index >=0 && index<= position.length-1) {
    //     index = index + 1;
    //     RobotContainer.hood.moveHood(position[index]);
    //   }
    // }
    // else if (RobotContainer.driveStick.getPOV()==180){
    //   if (index >=0 && index<= position.length-1) {
    //     index = index - 1;
    //     RobotContainer.hood.moveHood(position[index]); 
    //   }
    // }

    /**
     * Intake + Conveyor Belt
     */
    //Does indexing algorithm work? -- this will have to be tested in TeleopPeriodic
    //Check which direction extends/retracts the pistons -- are they both controlled by the same DoubleSolenoid??
    //Test toggle for raising/lowering intake -- do this in TeleopPeriodic
    RobotContainer.frictionWheel.retractMechanism();

    /**
     * Friction Wheel Testing
     */
    //Configure SmartVelocity for the motor
    //Test whether end condition for position control works
    //Test toggle for raising/lowering frictionwheel mechanism -- do this in TeleopPeriodic
    

  }
}
