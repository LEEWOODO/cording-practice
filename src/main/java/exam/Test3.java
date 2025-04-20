package exam;

public class Test3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000, "pass123", 4321);

        System.out.println(account.login("wrong")); // LOGGED_OUT
        System.out.println(account.login("nope"));  // LOGGED_OUT
        System.out.println(account.login("bad"));   // SUSPENDED
        System.out.println(account.withdrawMoney(1000));   // SUSPENDED

        System.out.println(account.unlock(1234));   // SUSPENDED
        System.out.println(account.unlock(4321));   // LOGGED_OUT

        System.out.println(account.login("pass123"));     // LOGGED_IN
        System.out.println(account.withdrawMoney(500));   // LOGGED_IN
        System.out.println(account.withdrawMoney(1000));  // LOGGED_IN (balance stays)
        System.out.println(account.logout());             // LOGGED_OUT
    }
}
