package examples;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesMain {

    public static void main(String[] args) throws IOException {
        // classpath에서 servlet.properties를 읽어들여 그안의 key와 value를 모두 출력하시오.

        ClassLoader classLoader
                = Thread.currentThread().getContextClassLoader();
        InputStream propstream =
                classLoader.getResourceAsStream("servlet.properties");

        Properties prop = new Properties();
        prop.load(propstream);

        Set<String> keyes = prop.stringPropertyNames();
        for(String key : keyes){
            System.out.println(key + ":" + prop.getProperty(key));
        }

    }



}
