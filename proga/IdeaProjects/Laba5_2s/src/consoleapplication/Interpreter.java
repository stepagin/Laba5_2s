package consoleapplication;

import consoleapplication.commands.*;
import consoleapplication.person.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

enum InterpreterMode { CONSOLE, SCRIPT }

/**
 * Класс, связывающий команды из консоли с приложением.
 */
public class Interpreter {
    private InterpreterMode mode = InterpreterMode.CONSOLE;
    private final InputManager inputManager = new InputManager();
    private final OutputManager outputManager = new OutputManager();
    private CollectionManager collection = new CollectionManager();
    private boolean stopflag = false;
    private final Invoker invoker; // NEW!!!

    public Interpreter() {
        this.invoker = new Invoker(this);
    }


    public Interpreter(String scriptpath, CollectionManager collection) {
        this.collection = collection;
        this.invoker = new Invoker(this);
//        System.out.println(this.collection.getAll());
        this.mode = InterpreterMode.SCRIPT;
        try {
            inputManager.setInputFile(scriptpath);
        } catch (IOException e) {
            outputManager.writeLn(e.getMessage());
            stop();
        }
    }

    /**
     * запуск основного цикла интерпретатора
     */
    public void run(){
        while(shouldContinue()){
            readAndExecuteCommand();
        }
    }

    public void readCollectionFromFile(String filename) {
        try {
            collection.loadFromFileCSV(filename);
            outputManager.writeLn("Загружена коллекция из файла " + filename);
        } catch (FileNotFoundException e) {
            outputManager.writeLn("Не удалось найти файл с коллекцией");
            outputManager.writeLn(e.getMessage());
        } catch (IOException e) {
            outputManager.writeLn(e.getMessage());
        }
    }

    /**
     * проверка возможности продолжения основного цикла.
     * @return true - продолжать, false - не продолжать.
     */
    private boolean shouldContinue(){
        if (stopflag) {
            return false;
        }
        switch (mode) {
            case SCRIPT:
                return inputManager.hasNext();
            case CONSOLE:
                return true;
        }
        return false;
    }

    /**
     * Остановка основного цикла интерпретатора
     */
    public void stop(){
        stopflag = true;
    }


    private void readAndExecuteCommand(){
        String command = readCommand();
        invoker.executeCommand(command);
    }

    private String readCommand(){
        String name;
        do {
            name = inputManager.readNext().trim();
        } while (name.isEmpty());
        return name;
    }

    public Collection<Command> getAllCommands(){
        return invoker.getAllCommands();
    }

    public List<String> getHistory() {
        return invoker.getHistory();
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public OutputManager getOutputManager() {
        return outputManager;
    }

    public CollectionManager getCollection() {
        return collection;
    }
}
