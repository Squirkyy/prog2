import auth.User;
import offerings.Item;

class Main {
    public static void main(String[] args) {
    User User1 = newUser("DNF");
    User user2 = newUser("KNF");
    Marketplace mp = new Marketplace();
    mp.addUser(User1);
    mp.addUser(user2);
    System.out.println(mp.str());
    }
    //UserCreator with random items
    private static User newUser(String name) {
        User test = new User(name, name + "password");
        for (int i = 1; i  < randomInt(1, 10); i++) {
            Item item = new Item(test.getUsername() + i + "item", (float) Math.random()*100, test, "Item #" + i + " of " + test.getUsername());
            test.addItem(item);
        }
        return test;
    } 

    private static int randomInt(int min, int max){
        int range = (((max - min) + 1));     
        return (int)(Math.random() * range) + min;
     }

}
