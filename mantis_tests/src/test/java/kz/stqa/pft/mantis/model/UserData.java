package kz.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * Created by Xeniya on 17.07.2016.
 */
@Entity
@Table(name="mantis_user_table")
public class UserData {
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "username")
    private String username;
    @Expose
    @Column(name = "email")
    private String email;
    @Expose
    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (username != null ? !username.equals(userData.username) : userData.username != null) return false;
        return email != null ? email.equals(userData.email) : userData.email == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                '}';
    }
}
