// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class DriveTrainIds{
    public static final int leftDriverPrimary = 1;
    public static final int leftDriverSecondary = 2;
    public static final int rightDriverPrimary = 3;
    public static final int rightDriverSecondary = 4; 
  }

  public static class ElevatorIds{
    public static final int primaryMotor = 0;
    public static final int secondaryMotor = 1;
  }

  public static class IntakeIds{
    public static final int primaryMotor = 2;
    
  }

  public static class ExtenderIds{
    public static final int extenderMotor =3;
    public static final int rabo_switch = 4;
    public static final int ponta_switch = 5;
  }

  public static class encoderConstantsIds{
    public static final int KLeftEncoderChannel1A = 0;
    public static final int KLeftEncoderChannel1B = 1;
    public static final int KRightEncoderChannel1A = 2;
    public static final int KRightEncoderChannel1B = 3;

    public static final double KLeftEncoderTick2Meter= 1.0/ 4096.0* 0.128* Math.PI;
  }


}
