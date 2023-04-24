import auth.User;
import offerings.Item;

class Main {
    public static void main(String[] args) {
    User User1 = newUser("DNF");
    User user2 = newUser("KNF");
    Marketplace mp = new Marketplace();
    mp.addUser(User1);
    mp.addUser(user2);
    System.out.println("Two users:");
    System.out.println(mp.str());
    Item[] items = User1.getItems();
    items[0].setPrice(69420);
    User1.setItems(items);
    
    System.out.println("Changed Price");
    System.out.println(mp.str()); 

    System.out.println("User2 removed");
    mp.removeUser(user2);
    System.out.println(mp.str()); 
    }
    //UserCreator with random items
    private static User newUser(String name) {
        User test = new User(name, name + "password");
        for (int i = 0; i  < 2; i++) {
            Item item = new Item(test.getUsername() + i + "item", (float) Math.floor(Math.random()*100), test, "Item #" + i + " of " + test.getUsername());
            test.addItem(item);
        }
        return test;
    }
}