package onskesoen.onskesoen.model;

public class Ønske {
    private int id;
    private int wishlistId;
    private String ønskeNavn;

    public Ønske() {}

    public Ønske(int id, int wishlistId, String ønskeNavn) {
        this.id = id;
        this.wishlistId = wishlistId;
        this.ønskeNavn = ønskeNavn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
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
                ", wishlistId=" + wishlistId +
                ", ønskeNavn='" + ønskeNavn + '\'' +
                '}';
    }
}
