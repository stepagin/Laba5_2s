package ConsoleApplication.commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.readers.simpleReaders.StringReader;

import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() throws IOException {
        String filename = new StringReader(inputManager, outputManager, false).read("имя файла");
        if (!filename.endsWith(".csv")) {
            filename = filename + ".csv";
        }
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
