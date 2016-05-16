package pavel.klishin.vacancytestingapp;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.ECField;

import dalvik.annotation.TestTargetClass;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    final String cmdFileCreateOverADB = "adb dd if=/dev/zero of=/sdcard/fileADB.txt bs=1000000000M count=1";

    @Test
    public void largeFileCreateTest() throws Exception {
        try {
            Process createFileProcess = Runtime.getRuntime().exec(cmdFileCreateOverADB);
            DataOutputStream outputStream = new DataOutputStream(createFileProcess.getOutputStream());
            outputStream.writeBytes(cmdFileCreateOverADB);
            outputStream.flush();
            createFileProcess.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}