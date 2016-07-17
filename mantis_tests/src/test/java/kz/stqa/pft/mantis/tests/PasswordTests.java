package kz.stqa.pft.mantis.tests;

import kz.stqa.pft.mantis.appmanager.HttpSession;
import kz.stqa.pft.mantis.model.MailMessage;
import kz.stqa.pft.mantis.model.UserData;
import kz.stqa.pft.mantis.model.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Xeniya on 17.07.2016.
 */
public class PasswordTests extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }


    @Test
    public void testPassword() throws IOException, MessagingException {
        HttpSession session = app.newSession();
        String user = "administrator";
        String password = "root";
        app.user().start(user, password);
        Users users = app.db().users();
        UserData modifiedUser = users.iterator().next();
        app.user().resetPassword(modifiedUser);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, modifiedUser.getEmail());
        app.user().finish(confirmationLink);
        String new_password = "12345";
        app.user().start(modifiedUser.getUsername(), new_password);
        // без использования браузера
        //session.login(modifiedUser.getUsername(), new_password);
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }

}
