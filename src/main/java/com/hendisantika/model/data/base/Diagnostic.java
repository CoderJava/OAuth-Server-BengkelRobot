package com.hendisantika.model.data.base;

public class Diagnostic {
    private int status;
    private String message;
    private long unix_timestamp;

    public Diagnostic() {
        unix_timestamp = System.currentTimeMillis();
    }

    public Diagnostic(int status, String message, long unix_timestamp) {
        this.status = status;
        this.message = message;
        this.unix_timestamp = unix_timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUnix_timestamp() {
        return unix_timestamp;
    }

    public void setUnix_timestamp(long unix_timestamp) {
        this.unix_timestamp = unix_timestamp;
    }

    @Override
    public String toString() {
        return "Diagnostic{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", unix_timestamp=" + unix_timestamp +
                '}';
    }
}
