package Transport_Managment;

public enum Status {
    PAID(1),
    Unpaid(0);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



