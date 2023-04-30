package auth;

import offerings.Item;

/**
 * Provides the User in an authenticated context (U+PW)
 * @author Darius Vollmer
 * @version 25th April 
 */
public class User {
    /**
     * String of the username
     */
    String username;
    /**
     * String of the password
     */
    String password;
    /**
     * All Items the user is offering
     */
    Item[] items;

    /**
     * Constructor for a User
     * Limits the ammount of Items they can offer to 10
     * @param userName of the new User
     * @param password of the new User
     */
    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.items = new Item[10];
    }

    /**
     * Getter of the Username
     * @return the Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter of the username
     * @param username that the user should have
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of the passwrd
     * @param password that the user should have
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the Items
     * @return all Items that the User has
     */
    public Item[] getItems() {
        return items;
    }
    /**
     * Setter for ALL items of the User 
     * @param items (new) that the user should own
     */
    public void setItems(Item[] items) {
        this.items = items;
    }
    /**
     * Computes the ammount of null spaces in an Array of Users
     * @param array of Users.
     * @return Ammount of null spaces in given Array
     */
    public int getRemainingSpace(Item[] array) {
        int spaceLeft = 0;
        for (Item element : array) {
            if (element == null) {
                spaceLeft++;
            }
        }
        return spaceLeft;
    }

    /**
     * Adds the Item to the Items-Array if there is space
     * @param item that is to be added
     * @return boolean wheather it was successful
     */
    public boolean addItem(Item item) {
        boolean result = false;
        if (getRemainingSpace(items) == 0) {
            result = false;
        } else {
            int index = 0;
            for (Item i : this.items) {
                if (i == null) {
                    items[index] = item;
                    result = true;
                    break;
                }
                index++;
            }
        }
        return result;
    }

    /**
     * Removes the Item in the Items-Array if it's there
     * @param item that is to be removed
     * @return boolean wheather it was successful
     */
    public boolean removeItem(Item item) {
        if (getRemainingSpace(this.items) == 10) {
            return false;
        } else {
            int index = 0;
            for (Item i : this.items) {
                if (i.getName().equals(item.getName()) && i.getUser().equals(item.getUser())) {
                    items[index] = null;
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    /**
     * Visualizes the User in a String
     * @param showPassword decides whether the password should be printed
     * @param showItemAmount decides whether the ammount of the items should be printed
     * @return String of the User in a visualized manner
     */
    public String str(boolean showPassword, boolean showItemAmount) {
        StringBuilder sb = new StringBuilder("[");
        sb.append("Username: " + getUsername());
        if (showPassword) {
            sb.append(", ");
            sb.append("Password: " + getPassword());
        }
        if (showItemAmount) {
            sb.append(", ");
            sb.append("Number of Items: ");
            sb.append(this.items.length - getRemainingSpace(this.items));
        } else {
            sb.append(", ");
            sb.append("Items: ");
            for (Item i : this.items) {
                if (i != null) {
                    sb.append(i.str(false));
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // public boolean removeItem(Item item) {
    // for (int index = 0; index <= items.length - 1; index++) {
    // if (items[index].equals(item)) {
    // items[index] = null;
    // return true;
    // }
    // }
    // return false;
    // }

}
