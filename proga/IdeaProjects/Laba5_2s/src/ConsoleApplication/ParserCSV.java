package ConsoleApplication;

import ConsoleApplication.person.Person;

import java.util.LinkedList;

public class ParserCSV {
    protected final InputManager inputManager;
    protected final OutputManager outputManager;

    public ParserCSV(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public LinkedList<Person> read(String filename) {
        LinkedList<Person> result = new LinkedList<>();

        return result;
    }
}
