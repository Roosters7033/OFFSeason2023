// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomo;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class FowardPerEncoder extends CommandBase {
  /** Creates a new FowardPerEncoder. */
  private DriveSubsystem driveSubsystem;
  private double valStop;
  private double direction;

  public FowardPerEncoder(DriveSubsystem driveSubsystem, double valStop, double direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = driveSubsystem;
    this.valStop = valStop;
    this.direction = direction;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.set(0.0, direction);
  }

  
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  
  @Override
  public boolean isFinished() {
    
    return Math.abs(driveSubsystem.getleftEncoder()) >= valStop || Math.abs(driveSubsystem.getRightEncoder()) >= valStop;
    
  }
}
