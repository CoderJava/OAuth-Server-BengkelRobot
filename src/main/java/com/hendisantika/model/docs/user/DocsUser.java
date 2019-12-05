package com.hendisantika.model.docs.user;

import com.hendisantika.db.user.User;
import com.hendisantika.model.data.base.Diagnostic;

public class DocsUser {
    private Diagnostic diagnostic;
    private User user;

    public DocsUser(Diagnostic diagnostic, User user) {
        this.diagnostic = diagnostic;
        this.user = user;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DocsUser{" +
                "diagnostic=" + diagnostic +
                ", user=" + user +
                '}';
    }
}
