package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.Person;
import consoleapplication.readers.complexReaders.PersonReader;

public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Person person = new PersonReader(inputManager, outputManager, false).read();
        collection.removeLower(person);
        outputManager.writeLn("Элементы коллекции, меньше чем заданный, удалены.");
    }

    @Override
    public String getDescription() {
        return " {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}
