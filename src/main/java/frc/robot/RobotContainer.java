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
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

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
  public static Turret turret = new Turret(); 
  public static Hood hood = new Hood();
  public static Intake intake = new Intake();
  public static ConveyorBelt conveyorBelt = new ConveyorBelt();
  public static FrictionWheel frictionWheel = new FrictionWheel();
  public static Climber climber = new Climber();

  //Autonomous Command
  AutonomousRoutine auto = new AutonomousRoutine(); 
  
  //Operator Interface
  public static Joystick driveStick = new Joystick(0);
  public static JoystickButton controlPanel = new JoystickButton(driveStick, 5);
  public static JoystickButton verticalIntake = new JoystickButton(driveStick, 6);

  public static Joystick opBoard = new Joystick(1);
  public static JoystickButton forwardConveyor = new JoystickButton(opBoard, 1); //TODO change this to correct button
  public static JoystickButton reverseConveyor = new JoystickButton(opBoard, 2); //TODO change this to correct button
  public static JoystickButton manualIntake = new JoystickButton(opBoard, 3); //TODO change this to correct button
  public static JoystickButton reverseIntake = new JoystickButton(opBoard, 4); //TODO change this to correct button
  public static JoystickButton manualControlPanel = new JoystickButton(opBoard, 5); //TODO change this to correct button
  public static JoystickButton autoIntake = new JoystickButton(opBoard, 6); //TODO change this to correct button
  public static JoystickButton rotationControl = new JoystickButton(opBoard, 7); //TODO change this to correct button
  public static JoystickButton positionControl = new JoystickButton(opBoard, 8); //TODO change this to correct button
  public static JoystickButton autoShoot = new JoystickButton(opBoard, 9); //TODO change this to correct button
  public static JoystickButton manualShooting = new JoystickButton(opBoard, 10); //TODO change this to correct button
  public static JoystickButton hookDelivery = new JoystickButton(opBoard, 11); //TODO change this to correct button
  public static JoystickButton dropTelescope = new JoystickButton(opBoard, 12); //TODO change this to correct button
  public static JoystickButton leftClimb = new JoystickButton(opBoard, 13); //TODO change this to correct button
  public static JoystickButton rightClimb = new JoystickButton(opBoard, 14); //TODO change this to correct button
  public static JoystickButton bothWinchClimb = new JoystickButton(opBoard, 15); //TODO change this to correct button
  
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
    forwardConveyor.whileHeld(new ForwardConveyor());
    reverseConveyor.whileHeld(new ReverseConveyor());
    manualIntake.whileHeld(new ForwardIntake());
    reverseIntake.whileHeld(new ReverseIntake());

    autoIntake.whenPressed(new Intaking());
    rotationControl.whileHeld(new RotationControl()); 
    positionControl.whileHeld(new PositionControl()); 

    //autoShoot
    //manualShooting

    hookDelivery.whileHeld(new SendHook());
    dropTelescope.whileHeld(new DropHook());

    leftClimb.whileHeld(new WinchLeft());
    bothWinchClimb.whileHeld(new WinchIn());
    rightClimb.whileHeld(new WinchRight());
    
    controlPanel.whenPressed(new ConditionalCommand(new ExtendFrictionWheel(), new RetractFrictionWheel(), Constants.frictionWheelToggle));
    verticalIntake.whenPressed(new ConditionalCommand(new LowerIntake(), new RaiseIntake(), Constants.verticalIntakeToggle));
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
