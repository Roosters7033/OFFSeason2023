package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorCmd extends CommandBase {
  private final ElevatorSubsystem elevatorSubsystem;

  private double speed;
  private double time;
  private Timer _timer;
 
  public ElevatorCmd(ElevatorSubsystem elevatorSubsystem, double speed, double time) {
    this.elevatorSubsystem = elevatorSubsystem;
    this.speed = speed;
    this.time = time;
    this._timer =  new Timer();
    
    addRequirements(elevatorSubsystem);
  }

  @Override
  public void initialize() {
    this._timer.start();
  }

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
    return this._timer.get() >= this.time;
  }
}
