/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class NeutralAuton extends Command {
  Drive driveSub;

  final double SPEED = 0.8;
  final double WHEEL_RADIUS_CM = 15.5 / 2;
  final double DISTANCE_CM = 487.68;

  double distance;

  public NeutralAuton(Drive driveSub) {
    // Use requires() here to declare subsystem dependencies

    this.driveSub = driveSub;

    requires(driveSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    distance += (driveSub.getLeftTurns() + driveSub.getRightTurns()) / 2;

    if (distance * 2 * Math.PI * WHEEL_RADIUS_CM < DISTANCE_CM)
    {
      driveSub.drive(SPEED, SPEED);
    }
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
