package helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class utility {
    public static File jsonSchema(String file_Name){
        return new File("src/test/java/helper/JsonSchema/"+file_Name);
    }

    public static String pembuatEmail(){
        String karakterYangDiperbolehkan = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-_.";
        String email = "";
        String temp = RandomStringUtils.randomAlphabetic(10);
        email = temp + "@gmail.com";
        return email;
    }
}
