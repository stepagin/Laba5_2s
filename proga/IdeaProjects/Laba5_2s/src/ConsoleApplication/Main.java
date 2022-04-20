package ConsoleApplication;

import ConsoleApplication.person.Person;
import ConsoleApplication.readers.complexReaders.PersonReader;
import ConsoleApplication.readers.simpleReaders.IntegerReader;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputManager im= new InputManager();
        OutputManager om = new OutputManager();
        PersonReader pr = new PersonReader(im, om);
        Person p = new PersonReader(im, om).read("человека в формате");
        System.out.println(p.toString());


    }
}
