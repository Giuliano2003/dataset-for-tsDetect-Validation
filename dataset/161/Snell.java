public class Rank {
    private final String text;
    private final int value;

    Rank(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public String toString() {
        return text;
    }

    public int toInt() {
        return value;
    }
}