/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BackStop extends Subsystem {
  CANSparkMax backStopController;

  public BackStop(CANSparkMax _backStopController) {
    backStopController = _backStopController;
  }

  public void spin(double speed) {
    backStopController.set(speed);
  }

  public double getRotations() {
    return backStopController.getEncoder().getPosition();
  }

  @Override
  protected void initDefaultCommand() {
  }
}
