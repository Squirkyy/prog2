package de.uni_hannover.task2;

import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.auth.User;

/**
 * This Class provides the Marketplace on which Users are able to place items
 * for selling.
 * 
 * @author Darius Vollmer
 * @version 1st May 2023
 */
public class Marketplace {
    /**
     * Holds the users in the Marketplace.
     */
    User[] user;

    /**
     * Constructor for Marketplace. Sets the max ammount of users to 10.
     * 
     * @return A newly constructed Marketplace.
     */
    public Marketplace() {
        this.user = new User[10];
    }

    /**
     * Computes the ammount of null spaces in an Array of Users
     * 
     * @param array of Users.
     * @return Ammount of null spaces in given Array
     */
    public int getRemainingSpace(User[] array) {
        int spaceLeft = 0;
        for (User element : array) {
            if (element == null) {
                spaceLeft++;
            }
        }
        return spaceLeft;
    }

    /**
     * Adds user to the Array and reports whether it was successful
     * 
     * @param user to be added
     * @return Boolean to indicate whether it succeeded
     */
    public boolean addUser(User user) {
        boolean result = false;
        if (getRemainingSpace(this.user) == 0) {
            result = false;
        } else {
            int index = 0;
            for (User i : this.user) {
                if (i == null) {
                    this.user[index] = user;
                    result = true;
                    break;
                }
                index++;
            }
        }
        return result;
    }

    /**
     * Removes the user to the Array and reports whether it was successful
     * 
     * @param user to be removed
     * @return Boolean to indicate whether it succeeded
     */
    public boolean removeUser(User user) {
        if (getRemainingSpace(this.user) == 10) {
            return false;
        } else {
            int index = 0;
            for (User i : this.user) {
                if (i.getUsername().equals(user.getUsername()) && i.getUsername().equals(user.getUsername())) {
                    this.user[index] = null;
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    /**
     * Builds the marketplace in String format
     * 
     * @return String visualization of the Marketplace
     */
    public String str() {
        StringBuilder sb = new StringBuilder("[");
        for (User u : this.user) {
            if (u != null) {
                sb.append(u.str(false, false));
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * A filter function that takes in a category and returns all items of that
     * category
     * 
     * @param category that is to be filtered
     * @return user + items in that category
     */
    public String filterMarket(Category category) {
        StringBuilder sb = new StringBuilder("[");
        for (User u : this.user) {
            if (u != null) {
                sb.append(u.str(false, false, category));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
