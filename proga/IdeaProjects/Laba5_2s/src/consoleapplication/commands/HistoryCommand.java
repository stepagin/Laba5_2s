package consoleapplication.commands;

import consoleapplication.Interpreter;

import java.util.List;
import java.util.ListIterator;

public class HistoryCommand extends Command {
    public HistoryCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        List<String> history = interpreter.getHistory();
        int startIndex = Math.max(0, history.size() - 10);
        ListIterator<String> iterator = history.listIterator(startIndex);
        while (iterator.hasNext()) {
            outputManager.writeLn(iterator.next());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести последние 10 команд (без их аргументов)";
    }

    @Override
    public String getName() {
        return "history";
    }
}
