package com.maxpro.model.custom;

public class CustomUser {

    private String userName;
    private boolean enabled;

    public CustomUser() {
    }

    public CustomUser(String userName, boolean enabled) {
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
        return "CustomUser{" +
                "userName='" + userName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
