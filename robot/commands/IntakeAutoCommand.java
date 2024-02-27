// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class IntakeAutoCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake m_Intake;
  private double intakeDuration;
  private boolean pullIn;
  private double delay;
  private Timer timer = new Timer();
  private double time;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeAutoCommand(Intake intake, double intakeDuration, double delay, boolean pullIn) {
    m_Intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    System.out.println("Intake Command Started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      System.out.println("Intake Command Continued");
      time = timer.get();
    if(pullIn == true && time >= delay) {
    m_Intake.pull(true, false);
    }
    else if(pullIn == false && time >= delay) {
      m_Intake.pull(false, true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Intake Command Ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(time > intakeDuration) {
      
      return true;
    }
    else{
    return false;
    }
  }
}
