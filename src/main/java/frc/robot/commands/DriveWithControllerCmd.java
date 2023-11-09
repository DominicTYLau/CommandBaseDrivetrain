// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveWithControllerCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem drivetrainSubsystem;
  private Supplier<Double> leftSpeed;
  private Supplier<Double> rightSpeed;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithControllerCmd(DrivetrainSubsystem drivetrainSubsystem, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrainSubsystem.tankDrive(leftSpeed.get(), rightSpeed.get());
  }

  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
