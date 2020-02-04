/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.MoveInAStraightLine;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FrictionWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands and OI devices are defined here...

  //Subsystems
  public static Drivetrain drivetrain = new Drivetrain();
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static ConveyorBelt conveyorBelt = new ConveyorBelt();
  public static FrictionWheel frictionWheel = new FrictionWheel();
  public static Climber climber = new Climber();

  //Autonomous Command
  MoveInAStraightLine auto = new MoveInAStraightLine(100);
  
  //Operator Interface
  public static Joystick driveStick = new Joystick(Constants.driveStickPort);
  public static Joystick opBoard = new Joystick(Constants.opBoardPort);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }

}
