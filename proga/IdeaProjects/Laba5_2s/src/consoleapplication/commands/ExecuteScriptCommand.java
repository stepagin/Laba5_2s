package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.readers.simpleReaders.StringReader;

/**
 * Команда, задача которой считать и исполнить скрипт из указанного файла.
 */
public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String filename = new StringReader(inputManager, outputManager, false).read("имя файла");
        Interpreter innerInterpreter = new Interpreter(filename, interpreter.getCollection());
        innerInterpreter.run();
    }

    @Override
    public String getDescription() {
        return " file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
