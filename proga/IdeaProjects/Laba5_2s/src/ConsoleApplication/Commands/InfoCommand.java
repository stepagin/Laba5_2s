package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;

public class InfoCommand extends Command{
    public InfoCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        outputManager.writeLn("Тип коллекции: " + collection.getType());
        outputManager.writeLn("Дата инициализации: " + collection.getInitializationDate());
        outputManager.writeLn("Количество элементов: " + collection.getElementsCount());
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public String getName() {
        return "info";
    }
}
