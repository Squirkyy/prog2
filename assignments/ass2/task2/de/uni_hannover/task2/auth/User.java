package auth;

import offerings.Item;

public class User {
    String username;
    String password;
    Item[] items;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.items = new Item[10];
    }

    // Username getter+setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password getter+setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Items getter+setter
    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    // Space of items left Helper
    public int getRemainingSpace(Item[] array) {
        int spaceLeft = 0;
        for (Item element : array) {
            if (element == null) {
                spaceLeft++;
            }
        }
        return spaceLeft;
    }

    // Adder and remover for items
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
