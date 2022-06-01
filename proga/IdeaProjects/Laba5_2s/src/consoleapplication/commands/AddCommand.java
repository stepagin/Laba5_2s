package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.Person;
import consoleapplication.readers.complexReaders.PersonReader;

public class AddCommand extends Command {
    public AddCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
         // TODO: Worker worker = new WorkerReader(ioManager).setNullable(false).read();
        //collection.add(worker);
        //ioManager.writeLine("Добавлен объект: " + worker.toString());
        Person person = new PersonReader(inputManager, outputManager, false).read();
        collection.add(person);
        outputManager.writeLn("В коллекцию добавлен элемент: " + person.toString());
    }

    @Override
    public String getDescription() {
        return " {element} : добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "add";
    }
}
