package onskesoen.onskesoen.model;

public class Ønskeliste {
    int wishlist_id; // Ændret attributtenavn til at matche kolonnenavnet i databasen
    String wishlist_name; // Ændret attributtenavn til at matche kolonnenavnet i databasen

    public Ønskeliste() {}

    public Ønskeliste(int wishlist_id, String wishlist_name) {
        this.wishlist_id = wishlist_id;
        this.wishlist_name = wishlist_name;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    @Override
    public String toString() {
        return "Ønskeliste{" +
                "wishlist_id=" + wishlist_id +
                ", wishlist_name='" + wishlist_name + '\'' +
                '}';
    }
}
