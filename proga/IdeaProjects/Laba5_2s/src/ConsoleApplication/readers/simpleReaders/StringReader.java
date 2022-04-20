package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

public class StringReader extends SimpleValueReader<String> {
    boolean canBeEmpty = true;
    private Integer lengthUpperBound = null;

    public StringReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected String parse(String argument) throws ValueFormatException {
        if (!canBeEmpty && argument.trim().isEmpty()){
            throw new ValueFormatException("Эта строка не может быть пустой");
        }
        if (lengthUpperBound != null && Integer.compare(argument.length(), lengthUpperBound) < 1) {
            throw new ValueFormatException("Длина строки не должна быть больше 942");
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

    public Integer getLengthUpperBound() {
        return lengthUpperBound;
    }

    public StringReader setLengthUpperBound(Integer lengthUpperBound) {
        this.lengthUpperBound = lengthUpperBound;
        return this;
    }
}
