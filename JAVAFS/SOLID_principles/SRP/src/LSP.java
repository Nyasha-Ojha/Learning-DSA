import java.util.*;

interface DepositOnlyAcc{
    void deposit(double amount);
}
interface WithDrawableAcc extends DepositOnlyAcc{
    void withdraw(double amount);
}
class SavingsAccount implements WithDrawableAcc{
    private double balance;

    public SavingsAccount(){
        balance = 0;
    }
    @Override
    public void deposit(double amount){
        balance += amount;
        System.out.println("Rs " + amount + " deposited to the Savings account.\nNew balance: " + balance);
    }
    @Override
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Rs " + amount + " withdrawn from the Savings account.\nNew balance: " + balance);
        }else{
            System.out.println("Insufficient funds in Savings Account!" + "Current account balance: " + balance);
        }
    }
}

class CurrentAccount implements WithDrawableAcc{
    private double balance;

    public CurrentAccount(){
        balance = 0;
    }

    @Override
    public void deposit(double amount){
        balance += amount;
        System.out.println("Rs " + amount + " deposited to the Current account.\nNew balance: " + balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Rs " + amount + " withdrawn from the Current account.\nNew balance: " + balance);
        }
        else{
            System.out.println("Insufficient funds in Savings Account!" + "Current account balance: " + balance);
        }
    }
}
class FixedDepositAcc implements DepositOnlyAcc{
    private double balance;

    public FixedDepositAcc(){
        balance = 0;
    }
    @Override
    public void deposit(double amount){
        balance += amount;
        System.out.println("Rs " + amount + " deposited to the Fixed Deposit account.\nNew balance: " + balance);
    }
}

class BankClient{
    private List<DepositOnlyAcc> depositOnlyAcc = new ArrayList<>();
    private List<WithDrawableAcc> withdrawableAccounts = new ArrayList<>();

    public BankClient(List<DepositOnlyAcc> depositOnlyAcc, List<WithDrawableAcc> withdrawableAccounts){
        this.depositOnlyAcc = depositOnlyAcc;
        this.withdrawableAccounts = withdrawableAccounts;
    }
    public void processTransactions(){
        for(WithDrawableAcc acc: withdrawableAccounts){
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for(DepositOnlyAcc acc: depositOnlyAcc){
            acc.deposit(5000);
        }
    }
}
public class LSP {
    public static void main(String[] args) {
        List<WithDrawableAcc> withDrawableAccs = new ArrayList<>();
        withDrawableAccs.add(new SavingsAccount());
        withDrawableAccs.add(new CurrentAccount());

        List<DepositOnlyAcc> depositOnlyAccs = new ArrayList<>();
        depositOnlyAccs.add(new FixedDepositAcc());

        BankClient client1 = new BankClient(depositOnlyAccs, withDrawableAccs);
        client1.processTransactions();

    }
}
