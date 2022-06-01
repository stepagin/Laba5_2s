package consoleapplication.commands;

import consoleapplication.Interpreter;
import consoleapplication.person.eye.Color;
import consoleapplication.readers.simpleReaders.enumerable.EyeColorReader;

public class CountByEyeColor extends Command {
    public CountByEyeColor(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Color color = new EyeColorReader(inputManager, outputManager, false).read("Цвет глаз");
        outputManager.writeLn("Элементов с таким параметром: " + collection.getCountByEyeColor(color));
    }

    @Override
    public String getDescription() {
        return " eyeColor : вывести количество элементов, значение поля eyeColor которых равно заданному";
    }

    @Override
    public String getName() {
        return "count_by_eye_color";
    }
}
