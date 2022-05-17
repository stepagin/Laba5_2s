package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.readers.simpleReaders.StringReader;

public class SaveCommand extends Command {
    public SaveCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String filename = new StringReader(inputManager, outputManager, false).read("имя файла");
        collection.saveToFile(filename);
        outputManager.writeLn("Коллекция сохранена в файл " + filename);
    }

    @Override
    public String getDescription() {
        return " filename : сохранить коллекцию в файл";
    }

    @Override
    public String getName() {
        return "save";
    }
}
