package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.Person;
import consoleapplication.readers.complexReaders.PersonReader;

public class AddIfMaxCommand extends Command {
    public AddIfMaxCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Person person = new PersonReader(inputManager, outputManager, false).read();
        if (person.compareTo(collection.getMax()) > 0) {
            collection.add(person);
            outputManager.writeLn("Добавлен элемент " + person.toString());
        } else {
            outputManager.writeLn("Элемент не добавлен.");
        }
    }

    @Override
    public String getDescription() {
        return " {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_max";
    }
}
