package kz.stqa.pft.mantis.appmanager;

import kz.stqa.pft.mantis.model.UserData;
import org.openqa.selenium.By;


/**
 * Created by Xeniya on 17.07.2016.
 */
public class PasswordHelper extends HelperBase {

    public PasswordHelper(ApplicationManager app){
        super(app);
    }

    public void initUserspage(){
        click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_overview_page.php']"));
        click(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']"));
    }

    public void initUserModification(int id) {
        wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id="+id+"']")).click();
    }
    public void resetPass(){
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void resetPassword(UserData user){
        initUserspage();
        initUserModification(user.getId());
        resetPass();
    }

    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void finish(String confirmationLink) {
        wd.get(confirmationLink);
        String password = "12345";
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
