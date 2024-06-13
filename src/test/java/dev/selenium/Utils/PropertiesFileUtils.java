package dev.selenium.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String username;
    String password;
    public void readProperties() throws IOException {
        Properties properties=new Properties();
        FileInputStream fis=new
                FileInputStream("C:\\Users\\Admin\\IdeaProjects\\SeleniumRevisionProject2\\src\\test\\java\\User.properties");
        properties.load(fis);
        fis.close();

        setUsername(properties.getProperty("username"));
        setPassword(properties.getProperty("password"));
    }

}
