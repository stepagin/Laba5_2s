package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

public class StringReader extends SimpleValueReader<String> {
    boolean canBeEmpty = true;

    public StringReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected String parse(String argument) throws ValueFormatException {
        if (!canBeEmpty && argument.trim().isEmpty()){
            throw new ValueFormatException("Эта строка не может быть пустой");
        }
        return argument;
    }

    boolean isCanBeEmpty() {
        return canBeEmpty;
    }

    public StringReader setCanBeEmpty(boolean canBeEmpty) {
        this.canBeEmpty = canBeEmpty;
        return this;
    }
}
