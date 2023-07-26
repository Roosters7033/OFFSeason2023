package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorJoystickCmd extends CommandBase {
  private final ElevatorSubsystem elevatorSubsystem;

  private double speed;
 
  public ElevatorJoystickCmd(ElevatorSubsystem elevatorSubsystem, double speed) {
    this.elevatorSubsystem = elevatorSubsystem;
    this.speed = speed;
    
    addRequirements(elevatorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    elevatorSubsystem.set(this.speed);
  }

  @Override
  public void end(boolean interrupted) {
    elevatorSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
