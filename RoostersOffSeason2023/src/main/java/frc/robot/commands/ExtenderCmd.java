// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExtenderSubsystem;

public class ExtenderCmd extends CommandBase {

  private ExtenderSubsystem extenderSubsystem;
  private double speed;

  /** Creates a new ExtensorTestCmd. */
  public ExtenderCmd(ExtenderSubsystem extenderSubsystem, double speed) {

    this.extenderSubsystem = extenderSubsystem;
    this.speed = speed;
    addRequirements(this.extenderSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    this.extenderSubsystem.set(this.speed);
  }

  @Override
  public void end(boolean interrupted) {
    this.extenderSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    if(this.speed > 0.0){
      return this.extenderSubsystem.getPontaSwitch();
    }else{
      return this.extenderSubsystem.getRaboSwitch();
    }
  }
}
