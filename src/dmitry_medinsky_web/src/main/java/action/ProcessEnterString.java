package action;/* Создано 01.12.13 в 16:37 */

import java.lang.String;
import java.util.ArrayList;

public class ProcessEnterString {

    // Конструктор
    public ProcessEnterString() {

    }

    // Разбираем строку на параметры
    public ArrayList<Integer> splitString(String values) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String value;

        while (!values.equals("")) {
            int pos = values.indexOf(" ");
            if (pos == -1) {
                value = values;
                values = "";

                result.add(Integer.parseInt(value));
            } else {
                value = values.substring(0 , pos);
                values = values.substring(pos +1, values.length());

                result.add(Integer.parseInt(value));
            }
        }

        return result;
    }


}
