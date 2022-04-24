package stepDefinition;

import pageobjects.Register;
import utils.TestContext;

public class RegistrationSteps {

    private TestContext context;
    private Register registerPage;

    public RegistrationSteps(TestContext testContext){
        context=testContext;
        registerPage=new Register(context.getWebDriverManager().getActiveWebDriver());
    }
}
