// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCmd extends CommandBase {

  private DriveSubsystem driveSubsystem;
  private XboxController controller;
  private double turn;
  private double foward;
 


  public ArcadeDriveCmd(DriveSubsystem drive, XboxController joy) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSubsystem = drive;
    controller = joy;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turn = controller.getLeftY();
    foward = controller.getRightX();

    if(Math.abs(foward) < 0.3 && Math.abs(turn) < 0.3){
      driveSubsystem.stop();
    }
    driveSubsystem.set(foward, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
