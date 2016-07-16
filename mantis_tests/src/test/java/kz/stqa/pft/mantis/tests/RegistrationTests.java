package kz.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by xeniya on 7/16/16.
 */
public class RegistrationTests extends TestBase{

    @Test
    public  void testRegistration() {
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
