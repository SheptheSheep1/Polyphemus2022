// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drivetrain extends SubsystemBase {
  public final WPI_TalonSRX m_leftMaster;
  public final WPI_VictorSPX m_leftSlave;
  public final WPI_TalonSRX m_rightMaster;
  public final WPI_VictorSPX m_rightSlave;

  private final DifferentialDrive m_diffDrive;

  private final MotorControllerGroup m_left;
  private final MotorControllerGroup m_right;
  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    m_leftMaster = new WPI_TalonSRX(Constants.dtFrontLeftPort);
    m_leftSlave = new WPI_VictorSPX(Constants.dtBackLeftPort);
    m_rightMaster = new WPI_TalonSRX(Constants.dtFrontRightPort);
    m_rightSlave = new WPI_VictorSPX(Constants.dtBackRightPort);

      m_left = new MotorControllerGroup(m_leftMaster, m_leftSlave);
      m_right = new MotorControllerGroup(m_rightMaster, m_rightSlave);
      m_left.setInverted(true);
      m_diffDrive = new DifferentialDrive(m_left, m_right);
  }
  public void arcadeDrive(final double forward, final double turn) {
    //SmartDashboard.putNumber("forward", forward * Constants.kDriveSpeed);
    //SmartDashboard.putNumber("turn", turn * Constants.kTurnSpeed);
    m_diffDrive.arcadeDrive(forward * Constants.kDriveSpeed, turn * Constants.kTurnSpeed, true);
  }

  public void tankDrive(final double left, final double right) {
    m_diffDrive.tankDrive(left * Constants.kDriveSpeed, right * Constants.kDriveSpeed);
  }

  // CURVATURE DRIVE = 2 STICK + QUICK TURN BUTTON
  public void curvatureDrive(final double forward, final double turn, final boolean quickTurn) {
    m_diffDrive.curvatureDrive(forward * Constants.cDriveSpeed, turn * Constants.cTurnSpeed, quickTurn);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
