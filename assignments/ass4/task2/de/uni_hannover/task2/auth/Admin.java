package de.uni_hannover.task2.auth;

public class Admin extends User {

    public Admin(String userName, String password) {
        super(userName, password);
        this.isAdmin = true;
    }
}
