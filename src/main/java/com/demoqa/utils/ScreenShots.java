package com.demoqa.utils;

import com.demoqa.driver.SeleniumTestBase;
import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShots extends TestWatcher {

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

    private final static Logger LOGGER = Logger.getLogger(ScreenShots.class);

    @Override
    protected void failed(Throwable e, Description description) {

        if (!description.isTest()) {
            return;
        }

        if (SeleniumTestBase.driver instanceof TakesScreenshot) {
            byte[] screenshot = takeScreenshot();

            File dir = createDestDir(description.getClassName());
            String file = createFileName(description.getMethodName());
            save(screenshot, dir, file);
            LOGGER.info(String.format("Failed test: %s", description.getDisplayName()));
        }
    }

    private File createDestDir(String dirName) {

        String screenshotsDir = System.getenv("user.home") + "screenshots";

        File dir = new File(screenshotsDir.replace("null", ""), dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return dir;
    }

    private String createFileName(String methodName) {
        Calendar now = Calendar.getInstance();
        String timestamp = formatter.format(now.getTime());

        return String.format("%s_%s.png", methodName, timestamp);
    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) SeleniumTestBase.driver).getScreenshotAs(OutputType.BYTES);
    }

    private void save(byte[] bytes, File dir, String file) {

        try {
            FileOutputStream os = new FileOutputStream(new File(dir, file));
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

