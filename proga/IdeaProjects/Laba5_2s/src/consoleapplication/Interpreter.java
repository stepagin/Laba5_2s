package consoleapplication;

import consoleapplication.commands.*;

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
    private Map<String, Command> commands = new HashMap<>();
    private final List<String> history = new LinkedList<>();
    private CollectionManager collection = new CollectionManager();
    private boolean stopflag = false;

    public Interpreter() {
        registerCommand(new HelpCommand(this));
        registerCommand(new InfoCommand(this));
        registerCommand(new ShowCommand(this));
        registerCommand(new RemoveByIdCommand(this));
        registerCommand(new AddCommand(this));
        registerCommand(new ExitCommand(this));
        registerCommand(new UpdateIdCommand(this));
        registerCommand(new ClearCommand(this));
        registerCommand(new RemoveLowerCommand(this));
        registerCommand(new AddIfMaxCommand(this));
        registerCommand(new HistoryCommand(this));
        registerCommand(new CountByEyeColor(this));
        registerCommand(new PrintAscendingCommand(this));
        registerCommand(new FilterStartsWithNameCommand(this));
        registerCommand(new SaveCommand(this));

        registerCommand(new ExecuteScriptCommand(this));
    }

    /**
     * конструктор интерпретатора, исполняющего скрипт из файла.
     * @param scriptPath путь к файлу
     */
    public Interpreter(String scriptPath, CollectionManager collection){
        this();
//        System.out.println(this.collection.toString() + " first");
//        System.out.println(collection.toString() + " input");
        this.collection = collection;
//        System.out.println(this.collection.toString() + " second");
//        readAndExecuteCommand();
        try {
            inputManager.setInputFile(scriptPath);
            mode = InterpreterMode.SCRIPT;
        } catch (IOException e) {
            outputManager.writeLn(e.getMessage());
            stop();
        }
    }

    /**
     * Регистрирует команду
     * @param command - регистрируемая команда
     */
    private void registerCommand(Command command){
        commands.put(command.getName(), command);
    }

    public void readCollectionFromFile(String filename) {
        try {
            collection.loadFromFileCSV(filename);
        } catch (FileNotFoundException e) {
            outputManager.writeLn(e.getMessage());
        } catch (IOException e) {
            outputManager.writeLn(e.getMessage());
        }
    }

    /**
     * запуск основного цикла интерпретатора
     */
    public void run(){
        this.stopflag = false;
        while(shouldContinue()){
            readAndExecuteCommand();
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

    public void stop(){
        stopflag = true;
    }


    private void readAndExecuteCommand(){
        Command command = readCommand();
        if (command == null) {
            outputManager.writeLn("Команда не найдена");
        } else {
            try {
                command.execute();
                outputManager.writeLn("");
                history.add(command.getName());

            } catch (IOException e) {
                outputManager.writeLn(e.getMessage());
            }
        }
    }

    private Command readCommand(){
        String name;
        do {
            name = inputManager.readNext().trim();
        } while (name.isEmpty());
        return getCommandByName(name);
    }

    public Command getCommandByName(String name){
        return commands.get(name.trim());
    }

    public Collection<Command> getAllCommands(){
        return commands.values();
    }

    public List<String> getHistory() {
        return history;
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
