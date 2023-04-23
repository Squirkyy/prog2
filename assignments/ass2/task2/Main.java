import auth.User;
import offerings.Item;

class Main {
    public static void main(String[] args) {
        User test = new User("Squirky", "ihatethiscoursealready");
        // System.out.println("Name: " + test.getUsername());
        test.setItems(testItems());
        for (Item i : test.getItems()) {
            System.out.println(i.name);
        }
        Item testItem = new Item();
        testItem.name = "Item 4";
        testItem.description = "Description 4";
        testItem.price = (float) 4;
        testItem.user = new User("Test", "test");
        System.out.println(test.removeItem(test.getItems()[4]));
        for (Item i : test.getItems()) {
            System.out.println(i.name);
        }
        System.out.println(test.getRemainingSpace(test.getItems()));
        System.out.println(test.addItem(testItem));
    }

    // TESTFUNCTION for creating a items array for testing reasons
    private static Item[] testItems() {
        Item[] items = new Item[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item();
            items[i].name = "Item" + i;
            items[i].description = "Description" + i;
            items[i].price = (float) i;
            items[i].user = new User("Test", "test");
        }
        return items;
    }

}
