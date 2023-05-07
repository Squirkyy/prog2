package de.uni_hannover.task2;

import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.offerings.Item;

import java.util.Scanner;

import de.uni_hannover.task2.auth.User;

/**
 * This Class provides the Marketplace on which Users are able to place items
 * for selling.
 * 
 * @author Darius Vollmer
 * @version 5th May 2023
 */
public class Marketplace {
    /**
     * Holds the users in the Marketplace.
     */
    User[] user;

    /**
     * A static and constant Scanner that utilizes the Standard input defined for
     * thread safety
     */
    public static final Scanner input = new Scanner(System.in);

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
                if (i == null)
                    continue;
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

    /**
     * Provides a login handler that allows Users to login with 3 tries
     * 
     * @return the user if the login was successful
     */
    public User login() {
        int tries = 1;
        while (tries <= 3) {
            tries++;
            String username;
            String password;
            System.out.print("Please enter your username: ");
            username = input.nextLine();
            System.out.print("Please enter your password: ");
            password = input.nextLine();
            for (User u : this.user) {
                if (u == null)
                    continue;
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u;
                } else {
                    continue;
                }
            }
            System.out.println("Username and/or password wrong. Trying again...");
        }
        System.exit(0);
        return null;
    }

    /**
     * Handler for the marketplace management from userperspective
     * 
     * @param user that is the current controller
     */
    public void handleUser(User user) {
        String choice;
        StringBuilder sb = new StringBuilder("Wählen Sie aus den folgenden Optionen aus: \n");
        sb.append("1. Item hinzufügen \n");
        sb.append("2. Item entfernen \n");
        sb.append("3. Marketplace anschauen \n");
        sb.append("4. Programm beenden \n");
        System.out.print(sb.toString());
        choice = input.nextLine();

        switch (choice) {
            case "1":
                newItem(user);
                break;
            case "2":
                removeItem(user);
                break;
            case "3":
                showMarketplace(user);
                break;
            case "4":
                System.exit(0);
                break;
            default:
                break;
        }

    }

    /**
     * Handler for the marketplace management from admin perspective
     * 
     * @param user that is the current admin
     */
    public void handleAdmin(User user) {
        String choice;
        StringBuilder sb = new StringBuilder("Wählen Sie aus den folgenden Optionen aus: \n");
        sb.append("1. Nutzer entfernen \n");
        sb.append("2. Item entfernen \n");
        sb.append("3. Programm beenden \n");
        System.out.println(sb.toString());
        choice = input.nextLine();

        switch (choice) {
            case "1":
                removeUserAsAdmin(user);
                break;
            case "2":
                remItemAsAdmin(user);
                break;
            case "3":
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * Helper to add a new item from a user
     * 
     * @param user that owns the new item
     */
    private void newItem(User user) {
        String name, desc;
        Category cat = Category.ANIMALS;
        Float price;
        System.out.print("Wie soll der Gegenstand heißen?");
        name = input.nextLine();
        System.out.print("Beschreibe den Gegenstand: ");
        desc = input.nextLine();
        System.out.print("Wie teuer ist der Gegenstand?");
        price = Float.parseFloat(input.nextLine());
        System.out.println("Zu welcher Kategorie gehört der Gegenstand?");
        int i = 1;
        for (Category cate : Category.values()) {
            System.out.println(i + cate.str());
            i++;
        }
        i = Integer.parseInt(input.nextLine());
        switch (i) {
            case 1:
                cat = Category.values()[0];
                break;
            case 2:
                cat = Category.values()[1];
                break;
            case 3:
                cat = Category.values()[2];
                break;
            case 4:
                cat = Category.values()[3];
                break;
            case 5:
                cat = Category.values()[4];
                break;
            default:
                System.out.println("Not a valid input. Shutting down...");
                System.exit(0);
                break;
        }

        Item newItem = new Item(name, price, user, desc, cat);
        if (user.addItem(newItem)) {
            System.out.println("Successfully added new item. Going back to main menu...");
            handleUser(user);
        }
    }

    /**
     * Helper to remove an item from a user
     * 
     * @param user that owns the item to be removed
     */
    private void removeItem(User user) {
        System.out.println("Welcher der folgenden Gegenstände soll gelöscht werden? Schreibe den Namen: ");
        System.out.println(user.str(false, false));
        String itemName = input.nextLine();
        for (Item i : user.getItems()) {
            if (i == null)
                continue;
            if (i.getName().equals(itemName)) {
                if (user.removeItem(i)) {
                    System.out.println("Successfully removed item. Going back to main menu...");
                    handleUser(user);
                }
            }
        }
    }

    /**
     * Prints the marketpalce with the optional filter of categories
     * 
     * @param user that accesses the marketplace
     */
    private void showMarketplace(User user) {
        System.out.println("Welche Kategorie wollen Sie sich anschauen: ");
        Category cat = Category.ANIMALS;
        int i = 1;
        for (Category cate : Category.values()) {
            System.out.println(i + ". " + cate.str());
            i++;
        }
        System.out.println(i + ". " + "Alle");
        i = Integer.parseInt(input.nextLine());
        switch (i) {
            case 1:
                cat = Category.values()[0];
                break;
            case 2:
                cat = Category.values()[1];
                break;
            case 3:
                cat = Category.values()[2];
                break;
            case 4:
                cat = Category.values()[3];
                break;
            case 5:
                cat = Category.values()[4];
                break;
            case 6:
                i = -1;
                break;
            default:
                System.out.println("Not a valid input. Shutting down...");
                System.exit(0);
                break;
        }

        if (i == -1) {
            System.out.println(str());
            System.out.println("");
            System.out.println("Going back to main menu...");
            handleUser(user);
        } else {
            System.out.println(filterMarket(cat));
            System.out.println("");
            System.out.println("Going back to main menu...");
            handleUser(user);
        }
    }

    /**
     * Helper to remove a user from the marketplace by an admin
     * 
     * @param user admin that removes the user
     */
    private void removeUserAsAdmin(User user) {
        StringBuilder sb = new StringBuilder(
                "User:\n");
        for (User u : this.user) {
            if (u == null)
                continue;
            sb.append(u.getUsername() + "\n");
        }
        System.out.println(sb.toString());
        sb.append("Schreibe den Namen des Benutzernamen des Nutzers, der gelöscht werden soll: ");
        String username = input.nextLine();
        for (User u : this.user) {
            if (u == null)
                continue;
            if (u.getUsername().equals(username)) {
                if (removeUser(u)) {
                    System.out.println("Successfully removed user. Going back to main menu...");
                    handleAdmin(user);
                }
            }
        }
    }

    /**
     * Helper to remove an item of a user from the marketplace by an admin
     * 
     * @param user admin that removes the user
     */
    private void remItemAsAdmin(User user) {
        System.out.println(str());
        System.out.println("Gebe den Namen von dem User, dessen Item gelöscht werden soll, ein: ");
        String username = input.nextLine();
        User itemUser = null;
        for (User u : this.user) {
            if (u == null)
                continue;
            if (u.getUsername().equals(username)) {
                itemUser = u;
                break;
            }
        }
        if (itemUser == null) {
            System.out.println("User not found. Going back to main menu...");
            handleAdmin(user);
            return;
        }
        System.out.print("Gebe den Namen von dem Item, dass gelöscht werden soll, ein: ");
        String item = input.nextLine();
        Item itemToBeDeleted = null;
        for (Item i : itemUser.getItems()) {
            if (i == null)
                continue;
            if (item.equals(i.getName())) {
                itemToBeDeleted = i;
            }
        }
        if (itemToBeDeleted == null) {
            System.out.println("Item not found. Going back to main menu...");
            handleAdmin(user);
            return;
        }
        if (itemUser.removeItem(itemToBeDeleted)) {
            System.out.println("Successfully removed item " + item + " from user " + username
                    + ". Going back to main menu...");
            handleAdmin(user);
        }
    }
}
