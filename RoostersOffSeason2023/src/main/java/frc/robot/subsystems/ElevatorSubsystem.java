// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */

  private Victor elevatorMotorPrimary;
  private Victor elevatorMotorSecondary;

  //---------------------------------------------------------------------------------------------------
  public ElevatorSubsystem() {
    elevatorMotorPrimary = new Victor(Constants.ElevatorIds.primaryMotor);
    elevatorMotorSecondary = new Victor(Constants.ElevatorIds.secondaryMotor);
  }


  public void set(double speed) {
    elevatorMotorPrimary.set(speed);
    elevatorMotorSecondary.set(speed);
  }

  public void stop(){
    elevatorMotorPrimary.stopMotor();
    elevatorMotorSecondary.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Elevator primary value", elevatorMotorPrimary.get());
    SmartDashboard.putNumber("Elevator secondary value", elevatorMotorSecondary.get());
  }
}
