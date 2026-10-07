package bank;

public class icici extends bank {
    private int txCharge;

    public void txCharges(int charge) {
        this.txCharge = charge;
    }

    public int totalCharge () {
        return this.txCharge + getCharge();
    }
}
