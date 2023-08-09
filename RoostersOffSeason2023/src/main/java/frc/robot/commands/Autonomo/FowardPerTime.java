// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomo;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class FowardPerTime extends CommandBase {


  private DriveSubsystem driveSubsystem;
  private double delta;
  private double direction;
  private Timer timer;
  /** Creates a new FowardPerTime. */
  public FowardPerTime(DriveSubsystem driveSubsystem, double seconds, double direction) {

    this.driveSubsystem = driveSubsystem;
    this.delta = seconds;
    this.direction = direction;
    this.timer = new Timer();

    addRequirements(this.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    this.driveSubsystem.set(0.0, this.direction);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timer.get()<= this.delta;
  }
}
