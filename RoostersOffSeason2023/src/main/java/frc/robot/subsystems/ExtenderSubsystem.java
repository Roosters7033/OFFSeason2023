// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExtenderSubsystem extends SubsystemBase {
  /** Creates a new ExtenderSubsystem. */

  private Victor extenderMotor;

  private DigitalInput first_switch = new DigitalInput(Constants.ExtenderIds.first_switch);
  private DigitalInput second_switch = new DigitalInput(Constants.ExtenderIds.second_switch);


  //---------------------------------------------------------------------------------------------------
  public ExtenderSubsystem() {
    this.extenderMotor = new Victor(Constants.ExtenderIds.extenderMotor);
  }

  public void set(double speed){
    extenderMotor.set(speed);
  }

  public void stop(){
    extenderMotor.stopMotor();
  }

  public boolean getFirstSwitch(){
    return this.first_switch.get();
  }

  public boolean getSecondSwitch(){
    return this.second_switch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
