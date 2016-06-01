package pavel.klishin.vacancytestingapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.test.ApplicationTestCase;
import android.util.JsonReader;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Seva Powerman on 01.06.2016.
 */
public class JSONParserTest extends ApplicationTestCase <Application> {


    public JSONParserTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    @Test
    public static void main(String[]args) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/sdcard/info_about_dst.json"));
            org.json.simple.JSONObject jsonobject = (org.json.simple.JSONObject) obj;

            String dst_filename = (String) jsonobject.get("dst_name");
            String dst_password = (String) jsonobject.get("passwd");
            JSONArray dst_list = (JSONArray) jsonobject.get("dst");

            System.out.println(dst_filename);
            System.out.println(dst_password);
            System.out.println(dst_list);

            Iterator<String> iterator = dst_list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

