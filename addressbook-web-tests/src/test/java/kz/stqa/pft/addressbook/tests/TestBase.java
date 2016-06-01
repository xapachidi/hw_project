package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by xeniya on 6/1/16.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {

        app.stop();
    }

}
