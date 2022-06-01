package ConsoleApplication.commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.person.Person;
import ConsoleApplication.readers.complexReaders.PersonReader;
import ConsoleApplication.readers.simpleReaders.IntegerReader;

public class UpdateIdCommand extends Command {
    public UpdateIdCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Integer id = new IntegerReader(inputManager, outputManager, false).read();
        Person person = collection.get(id);
        if (person == null){
            outputManager.writeLn("Элемент с заданным id не найден");
        } else {
            Person value = new PersonReader(inputManager, outputManager, false).read();
            collection.remove(id);
            collection.add(value);
            outputManager.writeLn("Значение обновлено: " + value.toString());
        }
    }

    @Override
    public String getDescription() {
        return " id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update_id";
    }
}
