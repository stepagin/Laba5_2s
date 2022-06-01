package ConsoleApplication.commands;


import ConsoleApplication.Interpreter;

public class HelpCommand extends Command{
    public HelpCommand(Interpreter interpreter){
        super(interpreter);
    }

    @Override
    public void execute() {
        for (Command command : interpreter.getAllCommands()) {
            outputManager.writeLn(command.getName() + "" + command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести справку по доступным командам";
    }

    @Override
    public String getName() {
        return "help";
    }
}
