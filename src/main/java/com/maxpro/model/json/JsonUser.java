package com.maxpro.model.json;

public class JsonUser {

    private String userName;
    private boolean enabled;

    public JsonUser() {
    }

    public JsonUser(String userName, boolean enabled) {
        this.userName = userName;
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JsonUser{" +
                "userName='" + userName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
