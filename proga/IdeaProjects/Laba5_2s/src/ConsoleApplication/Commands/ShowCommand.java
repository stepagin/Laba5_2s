package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;
import ConsoleApplication.person.Person;

public class ShowCommand extends Command{
    public ShowCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        for (Person person : collection.getAll()) {
            outputManager.writeLn(person.toString());
        }
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
