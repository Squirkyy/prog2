package offerings;

import javax.naming.AuthenticationException;

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

    private boolean isUser(String password) {
        if (this.user.getPassword() == password) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.name = name;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }

    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.price = price;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description, String passwort) throws AuthenticationException {
        if (isUser(passwort)) {
            this.description = description;
        } else {
            throw new AuthenticationException("Incorrect Passwort.");
        }
    }

    public User getUser() {
        return this.user;
    }

    public String str(boolean showUser) {
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
