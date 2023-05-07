package de.uni_hannover.task2.auth;

/**
 * Provides the Admin thast extends the User in an authenticated context (U+PW)
 * 
 * @author Darius Vollmer
 * @version 6th May 2023
 */
public class Admin extends User {

    /**
     * Constructor for the Admin
     * 
     * @param userName for the new Admin
     * @param password for the new admin
     */
    public Admin(String userName, String password) {
        super(userName, password);
        this.isAdmin = true;
    }
}
