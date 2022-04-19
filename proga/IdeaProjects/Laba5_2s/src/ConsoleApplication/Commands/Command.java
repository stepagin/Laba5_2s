package ConsoleApplication.Commands;

import ConsoleApplication.CollectionManager;
import ConsoleApplication.InputManager;
import ConsoleApplication.Interpreter;
import ConsoleApplication.OutputManager;

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

    public abstract void execute();

    public abstract String getDescription();

    public abstract String getName();
}
