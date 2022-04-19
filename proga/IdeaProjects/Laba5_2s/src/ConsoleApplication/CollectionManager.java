package ConsoleApplication;

import ConsoleApplication.person.Person;

import java.time.LocalDate;
import java.util.*;

public class CollectionManager {
    private Set<Person> collection = new LinkedHashSet<>();
    private final LocalDate initializationDate;


    public CollectionManager() {
        initializationDate = LocalDate.now();
    }

    public void add(Person element){
        collection.add(element);
    }

    public void remove(Person element){
        collection.remove(element);
    }

    public String getType() {
        return collection.getClass().getSimpleName();
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public int getElementsCount() {
        return collection.size();
    }

    public LinkedList<Person> getAll() {
        return new LinkedList<>(collection);
    }
}
