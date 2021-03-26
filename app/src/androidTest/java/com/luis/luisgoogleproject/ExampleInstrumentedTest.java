package com.luis.luisgoogleproject;

import android.content.Context;
import android.text.TextUtils;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.luis.luisgoogleproject", appContext.getPackageName());
    }

    @Test
    public void testE() throws Exception {
        String formartBrand = getFormartBrand("dd");
        System.out.println("formartBrand");
//        String formartBrand1 = getFormartBrand("ddd");
//        System.out.println(formartBrand1);
//        String formartBrand2 = getFormartBrand("dddd");
//        System.out.println(formartBrand2);
    }

    public static String getFormartBrand(String value){
        if (value.length()<3) {
            StringBuilder stringBuilder = new StringBuilder(value);
            while (stringBuilder.length()<3){
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        if (TextUtils.equals("qcom", value)) {
            return "XDL";
        }else if(TextUtils.equals("LANDI", value)){
            return "LDI";
        }else if(TextUtils.equals("PAX", value)){
            return "PAX";
        }else{
            return value.substring(0,2);
        }
    }
}