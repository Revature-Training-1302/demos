package Tuesday.Encapsulation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        // because the balanace field is private, we can't access it directly like this:
        // System.out.println(account.balance);
        account.setAccountId(1);
        account.setOwner("Rory");
        account.setBalance(100);
        account.setBalance(1000000);
        account.setType("Checking");
        // for this simple example, say a transaction is just a number
        int[] transactions = {50,100,200};
        account.setTransactions(transactions);

        System.out.println(account.toString());
        System.out.println(Arrays.toString(account.getTransactions()));
        System.out.println(account.getAccountId());
    }
}
