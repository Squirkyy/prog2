package de.uni_hannover.task2;

import de.uni_hannover.task2.offerings.Category;
import javax.naming.AuthenticationException;
import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Item;

class Main {
    public static void main(String[] args) {
        User User1 = newUser("DNF", Category.ANIMALS);
        User User2 = newUser("KNF", Category.ELECTRONICS);
        Marketplace mp = new Marketplace();
        mp.addUser(User1);
        mp.addUser(User2);
        System.out.println("Filtering a category");
        System.out.println(mp.filterMarket(Category.ANIMALS));
        System.out.println();
        System.out.println();
        System.out.println("Two users:");
        System.out.println(mp.str());
        System.out.println();
        Item[] items = User1.getItems();
        try {
            items[0].setPrice(69420, User1.getPassword());
        } catch (AuthenticationException e) {
            System.out.println(e);
        }
        User1.setItems(items);
        System.out.println();
        System.out.println();
        System.out.println("Changed Price");
        System.out.println(mp.str());
        System.out.println();
        System.out.println();
        System.out.println("User2 removed");
        mp.removeUser(User2);
        System.out.println(mp.str());
    }

    // UserCreator with random items
    private static User newUser(String name, Category category) {
        User test = new User(name, name + "password");
        for (int i = 0; i < 2; i++) {
            Item item = new Item(test.getUsername() + i + "item", (float) Math.floor(Math.random() * 100), test,
                    "Item #" + i + " of " + test.getUsername(), category);
            test.addItem(item);
        }
        return test;
    }
}