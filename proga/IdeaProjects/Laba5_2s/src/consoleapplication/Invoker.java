package consoleapplication;

import consoleapplication.commands.*;

import java.io.IOException;
import java.util.*;

/**
 * Хранит команды и историю выполненых команд.
 * Выполняет команды по требованию интерпретатора.
 */
public class Invoker {
    private final Map<String, Command> commands = new HashMap<>();
    private final OutputManager outputManager;
    private final List<String> history = new LinkedList<>();

    public Invoker(Interpreter interpreter) {
        this.outputManager = interpreter.getOutputManager();
        registerCommand(new HelpCommand(interpreter));
        registerCommand(new InfoCommand(interpreter));
        registerCommand(new ShowCommand(interpreter));
        registerCommand(new RemoveByIdCommand(interpreter));
        registerCommand(new AddCommand(interpreter));
        registerCommand(new ExitCommand(interpreter));
        registerCommand(new UpdateIdCommand(interpreter));
        registerCommand(new ClearCommand(interpreter));
        registerCommand(new RemoveLowerCommand(interpreter));
        registerCommand(new AddIfMaxCommand(interpreter));
        registerCommand(new HistoryCommand(interpreter));
        registerCommand(new CountByEyeColor(interpreter));
        registerCommand(new PrintAscendingCommand(interpreter));
        registerCommand(new FilterStartsWithNameCommand(interpreter));
        registerCommand(new SaveCommand(interpreter));
        registerCommand(new ExecuteScriptCommand(interpreter));

    }

    private void registerCommand(Command command){
        commands.put(command.getName(), command);
    }

    public Collection<Command> getAllCommands() {
        return commands.values();
    }

    public Command getCommandByName(String name){ // переместить в инвокер
        return commands.get(name.trim());
    }

    public void executeCommand(String comandName) {
        Command command = getCommandByName(comandName);
        if (command == null) {
            outputManager.writeLn("Команда не найдена");
        } else {
            try {

                command.execute();
                history.add(command.getName());

            } catch (IOException e) {
                outputManager.writeLn(e.getMessage());
            }
        }
    }

    public List<String> getHistory() {
        return history;
    }

}
