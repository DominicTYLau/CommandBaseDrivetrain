// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveWithControllerCmd;

public class DrivetrainSubsystem extends SubsystemBase {

  CANSparkMax leftFrontMotor = new CANSparkMax(Constants.DrivetrainConstants.rightFrongMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax leftBackMotor = new CANSparkMax(Constants.DrivetrainConstants.leftBackMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightFrontMotor = new CANSparkMax(Constants.DrivetrainConstants.rightFrongMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightBackMotor = new CANSparkMax(Constants.DrivetrainConstants.rightBackMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
  
    

    RelativeEncoder lefEncoder = leftFrontMotor.getEncoder();
    RelativeEncoder righEncoder  = rightFrontMotor.getEncoder();

    MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(leftBackMotor, leftFrontMotor);
    MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(rightBackMotor, rightFrontMotor);

    
    DifferentialDrive drive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);



  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    leftBackMotor.restoreFactoryDefaults();
    leftFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();

    lefEncoder.setPosition(0);
    righEncoder.setPosition(0);

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightMotorControllerGroup.setInverted(true);
    leftMotorControllerGroup.setInverted(false);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

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
  }

public class tankDrive {

  public void setDefaultCommand(DriveWithControllerCmd driveWithController) {
  }
}


}
