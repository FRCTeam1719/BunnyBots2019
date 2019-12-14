/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UseBackStop;

public class BackStop extends Subsystem {
  CANSparkMax backStopController;

  public BackStop(CANSparkMax _backStopController) {
    backStopController = _backStopController;
  }

  public void spin(double speed) {
    // backStopController.set(-.01);

    // make sure it only moves if above .1
    // if ((speed > 0) && (speed < .1))
    // backStopController.set(0);
    // else if ((speed < 0) && (speed > -.1))
    // backStopController.set(0);

    double limit = .08;
    // make sure speed doesn't exceed .3
    if ((speed > 0) && (speed > limit))
      backStopController.set(limit);
    else if ((speed < 0) && (speed < (limit * -1)))
      backStopController.set(limit * -1);
    else { // if speed is too low
      if ((speed < 0.07) && (speed > -.07))
        backStopController.set(0);
      else
        backStopController.set(speed);
    }
  }

  public double getRotations() {
    return backStopController.getEncoder().getPosition();
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new UseBackStop(this));

  }
}
