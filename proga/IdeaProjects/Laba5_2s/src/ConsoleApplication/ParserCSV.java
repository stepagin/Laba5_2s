package ConsoleApplication;

import ConsoleApplication.person.Coordinates;
import ConsoleApplication.person.Country;
import ConsoleApplication.person.Location;
import ConsoleApplication.person.Person;
import ConsoleApplication.person.eye.Color;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Парсит коллекцию из .CSV файла
 */
public class ParserCSV {

    public LinkedList<Person> parse(String data) {
        LinkedList<Person> result = new LinkedList<>();
        String[] lines = data.split("\\n|\\r|\\r\\n"); // строки
        ArrayList<String> columnList = new ArrayList<>(9); // всего 9 колонок

        // впрямую, без проверки ограничений, считываю как в PersonReader, и добавляю в result
        // если на какой-то строке ошибка, её просто пропускаю и вывожу номер
        for(int i = 1; i <= lines.length; ++i){
            try {
                String[] fields = lines[i - 1].split(";");
                Integer id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String[] coordinates = fields[2].substring(3, fields[2].length()-2).split(", y="); // зависит от вывода
                Long c_x = Long.parseLong(coordinates[0]);
                Integer c_y = Integer.parseInt(coordinates[1]);
                ZonedDateTime creationDate = ZonedDateTime.parse(fields[3]);
                Long height = Long.parseLong(fields[4]);
                ConsoleApplication.person.eye.Color eyeColor = Color.valueOf(fields[5]);
                ConsoleApplication.person.hair.Color hairColor = ConsoleApplication.person.hair.Color.valueOf(fields[6]);
                Country nationality = Country.valueOf(fields[7]);

                String location_data = fields[8].substring(9, fields[8].length() - 1);
                String location_name = null;
                for(int j = 1; j < location_data.length(); ++j){
                    if(location_data.charAt(j) == '\'') {
                        location_name = location_data.substring(1, j);
//                        System.out.println(j + ", " + location_data.length());
//                        System.out.println(location_data);
                        location_data = location_data.substring(j+1);
                        break;
                    }
                }


                String[] location_numbers = location_data.split("(?!\\.)(?:\\D+)"); // оставить только числа

                Long l_x = Long.parseLong(location_numbers[1]);
                Integer l_y = Integer.parseInt(location_numbers[2]);
                Double l_z = Double.parseDouble(location_numbers[3]);
                Location location = new Location(l_x, l_y, l_z, location_name);

                Person p = new Person(id, name, new Coordinates(c_x, c_y), creationDate, height,
                        eyeColor, hairColor, nationality, location);
//                System.out.println(p);
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
