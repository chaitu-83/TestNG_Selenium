package PageObject;

import org.openqa.selenium.By;

public class Docker_Home {

    public By signIn_Link()
    {
        return (By.xpath("(//a[text()='Sign In'])[1]"));
    }
    public By Logo()
    {
        return (By.xpath("//li[@class = 'logo']"));
    }
}
