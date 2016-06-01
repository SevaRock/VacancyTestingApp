package pavel.klishin.vacancytestingapp;

import android.content.Context;
import android.os.Environment;

import org.json.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
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
            JSONObject jsonobject = (JSONObject) obj;

            org.json.simple.JSONArray dst_list = (org.json.simple.JSONArray) jsonobject.get("dst");
            Iterator i = dst_list.iterator();
            while (i.hasNext()) {
                JSONObject dst = (JSONObject) i.next();
                String name = (String) dst.get("dst_name");
                System.out.println(name);
                String password = (String) dst.get("passwd");
                System.out.println(password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
