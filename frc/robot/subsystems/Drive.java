/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UseDrive;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  SparkMax leftController;
  SparkMax rightController;

  public Drive(SparkMax _leftController, SparkMax _rightController) {
    super("Drive");
    leftController = _leftController;
    rightController = _rightController;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new UseDrive(this));
  }

  public void drive(double left, double right) {
    leftController.set(left);
    rightController.set(right);
  }
}
