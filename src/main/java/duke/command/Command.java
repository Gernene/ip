package duke.command;

public abstract class Command {

  public Command();

  public boolean isExit() {
      return false;
  }

  public abstract void execute(TaskList tasks, Ui ui, Storage storage);

}