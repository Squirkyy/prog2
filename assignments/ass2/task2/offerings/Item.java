package offerings;

import auth.User;

public class Item {
    String name;
    Float price;
    User user;
    String description;

    public Item(String name, Float price, User user, String description) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a non negative value");
        } else {
            this.name = name;
            this.price = price;
            this.user = user;
            this.description = description;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice () {
        return 
    }
}
