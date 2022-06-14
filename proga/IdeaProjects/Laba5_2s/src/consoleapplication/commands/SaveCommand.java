package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.readers.simpleReaders.StringReader;

import java.io.IOException;

/**
 * Команда, задача которой сохранить коллекцию в файл
 */
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
