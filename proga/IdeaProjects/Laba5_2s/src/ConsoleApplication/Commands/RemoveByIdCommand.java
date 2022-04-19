package ConsoleApplication.Commands;

import ConsoleApplication.Interpreter;

public class RemoveByIdCommand extends Command{
    public RemoveByIdCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        // TODO: read id, then remove (success or null)
    }

    @Override
    public String getDescription() {
        return "id: удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
