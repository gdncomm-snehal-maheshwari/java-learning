package bank;

public class transaction {
    public static void main(String[] args) {
        hdfc hdfc = new hdfc();
        hdfc.charge(10);
        hdfc.txCharges(5);

        icici icici = new icici();
        icici.charge(10);
        icici.txCharges(3);

        System.out.println(hdfc.totalCharge());
        System.out.println(icici.totalCharge());
    }
}
