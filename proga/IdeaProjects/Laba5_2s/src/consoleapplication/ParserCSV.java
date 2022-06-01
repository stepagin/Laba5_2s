package consoleapplication;

import consoleapplication.person.Coordinates;
import consoleapplication.person.Country;
import consoleapplication.person.Location;
import consoleapplication.person.Person;
import consoleapplication.person.eye.Color;

import java.time.ZonedDateTime;
import java.util.LinkedList;

/**
 * Парсит коллекцию из .CSV файла
 */
public class ParserCSV {

    public LinkedList<Person> parse(String data) {
        LinkedList<Person> result = new LinkedList<>();
        String[] lines = data.split("\\n|\\r|\\r\\n"); // строки

        // впрямую, без проверки ограничений, считываю как в PersonReader, и добавляю в result
        // если на какой-то строке ошибка, её просто пропускаю и вывожу номер
        for(int i = 1; i <= lines.length; ++i){

            try {
                String[] columns = lines[i - 1].split(";");

                Integer id = Integer.parseInt(columns[0]);

                String name = columns[1];

                // parsing coordinates
                String[] personCoordinatesData = columns[2].substring(3, columns[2].length()-1).split(", y="); // зависит от вывода
                Long coordinatesX = Long.parseLong(personCoordinatesData[0]);
                Integer coordinatesY = Integer.parseInt(personCoordinatesData[1]);

                ZonedDateTime creationDate = ZonedDateTime.parse(columns[3]);

                Long height = Long.parseLong(columns[4]);

                consoleapplication.person.eye.Color eyeColor = Color.valueOf(columns[5]);

                consoleapplication.person.hair.Color hairColor = consoleapplication.person.hair.Color.valueOf(columns[6]);

                Country nationality = Country.valueOf(columns[7]);

                // parsing location
                String locationData = columns[8].substring(9, columns[8].length() - 1);
                String locationName = null;
                for(int j = 1; j < locationData.length(); ++j){
                    if(locationData.charAt(j) == '\'') {
                        locationName = locationData.substring(1, j);
                        locationData = locationData.substring(j+1);
                        break;
                    }
                }
                String[] locationNumbers = locationData.split("(?!\\.)(?:\\D+)"); // оставить только числа
                Long locationCoordinateX = Long.parseLong(locationNumbers[1]);
                Integer locationCoordinateY = Integer.parseInt(locationNumbers[2]);
                Double locationCoordinateZ = Double.parseDouble(locationNumbers[3]);
                Location location = new Location(locationCoordinateX, locationCoordinateY, locationCoordinateZ, locationName);

                Person p = new Person(id, name, new Coordinates(coordinatesX, coordinatesY), creationDate, height,
                        eyeColor, hairColor, nationality, location);
                result.add(p);
            } catch(Exception e) {
//                System.out.println(e.getMessage() + " на строке " + i);
//                e.printStackTrace();
                // произошла ошибка считывания на строке i
            }
        }

        return result;
    }
}
