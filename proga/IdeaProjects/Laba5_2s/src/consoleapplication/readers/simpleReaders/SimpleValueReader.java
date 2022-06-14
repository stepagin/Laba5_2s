package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueReader;

/**
 * Класс, задающий правила считывания простых типов
 * @param <T> тип значения
 */
public abstract class SimpleValueReader<T> extends ValueReader<T> {
    protected SimpleValueReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull){
        super(inputManager, outputManager, canBeNull);
    }

    protected SimpleValueReader(InputManager inputManager, OutputManager outputManager) {
        this(inputManager,outputManager, true);
    }
}
