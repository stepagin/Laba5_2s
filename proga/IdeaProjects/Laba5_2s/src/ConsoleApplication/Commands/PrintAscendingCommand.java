package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.person.Person;

import java.util.LinkedList;

public class PrintAscendingCommand extends Command {
    public PrintAscendingCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        LinkedList<Person> list = collection.getAll();;
        outputManager.writeLn("Отсортированный список:");
        for (Person element : list) {
            outputManager.writeLn(element.toString());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести элементы коллекции в порядке возрастания";
    }

    @Override
    public String getName() {
        return "print_ascending";
    }
}
