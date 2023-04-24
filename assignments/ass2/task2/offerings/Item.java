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
        return this.price;
    }
    public void setPrice (float price) {
        this.price = price;
    }

    public String getDescription () {
        return this.description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public String str (boolean showUser) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append("Name: " + this.name);
        sb.append(", ");
        sb.append("Price: " + this.price);
        sb.append(", ");
        sb.append("Description: " + this.description);
        if (showUser) {
            sb.append(", ");
            sb.append("User: " + this.user);
        }
        sb.append("]");
        return sb.toString();
    }
}
