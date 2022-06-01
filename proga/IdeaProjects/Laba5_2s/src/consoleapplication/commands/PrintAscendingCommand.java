package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.Person;

import java.util.Comparator;
import java.util.LinkedList;

public class PrintAscendingCommand extends Command {
    public PrintAscendingCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        LinkedList<Person> list = collection.getAll();
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });
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
