package onskesoen.onskesoen.model;

public class Ønske {
    private int id;
    private int wishlist_id;

    private String ønskeNavn;

    public Ønske() {}

    public Ønske(int id, int wishlistId, String ønskeNavn) {
        this.id = id;
        this.wishlist_id = wishlistId;
        this.ønskeNavn = ønskeNavn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishlistId() {
        return wishlist_id;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }
    public String getØnskeNavn() {
        return ønskeNavn;
    }

    public void setØnskeNavn(String ønskeNavn) {
        this.ønskeNavn = ønskeNavn;
    }

    @Override
    public String toString() {
        return "Ønske{" +
                "id=" + id +
                ", wishlistId=" + wishlist_id +
                ", ønskeNavn='" + ønskeNavn + '\'' +
                '}';
    }
}
