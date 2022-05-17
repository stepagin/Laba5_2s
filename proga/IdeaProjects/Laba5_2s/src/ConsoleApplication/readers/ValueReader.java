package ConsoleApplication.readers;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.person.Person;
import ConsoleApplication.readers.complexReaders.ComplexValueReader;

public abstract class ValueReader<T> {
    protected final InputManager inputManager;
    protected final OutputManager outputManager;
    private boolean canBeNull;

    public ValueReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        setCanBeNull(canBeNull);
    }

    public ValueReader(InputManager inputManager, OutputManager outputManager) {
        this(inputManager, outputManager, true);
    }

    public T read(String fieldName) {
        if (!fieldName.isEmpty()) {
            outputManager.write("Введите " + fieldName + ": ");
        }
        T result = null;
        boolean notReaded = true;
        while (notReaded){
            try {
                result = readAttempt();
                notReaded = false;
            } catch (ValueFormatException e) {
                outputManager.writeLn(e.getMessage());
            }
        }
        return result;
    }

    public T read() {
        return read("");
    }

    protected T readAttempt() throws ValueFormatException {
        try{
            if (ComplexValueReader.class.isAssignableFrom(getClass())){
                return parse("");
            }
        } catch (Exception e) {}

        String res = inputManager.readNext();
        if (res.isEmpty()){
            if (isNullable()){
                return null;
            } else {
                throw new ValueFormatException("Поле не может быть пустым");
            }
        } else {
            return parse(res);
        }
    }

    abstract protected T parse(String argument) throws ValueFormatException;

    public boolean isNullable(){
        return canBeNull;
    }

    public void setCanBeNull(boolean canBeNull) {
        this.canBeNull = canBeNull;
    }
}
