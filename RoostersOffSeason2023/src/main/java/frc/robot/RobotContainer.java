// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DefaultElevatorCMD;
import frc.robot.commands.ElevatorCmd;
import frc.robot.commands.ExtenderCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.setSpeed;
import frc.robot.commands.Autonomo.FowardPerEncoder;
import frc.robot.commands.Autonomo.FowardPerTime;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExtenderSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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

  //private Trigger subirElevador_LB = new JoystickButton(copilotoJoy, XboxController.Button.kLeftBumper.value);
  //private Trigger descerElevador_RB = new JoystickButton(copilotoJoy, XboxController.Button.kRightBumper.value);

  private Trigger coletor_A = new JoystickButton(copilotoJoy, XboxController.Button.kA.value);
  private Trigger lancador_X = new JoystickButton(copilotoJoy, XboxController.Button.kX.value);

  private Trigger extender_RB = new JoystickButton(copilotoJoy, XboxController.Button.kRightBumper.value);
  private Trigger recolher_LB = new JoystickButton(copilotoJoy, XboxController.Button.kLeftBumper.value);


  private Trigger fullSpeed_A = new JoystickButton(pilotoJoy, XboxController.Button.kA.value);
  private Trigger fullFULLSpeed_y = new JoystickButton(pilotoJoy, XboxController.Button.kY.value);
  private Trigger slowSpeed_B = new JoystickButton(pilotoJoy, XboxController.Button.kB.value);

  public RobotContainer() {
    configureBindings();
    defaultCommands();
  }


  private void configureBindings() {

    //subirElevador_LB.whileTrue(new ElevatorCmd(elevatorSubsystem, 0.5));
    //descerElevador_RB.whileTrue(new ElevatorCmd(elevatorSubsystem, -0.3));

    lancador_X.whileTrue(new IntakeCmd(intakeSubsystem, 1.0));
    coletor_A.whileTrue(new IntakeCmd(intakeSubsystem, -1.0));

    extender_RB.whileTrue(new ExtenderCmd(extenderSubsystem, 0.80));
    recolher_LB.whileTrue(new ExtenderCmd(extenderSubsystem, -1.0));


    fullFULLSpeed_y.onTrue(new setSpeed(driveSubsystem, 1.0));
    fullSpeed_A.onTrue(new setSpeed(driveSubsystem, 0.9));
    slowSpeed_B.onTrue(new setSpeed(driveSubsystem, 0.6));

  }

  private void defaultCommands() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, pilotoJoy));
    elevatorSubsystem.setDefaultCommand(new DefaultElevatorCMD(elevatorSubsystem, copilotoJoy));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() { 
   /*  return new SequentialCommandGroup(
      new FowardPerTime(driveSubsystem, 2, 0.6),
      new FowardPerTime(driveSubsystem, 2, -0.6)
    ); */
    return new SequentialCommandGroup(
      new FowardPerEncoder(driveSubsystem, 500, 0.8),
      new FowardPerEncoder(driveSubsystem, 5000, -0.8)//Valores negativos vão pra frente
    );
      
  }
}
