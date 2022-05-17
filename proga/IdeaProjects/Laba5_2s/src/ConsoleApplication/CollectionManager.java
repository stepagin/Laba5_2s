package ConsoleApplication;

import ConsoleApplication.person.Person;
import ConsoleApplication.person.eye.Color;

import java.io.IOException;
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

    public void remove(Integer id){
        Person p = get(id);
        collection.remove(p);
    }

    public void removeLower(Person element){
        collection.removeIf(person -> person.compareTo(element) < 0);
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

    public Person get(Integer id) {
        for(Person p : collection){
            if (((Integer)p.getId()).equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void clear() {
        collection.clear();
    }

    public Person getMax() {
        return Collections.max(collection);
    }

    public int getCountByEyeColor(Color eyeColor) {
        int sum = 0;
        for (Person p : collection){
            if (p.getEyeColor().equals(eyeColor)) {
                sum += 1;
            }
        }
        return sum;
    }

    public void saveToFile(String filename) {
        OutputManager om = new OutputManager();
        try {
            om.setOutputFile(filename); // здесь могут быть ошибки доступа к файлу
            String csvAllLines = toCSV();
            om.write(csvAllLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toCSV() {
        String result = "";
        for (Person person : collection) {
            result = result + person.convertToCSV() + '\n';
        }
        return result;
    }
}
