package consoleapplication.readers;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;

/**
 * задаёт правила считывания
 * @param <T> тип возвращаемого значения
 */
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

    /**
     * метод, считывающий из inputManager
     * @param fieldName название считываемого значение, которое выведется пользователю
     * @return тип, указаный при создании класса
     */
    public T read(String fieldName) {
        if (!fieldName.isEmpty() && !inputManager.ready()) { // проверяет, что указано имя считываемого поля и дальше нечего считывать
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
        String res = inputManager.readNext().trim();
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

    /**
     * преобразует строку в тип, указаный при создании класса
     * @param argument исходная строка
     * @return преобразованный тип
     * @throws ValueFormatException если входное значение не корректно
     */
    abstract protected T parse(String argument) throws ValueFormatException;

    public boolean isNullable(){
        return canBeNull;
    }

    public void setCanBeNull(boolean canBeNull) {
        this.canBeNull = canBeNull;
    }
}
