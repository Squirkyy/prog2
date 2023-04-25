import auth.User;

public class Marketplace {
    User[] user;

    public Marketplace() {
        this.user = new User[10];
    }

    // Space of items left Helper
    public int getRemainingSpace(User[] array) {
        int spaceLeft = 0;
        for (User element : array) {
            if (element == null) {
                spaceLeft++;
            }
        }
        return spaceLeft;
    }

        // Adder and remover for User
        public boolean addUser(User user) {
            boolean result = false;
            if (getRemainingSpace(this.user) == 0) {
                result = false;
            } else {
                int index = 0;
                for (User i : this.user) {
                    if (i == null) {
                        this.user[index] = user;
                        result = true;
                        break;
                    }
                    index++;
                }
            }
            return result;
        }
    
        public boolean removeUser(User user) {
            if (getRemainingSpace(this.user) == 10) {
                return false;
            } else {
                int index = 0;
                for (User i : this.user) {
                    if (i.getUsername().equals(user.getUsername()) && i.getUsername().equals(user.getUsername())) {
                        this.user[index] = null;
                        return true;
                    }
                    index++;
                }
            }
            return false;
        }

        public String str() {
            StringBuilder sb = new StringBuilder("[");
            for (User u: this.user) {
                if( u != null) {
                sb.append(u.str(false, false));
                }}
            sb.append("]");
            return sb.toString();
        }
}
