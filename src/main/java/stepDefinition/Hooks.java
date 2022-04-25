package stepDefinition;

import cucumber.api.java.After;
import org.junit.Before;
import utils.TestContext;

public class Hooks {
  private TestContext testContext;
  public  Hooks(TestContext context){
      testContext=context;
  }

  @Before
    public void setUpBeforeEachTest(){
      testContext.getWebDriverManager().getActiveWebDriver();

  }
  @After
    public void tearDownAfterEachTest(){
      testContext.getWebDriverManager().getActiveWebDriver().close();
      testContext.getWebDriverManager().getActiveWebDriver().quit();
  }

}
