package ConsoleApplication.commands;

import ConsoleApplication.Interpreter;

public class ClearCommand extends Command {
    public ClearCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        collection.clear();
        outputManager.writeLn("Коллекция очищена");
    }

    @Override
    public String getDescription() {
        return ": очистить коллекцию";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
