// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends CommandBase {

  private IntakeSubsystem intakeSubsystem;
  private double speed; 

  public IntakeCmd(IntakeSubsystem intakeSubsystem, double speed) {
    this.speed = speed; 
    this.intakeSubsystem = intakeSubsystem;

    addRequirements(this.intakeSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    intakeSubsystem.set(speed);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
