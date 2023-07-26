// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new GrabberSubsystem. */
  private Spark intakeMotor;

  //---------------------------------------------------------------------------------------------------
  public IntakeSubsystem() {
    intakeMotor = new Spark(Constants.IntakeIds.primaryMotor);
  }

  public void set(double speed) {
    intakeMotor.set(speed);
  }

  public void stop(){
    intakeMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
