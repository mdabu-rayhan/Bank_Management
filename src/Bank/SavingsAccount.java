package Bank;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class SavingsAccount extends Account {
    private double initialBalance;

    public SavingsAccount(String var1, String var2, String var3, double var4) {
        super(var1, var2, var3);
        this.initialBalance = var4;
        super.credit(var4 += var4 * 0.025);
    }

    public SavingsAccount(String var1, String var2, String var3) {
        super(var1, var2, var3);
        this.initialBalance = 0.0;
        super.credit(this.initialBalance += this.initialBalance * 0.025);
    }

    public double credit(double var1) {
        if (var1 > 0.0) {
            double var3 = this.getBalance() + var1;
            double var5 = var3 * 0.025;
            return super.credit(var1 + var5);
        } else {
            return this.getBalance();
        }
    }

    public double debit(double var1) {
        if (var1 > 0.0 && this.getBalance() - var1 > 1000.0) {
            return super.debit(var1);
        } else {
            System.out.println("Amount exceeded balance");
            return this.getBalance();
        }
    }

    public double transferTo(Account var1, double var2) {
        if (var2 > 0.0 && this.getBalance() - var2 > 1000.0) {
            super.debit(var2);
            var1.credit(var2);
        } else {
            System.out.println("Amount exceeded balance");
        }

        return this.getBalance();
    }

    public String toString() {
        String var10000 = this.getId();
        return "CurrentAccount[id=" + var10000 + ", name=" + this.getName() + ", balance=" + this.getBalance() + "]";
    }
}

