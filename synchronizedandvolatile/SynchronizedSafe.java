package synchronizedandvolatile;

public class SynchronizedSafe {

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
