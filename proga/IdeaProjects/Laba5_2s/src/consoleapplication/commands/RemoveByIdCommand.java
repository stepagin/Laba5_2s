package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.readers.simpleReaders.IntegerReader;

public class RemoveByIdCommand extends Command{
    public RemoveByIdCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Integer id = new IntegerReader(inputManager, outputManager, false)
                .setLowerBound(0).read("id");
        if(collection.get(id) == null) {
            outputManager.writeLn("Элемент с заданным id не найден");
        } else {
            id = collection.get(id).getId();
            collection.remove(id);
            outputManager.writeLn("Элемент с id=" + id + " удалён.");
        }

    }

    @Override
    public String getDescription() {
        return " id: удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
