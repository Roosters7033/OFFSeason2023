// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.encoderConstantsIds;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  //Colocando topo de velocidade
  double speed= 1.0; 

  //Creat DriveTrains groups 
  private WPI_TalonSRX leftDriverPrimary;
  private WPI_VictorSPX leftDriverSecondary;
  private WPI_TalonSRX rightDriverPrimary;
  private WPI_VictorSPX rightDriverSecondary;

  //Create Motorcontrollers groups
  private MotorControllerGroup leftDriveGroup;
  private MotorControllerGroup rightDriveGroup;

  //create differencial drive
  private DifferentialDrive differentialDrive;

  private Encoder leftEncoder = new Encoder(Constants.encoderConstantsIds.KLeftEncoderChannel1A, Constants.encoderConstantsIds.KLeftEncoderChannel1B,false,EncodingType.k1X);
  private Encoder rightEncoder = new Encoder(Constants.encoderConstantsIds.KRightEncoderChannel1A, Constants.encoderConstantsIds.KRightEncoderChannel1B);

  private PigeonIMU pigeon;
  

  public DriveSubsystem() {
    //Instanciando os motores
  leftDriverPrimary = new WPI_TalonSRX(Constants.MotorIds.leftDriverPrimary);
  leftDriverSecondary = new WPI_VictorSPX(Constants.MotorIds.leftDriverSecondary);
  rightDriverPrimary =  new WPI_TalonSRX(Constants.MotorIds.rightDriverPrimary);
  rightDriverSecondary = new WPI_VictorSPX (Constants.MotorIds.rightDriverSecondary);

  //instanciado os grupos esquerda e direita
  leftDriveGroup = new MotorControllerGroup(leftDriverPrimary, leftDriverSecondary);
  rightDriveGroup = new MotorControllerGroup (rightDriverPrimary, rightDriverSecondary);

  differentialDrive = new DifferentialDrive(leftDriveGroup, rightDriveGroup);

  pigeon = new PigeonIMU(leftDriverPrimary);

  rightDriverPrimary.setInverted(true);
  rightDriverSecondary.setInverted(true);
  leftDriverPrimary.setInverted(false);
  leftDriverSecondary.setInverted(false);

  

  
  }

  public void resetEncoders(){
    this.leftEncoder.reset();
    this.rightEncoder.reset();
  }

 

  public void set (Double val1, Double val2){
    differentialDrive.arcadeDrive(val1* 0.8, val2*(-1)*this.speed);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left encoder", this.leftEncoder.get());
    SmartDashboard.putNumber("Right encoder", this.rightEncoder.get());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
