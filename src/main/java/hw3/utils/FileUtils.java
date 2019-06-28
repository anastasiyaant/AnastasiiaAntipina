package hw3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
    public static User readUserFromFile(String filePath) {
        Properties prop = new Properties();
        User user = new User();
        try (InputStream input = FileUtils.class.getClassLoader().getResourceAsStream("user.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find user.properties");
            }
            prop.load(input);
            user.setUserName(prop.getProperty("user.name"));
            user.setFullName(prop.getProperty("user.user.name"));
            user.setPassword(prop.getProperty("user.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }
}
