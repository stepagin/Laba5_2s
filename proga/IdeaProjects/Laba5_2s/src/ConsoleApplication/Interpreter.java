package ConsoleApplication;

import ConsoleApplication.Commands.*;

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

        // TODO: other commands
    }

    /**
     * конструктор интерпретатора, исполняющего скрипт из файла.
     * @param scriptPath путь к файлу
     */
    public Interpreter(String scriptPath){
        this();
        try {
            inputManager.setInputFile(scriptPath);
            mode = InterpreterMode.SCRIPT;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("айайай выводи что не так"); // TODO: what's wrong
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

    /**
     * запуск основного цикла интерпретатора
     */
    public void run(){
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
                return false;
            case CONSOLE:
                return inputManager.hasNext();
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
            command.execute();
            outputManager.writeLn("");
            history.add(command.getName());
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