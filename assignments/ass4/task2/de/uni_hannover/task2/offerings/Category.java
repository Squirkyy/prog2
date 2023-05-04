package de.uni_hannover.task2.offerings;

/**
 * An Enum to provide categories for Items
 * 
 * @author Darius Vollmer
 * @version 1st May 2023
 */
public enum Category {
    FURNITURE, ELECTRONICS, SERVICES, CLOTHES, ANIMALS;

    /**
     * A visualized version of the enum in string form
     * 
     * @return string of the enum
     */
    public String str() {
        switch (this) {
            case FURNITURE:
                return "FURNITURE";
            case ELECTRONICS:
                return "ELECTRONICS";
            case SERVICES:
                return "SERVICES";
            case CLOTHES:
                return "CLOTHES";
            case ANIMALS:
                return "ANIMALS";
            default:
                return "";
        }
    }

    /**
     * Checks if an Item is of the same category
     * 
     * @param item that is to be compared
     * @return whether the item is of category this
     */
    public boolean isSameCategory(Item item) {
        if (item == null) {
            return false;
        }
        return this.equals(item.getCategory());
    }
}