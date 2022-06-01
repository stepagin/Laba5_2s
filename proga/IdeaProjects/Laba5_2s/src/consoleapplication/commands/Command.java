package consoleapplication.commands;

import consoleapplication.CollectionManager;
import consoleapplication.InputManager;
import consoleapplication.Interpreter;
import consoleapplication.OutputManager;

import java.io.IOException;

public abstract class Command {
    protected final Interpreter interpreter;
    protected final InputManager inputManager;
    protected final OutputManager outputManager;
    protected final CollectionManager collection;

    public Command(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.inputManager = interpreter.getInputManager();
        this.outputManager = interpreter.getOutputManager();
        this.collection = interpreter.getCollection();
    }

    public abstract void execute() throws IOException;

    public abstract String getDescription();

    public abstract String getName();
}
