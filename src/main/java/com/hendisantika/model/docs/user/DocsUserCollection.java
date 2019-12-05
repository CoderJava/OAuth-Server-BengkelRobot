package com.hendisantika.model.docs.user;

import com.hendisantika.db.user.User;
import com.hendisantika.model.data.base.Diagnostic;

import java.util.List;

public class DocsUserCollection {
    private Diagnostic diagnostic;
    private List<User> users;

    public DocsUserCollection(Diagnostic diagnostic,
                              List<User> users) {
        this.diagnostic = diagnostic;
        this.users = users;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DocsUserCollection{" +
                "diagnostic=" + diagnostic +
                ", users=" + users +
                '}';
    }
}
