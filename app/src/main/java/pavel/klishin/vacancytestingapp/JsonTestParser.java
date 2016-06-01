package pavel.klishin.vacancytestingapp;

import org.json.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Seva Powerman on 01.06.2016.
 */
public class JsonTestParser {

    public static void main(String[]args) throws FileNotFoundException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("c:/sdcard/info_about_dst.json"));
            org.json.simple.JSONObject jsonobject = (org.json.simple.JSONObject) obj;

            String dst_filename = (String) jsonobject.get("dst_name");
            String dst_password = (String) jsonobject.get("passwd");

            System.out.println(dst_filename);
            System.out.println(dst_password);


            //Iterator <String> iterator = dst_list.iterator();
           // while (iterator.hasNext()) {
           //     System.out.println(iterator.next());
          //  }

      //  }// catch (ParseException e) {
          //  e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
