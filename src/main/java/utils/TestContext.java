package utils;

import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    public  TestContext(){
        webDriverManager=new WebDriverManager("CHROME");

    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }
}
