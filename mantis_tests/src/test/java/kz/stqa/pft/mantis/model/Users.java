package kz.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;
import kz.stqa.pft.mantis.model.UserData;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by xeniya on 6/21/16.
 */
public class Users extends ForwardingSet<UserData> {

    private Set<UserData> delegate;

    public Users(Users users){
        this.delegate = new HashSet<UserData>(users.delegate);
    }

    public Users() {
        this.delegate = new HashSet<UserData>();

    }
    public Users(Collection<UserData> users) {
        this.delegate = new HashSet<UserData>(users);
    }

    @Override
    protected Set<UserData> delegate() {
        return delegate;
    }


}
