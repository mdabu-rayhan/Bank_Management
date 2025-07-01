package Bank;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Account {
    private String id;
    private String name;
    private String password;
    private double balance;

    public Account(String var1, String var2, String var3, double var4) {
        this.id = var1;
        this.name = var2;
        this.password = var3;
        this.balance = var4;
    }

    public Account(String var1, String var2, String var3) {
        this.id = var1;
        this.name = var2;
        this.password = var3;
        this.balance = 0.0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setPassword(String var1) {
        this.password = var1;
    }

    public boolean checkPassword(String var1) {
        return this.password.equals(var1);
    }

    public double credit(double var1) {
        if (var1 > 0.0) {
            this.balance += var1;
        }

        return this.balance;
    }

    public double debit(double var1) {
        if (var1 > 0.0 && var1 <= this.balance) {
            this.balance -= var1;
        } else {
            System.out.println("\nAmount exceeded balance");
        }

        return this.balance;
    }

    public double transferTo(Account var1, double var2) {
        if (var2 > 0.0 && var2 <= this.balance) {
            this.debit(var2);
            var1.credit(var2);
        } else {
            System.out.println("\nAmount exceeded balance");
        }

        return this.balance;
    }

    public String toString() {
        return "Account[id=" + this.id + ", name=" + this.name + ", balance=" + this.balance + "]";
    }
}

