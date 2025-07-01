package Bank;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class CurrentAccount extends Account {
    private double initialBalance;

    public CurrentAccount(String var1, String var2, String var3, double var4) {
        super(var1, var2, var3);
        this.initialBalance = var4;
        super.credit(var4);
    }

    public CurrentAccount(String var1, String var2, String var3) {
        super(var1, var2, var3);
        this.initialBalance = 0.0;
        super.credit(this.initialBalance);
    }

    public double debit(double var1) {
        if (var1 > 0.0 && this.getBalance() + this.initialBalance >= var1) {
            return super.debit(var1);
        } else {
            System.out.println("Amount exceeded balance");
            return this.getBalance();
        }
    }

    public String toString() {
        String var10000 = this.getId();
        return "CurrentAccount[id=" + var10000 + ", name=" + this.getName() + ", balance=" + this.getBalance() + "]";
    }
}

