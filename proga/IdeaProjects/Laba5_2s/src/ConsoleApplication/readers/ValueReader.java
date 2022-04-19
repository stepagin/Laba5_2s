package ConsoleApplication.readers;

import ConsoleApplication.InputManager;

public abstract class ValueReader<T> {
    protected final InputManager inputManager;
    //protected final OutputManager outputManager; нужен ли он здесь?

    public ValueReader(InputManager inputManager) {
        this.inputManager = inputManager;
    }

}
