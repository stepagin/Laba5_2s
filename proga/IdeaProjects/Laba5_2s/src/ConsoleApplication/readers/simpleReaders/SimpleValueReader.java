package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueReader;

public abstract class SimpleValueReader<T> extends ValueReader<T> {
    protected SimpleValueReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull){
        super(inputManager, outputManager, canBeNull);
    }

    protected SimpleValueReader(InputManager inputManager, OutputManager outputManager) {
        this(inputManager,outputManager, true);
    }
}
