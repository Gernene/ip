package duke;

public class Parser {

  public Parser() {

  }

  public Command parse(String fullCommand) {
      String fullCommandArray = fullCommand.split(" ");
      String command = fullCommandArray[0];
      if (command.equals("deadline")) {
          String dataString = fullCommand.replaceFirst("deadline ", "");
          String[] data = dataString.split("/by ");
          Task task = new Deadline(data[0], LocalDate.parse(data[1]));
          return new AddCommand(task);
      }
      else if (command.equals("event")) {
          String dataString = fullCommand.replaceFirst("event ", "");
          String[] data = dataString.split("/at ");
          Task task = new Event(data[0], LocalDate.parse(data[1]));
          return new AddCommand(task);
      }
      else if (command.equals("todo")) {
          if (fullCommandArray.length < 2) throw new DukeException("Todo needs a description");
          String dataString = fullCommand.replaceFirst("todo ", "");
          Task task = new Todo(dataString);
          return new AddCommand(task);
      }
      else if (command.equals("list")) {
          return new ListCommand();
      }
      else if (command.equals("delete")) {
          String dataString = fullCommand.replaceFirst("delete ", "");
          int taskNumber = String.parseInt(dataString);
          return new DeleteCommand(taskNumber);
      }
      else if (command.equals("mark")) {
          String dataString = fullCommand.replaceFirst("mark ", "");
          int taskNumber = String.parseInt(dataString);
          return new MarkCommand(taskNumber);
      }
      else if (command.equals("unmark")) {
          String dataString = fullCommand.replaceFirst("unmark ", "");
          int taskNumber = String.parseInt(dataString);
          return new MarkCommand(taskNumber);
      }
      else if (command.equals("bye")) {
          return new ExitCommand();
      }
      else {
          throw new DukeException("I don't recognize that command.");
      }
  }

  public Command buildDeadlineCommand() {

  }
  
}