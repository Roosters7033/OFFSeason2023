// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExtenderSubsystem extends SubsystemBase {
  /** Creates a new ExtenderSubsystem. */

  private Victor extenderMotor;

  private DigitalInput rabo_switch = new DigitalInput(Constants.ExtenderIds.rabo_switch);
  private DigitalInput ponta_switch = new DigitalInput(Constants.ExtenderIds.ponta_switch);


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

  public boolean getRaboSwitch(){
    return this.rabo_switch.get();
  }

  public boolean getPontaSwitch(){
    return this.ponta_switch.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Extender First Switch:", getRaboSwitch());
    SmartDashboard.putBoolean("Extender Second Switch:", getPontaSwitch());
  }
}
