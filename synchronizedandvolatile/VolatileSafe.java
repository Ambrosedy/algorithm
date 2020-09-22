package synchronizedandvolatile;

public class VolatileSafe {

    private volatile int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
