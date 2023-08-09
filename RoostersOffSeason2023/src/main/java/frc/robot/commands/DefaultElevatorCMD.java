// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCMD extends CommandBase {

  private ElevatorSubsystem elevatorSubsystem;
  private XboxController controller;
  /** Creates a new DefaultElevatorCMD. */
  public DefaultElevatorCMD(ElevatorSubsystem elevatorSubsystem, XboxController controller) {

    this.elevatorSubsystem = elevatorSubsystem;
    this.controller = controller;
    addRequirements(elevatorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double negative = controller.getLeftTriggerAxis()*0.4;
    double positive = controller.getRightTriggerAxis()*0.5;

    if(negative> positive){
      elevatorSubsystem.set(negative*-1.0);
    }else{
      elevatorSubsystem.set(positive);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
