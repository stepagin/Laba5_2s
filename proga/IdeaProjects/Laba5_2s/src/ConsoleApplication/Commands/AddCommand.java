package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;

public class AddCommand extends Command {
    public AddCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
         // TODO: Worker worker = new WorkerReader(ioManager).setNullable(false).read();
        //collection.add(worker);
        //ioManager.writeLine("Добавлен объект: " + worker.toString());
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
