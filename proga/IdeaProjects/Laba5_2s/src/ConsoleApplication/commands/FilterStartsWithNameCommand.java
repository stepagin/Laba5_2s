package ConsoleApplication.commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.person.Person;
import ConsoleApplication.readers.simpleReaders.StringReader;

import java.util.LinkedList;

public class FilterStartsWithNameCommand extends Command {
    public FilterStartsWithNameCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String prefix = new StringReader(inputManager, outputManager, false).read("префикс");
        LinkedList<Person> list = collection.getAll();
        outputManager.writeLn("Элементы коллекции, у которых значение параметра name начинается с " + prefix + ":");
        for (Person element : list) {
            if (element.getName().startsWith(prefix)) {
                outputManager.writeLn(element.toString());
            }
        }
    }

    @Override
    public String getDescription() {
        return " name : вывести элементы, значение поля name которых начинается с заданной подстроки";
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
