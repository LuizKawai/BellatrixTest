package types;

public enum LogMessageType {
    MESSAGE(1), WARNING(3), ERROR(2);

    LogMessageType(int i) {

    }

    private int value;

    public int getValue() {
        return value;
    }
}
