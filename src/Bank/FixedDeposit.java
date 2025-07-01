package Bank;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class FixedDeposit extends Account {
    private int creditCount = 0;
    private double initialBalance;

    public FixedDeposit(String var1, String var2, String var3, double var4) {
        super(var1, var2, var3);
        this.initialBalance = var4;
        super.credit(var4 += var4 * 0.07);
    }

    public FixedDeposit(String var1, String var2, String var3) {
        super(var1, var2, var3);
        this.initialBalance = 0.0;
        super.credit(this.initialBalance += this.initialBalance * 0.07);
    }

    public double credit(double var1) {
        if (var1 > 0.0) {
            double var3 = this.getBalance() + var1;
            double var5 = var3 * 0.07;
            ++this.creditCount;
            return super.credit(var1 + var5);
        } else {
            return this.getBalance();
        }
    }

    public double debit(double var1) {
        if (var1 > 0.0 && this.getBalance() >= var1 && this.creditCount > 5) {
            return super.debit(var1);
        } else {
            System.out.println("\nAmount exceeded balance");
            return this.getBalance();
        }
    }

    public String toString() {
        String var10000 = this.getId();
        return "CurrentAccount[id=" + var10000 + ", name=" + this.getName() + ", balance=" + this.getBalance() + "]";
    }
}

