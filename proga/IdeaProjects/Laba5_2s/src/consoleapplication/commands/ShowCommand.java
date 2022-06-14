package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.Person;

/**
 * Команда, задача которой вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand extends Command{
    public ShowCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        if (collection.getAll().isEmpty()) {
            outputManager.writeLn("Коллекция не содержит ни одного элемента");
        } else {
//            System.out.println(collection.getAll());
            for (Person person : collection.getAll()) {
                outputManager.writeLn(person.toString());
            }
        }
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
