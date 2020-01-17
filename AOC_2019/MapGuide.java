public class MapGuide {
    private String direction;
    private int amount;

    public MapGuide(String direction, int amount) {
        this.direction = direction;
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public int getAmount() {
        return amount;
    }
}