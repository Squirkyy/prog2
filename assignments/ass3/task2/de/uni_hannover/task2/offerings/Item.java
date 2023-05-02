package de.uni_hannover.task2.offerings;

import javax.naming.AuthenticationException;

import de.uni_hannover.task2.auth.User;

/**
 * Provides the Item to the User for Trading purposes
 * 
 * @author Darius Vollmer
 * @version 1st May 2023
 */
public class Item {
    /**
     * Name of the Item
     */
    String name;
    /**
     * Price of the Item (must be non-negativ)
     */
    Float price;
    /**
     * References the User that owns the Item
     */
    User user;
    /**
     * Provides a detailed description of the Item
     */
    String description;

    /**
     * References a category
     */
    Category category;

    /**
     * Constructor for Item
     * 
     * @param name        for the new Item
     * @param price       for the new Item
     * @param user        that owns the item
     * @param description that summurizes the item
     * @param category    that the Item falls into
     * @throws IllegalArgumentException when price is negative
     */
    public Item(String name, Float price, User user, String description, Category category)
            throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a non negative value");
        } else {
            this.name = name;
            this.price = price;
            this.user = user;
            this.description = description;
            this.category = category;
        }
    }

    /**
     * Helper that verifies the user by password
     * 
     * @param password of the User
     * @return boolean that indicates if it is the user
     */
    private boolean isUser(String password) {
        if (this.user.getPassword() == password) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the category of the item
     * 
     * @return the category of the item
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets the category of the Item if the User is verified
     * 
     * @param category (new) of the item
     * @param password to verify the user
     * @throws AuthenticationException if the password is incorrect
     */
    public void setCategory(Category category, String password) throws AuthenticationException {
        if (isUser(password)) {
            this.category = category;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }
    }

    /**
     * Getter for the name of the object
     * 
     * @return name of the object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the Item if the User is verified
     * 
     * @param name     (new) of the item
     * @param passwort to verify the user
     * @throws AuthenticationException if the password is incorrect
     */
    public void setName(String name, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.name = name;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }

    }

    /**
     * Gets the price of the object
     * 
     * @return price of the object
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the Item if the User is verified
     * 
     * @param price    (new) of the item
     * @param passwort to verify the user
     * @throws AuthenticationException if the password is incorrect
     */
    public void setPrice(float price, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.price = price;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }
    }

    /**
     * Gets the description of the Item
     * 
     * @return description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the Item if the User is verified
     * 
     * @param description (new) of the item
     * @param passwort    to verify the user
     * @throws AuthenticationException if the password is incorrect
     */
    public void setDescription(String description, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.description = description;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }
    }

    /**
     * Gets the owner of the Item
     * 
     * @return User that ownes it
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Visualizes the Item in the form of a String
     * 
     * @param showUser that changes whether the User should be printed along side
     *                 the Item
     * @return String visualization of the Item
     */
    public String str(boolean showUser) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append("Name: " + this.name);
        sb.append(", ");
        sb.append("Price: " + this.price);
        sb.append(", ");
        sb.append("Description: " + this.description);
        sb.append(", ");
        sb.append("Category: " + this.category.str());
        if (showUser) {
            sb.append(", ");
            sb.append("User: " + this.user);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Visualizes the Item in the form of a String including a category
     * 
     * @param showUser that changes whether the User should be printed along side
     *                 the Item
     * @param category that should be filtered
     * @return String visualization of the Item
     */
    public String str(boolean showUser, Category category) {
        if (!category.isSameCategory(this)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[ ");
        sb.append("Name: " + this.name);
        sb.append(", ");
        sb.append("Price: " + this.price);
        sb.append(", ");
        sb.append("Description: " + this.description);
        sb.append(", ");
        sb.append("Category: " + this.category.str());
        if (showUser) {
            sb.append(", ");
            sb.append("User: " + this.user);
        }
        sb.append("]");
        return sb.toString();
    }
}
