package com.hendisantika.model.docs.diagnostic;

import com.hendisantika.model.data.base.Diagnostic;

public class DocsDiagnostic {
    private Diagnostic diagnostic;

    public DocsDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    @Override
    public String toString() {
        return "DocsDiagnostic{" +
                "diagnostic=" + diagnostic +
                '}';
    }
}
