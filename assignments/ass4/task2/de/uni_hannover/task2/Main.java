package de.uni_hannover.task2;

import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.auth.Admin;
import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Item;

class Main {
    public static void main(String[] args) {
        User User1 = newUser("DNF", Category.ANIMALS);
        User User2 = newUser("KNF", Category.ELECTRONICS);
        Admin admin = new Admin("admin", "sudo");
        Marketplace mp = new Marketplace();
        mp.addUser(User1);
        mp.addUser(User2);
        mp.addUser(admin);
        User user = mp.login();
        if (user.isAdmin()) {
            mp.handleAdmin(user);
        } else {
            mp.handleUser(user);
        }

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