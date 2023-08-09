// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomo;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtenderSubsystem;

public class ExtenderPerTime extends CommandBase {
  private ExtenderSubsystem extenderSubsystem;
  private double time;
  private double speed;
  private Timer _timer; 

  /** Creates a new ExtenderPerTime. */
  public ExtenderPerTime(ExtenderSubsystem extenderSubsystem, double time, double speed) {
    this.extenderSubsystem =  extenderSubsystem;
    this.time = time;
    this.speed = speed;
    this._timer = new Timer();
    addRequirements(this.extenderSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this._timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.extenderSubsystem.set(this.speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.extenderSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (this._timer.get() >= this.time)||
    (this.extenderSubsystem.getPontaSwitch() || this.extenderSubsystem.getRaboSwitch());
  }
}
