package ConsoleApplication.commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.readers.simpleReaders.StringReader;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String filename = new StringReader(inputManager, outputManager, false).read("имя файла");

        Interpreter innerInterpreter = new Interpreter(filename, interpreter.getCollection());
//        System.out.println(interpreter.getCollection().toString());
        innerInterpreter.run();
//        System.out.println(innerInterpreter.getCollection() + " fffiirrrst");
//        System.out.println(interpreter.getCollection() + " сэконд");
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
