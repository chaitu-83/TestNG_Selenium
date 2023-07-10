package support;

import java.io.FileReader;
import java.util.Properties;

public class Support {
    public String read_properties_file(String key) throws Exception
    {
        FileReader reader=new FileReader("C:\\Users\\cjamm\\IdeaProjects\\selenium2_testING\\data.properties");

        Properties p=new Properties();
        p.load(reader);


        return p.getProperty(key);
    }
}
