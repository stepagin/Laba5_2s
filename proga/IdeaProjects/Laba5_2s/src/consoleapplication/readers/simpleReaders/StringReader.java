package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;

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
//        System.out.println(argument.length() + ", " + lengthUpperBound + ", " + Integer.compare(argument.length(), lengthUpperBound));
        if ((lengthUpperBound != null) && Integer.compare(argument.length(), lengthUpperBound) > 0) {
//            System.out.println(lengthUpperBound);
            throw new ValueFormatException("Длина строки не должна быть больше " + lengthUpperBound);
        }
//        System.out.println("returns");
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
