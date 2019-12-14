/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

public class UseDrive extends Command {
  Drive driveSub;
  final double Kpl = .1;
  double leftOutput;
  double rightOutput;
  double errorL;
  double errorR;

  public UseDrive(Drive driveSub) {
    super("UseDrive");

    this.driveSub = driveSub;

    leftOutput = 0;
    rightOutput = 0;

    requires(driveSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftVal = Robot.m_oi.getDriverLeftY();
    leftVal = Math.pow(leftVal, 3) * -1;
    if (leftVal < .005 && leftVal > -.005)
      leftVal = 0;

    double rightVal = Robot.m_oi.getDriverRightY();
    rightVal = Math.pow(rightVal, 3);
    if (rightVal < .005 && rightVal > -.005)
      rightVal = 0;

    driveSub.drive(leftVal, rightVal);

    //drive code with proportionality constant
    //ADD A DEADZONE FOR OUTPUT
    // double leftJoystick = Robot.m_oi.getDriverLeftY();
    // if (leftJoystick < .005 && leftJoystick > -.005)
    //    leftJoystick = 0;
    // errorL = leftJoystick - leftOutput;
    // leftOutput = leftOutput + errorL*Kpl;

    // double rightJoystick = Robot.m_oi.getDriverLeftY();
    // if (rightJoystick < .005 && rightJoystick > -.005)
    //    rightJoystick = 0;
    // errorR = rightJoystick - rightOutput;
    // rightOutput = rightOutput + errorR*Kpl;
    //driveSub.drive(leftOutput,rightOutput);


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
