// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveWithControllerCmd;

public class DrivetrainSubsystem extends SubsystemBase {

  WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(Constants.DrivetrainConstants.rightFrongMotor);
  WPI_VictorSPX leftBackMotor = new WPI_VictorSPX(Constants.DrivetrainConstants.leftBackMotor);
  WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(Constants.DrivetrainConstants.rightFrongMotor);
  WPI_VictorSPX rightBackMotor = new WPI_VictorSPX(Constants.DrivetrainConstants.rightBackMotor);
  
    

    MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(leftBackMotor, leftFrontMotor);
    MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(rightBackMotor, rightFrontMotor);

    
    DifferentialDrive drive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);



  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {


    rightMotorControllerGroup.setInverted(true);
    leftMotorControllerGroup.setInverted(false);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
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
