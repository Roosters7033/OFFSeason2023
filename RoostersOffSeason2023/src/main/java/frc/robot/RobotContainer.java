// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.ElevatorJoystickCmd;
import frc.robot.commands.ExtenderTestCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ExtenderSubsystem extenderSubsystem = new ExtenderSubsystem();

  private XboxController pilotoJoy = new XboxController(0);
  private XboxController copilotoJoy = new XboxController(1);

  private Trigger subirElevador = new JoystickButton(copilotoJoy, XboxController.Button.kLeftBumper.value);
  private Trigger descerElevador = new JoystickButton(copilotoJoy, XboxController.Button.kRightBumper.value);

  private Trigger coletor = new JoystickButton(copilotoJoy, XboxController.Button.kA.value);
  private Trigger lancador = new JoystickButton(copilotoJoy, XboxController.Button.kB.value);

  private Trigger testeExtenderOpen = new JoystickButton(copilotoJoy, XboxController.Button.kX.value);
  private Trigger testeExtenderClose = new JoystickButton(copilotoJoy, XboxController.Button.kY.value);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    defaultCommands();
  }


  private void configureBindings() {

    subirElevador.whileTrue(new ElevatorJoystickCmd(elevatorSubsystem, 0.8));
    descerElevador.whileTrue(new ElevatorJoystickCmd(elevatorSubsystem, -0.8));

    lancador.whileTrue(new IntakeCmd(intakeSubsystem, 0.8));
    coletor.whileTrue(new IntakeCmd(intakeSubsystem, -0.8));

    testeExtenderOpen.whileTrue(new ExtenderTestCmd(extenderSubsystem, 0.8));
    testeExtenderClose.whileTrue(new ExtenderTestCmd(extenderSubsystem, -0.8));

  }

  private void defaultCommands() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, pilotoJoy));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // An example command will be run in autonomous

  }
}
