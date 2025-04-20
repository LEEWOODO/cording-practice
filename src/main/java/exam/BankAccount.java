package exam;
/*

🎯 1. 핵심 개념: State 패턴이란?
        객체의 상태에 따라 행동이 달라지는 경우,
        상태별 클래스를 만들어서 행동을 위임하는 디자인 패턴!

         상태 클래스에서 행동을 담당하는 이유?
        BankAccount는 상태를 보유하고 있고

        BankAccountState 구현체들이 행동을 결정함

        즉, 상태 변경 로직은 전부 상태 클래스에 책임을 위임함

        이렇게 하면:

        조건문(if-else) 없는 깔끔한 구조

        새로운 상태 추가 시 유연하게 확장 가능

        코드 가독성 & 유지보수성 UP


생성자 왜 이렇게 작성했나?

상태 객체들은 BankAccount 내부 데이터를 수정해야 하므로, this를 주입해서 상호작용이 가능하게 해야 해.

생성자에서 상태들을 미리 만들어두고 필요 시 전이만 시켜서 재사용하는 구조로 만드는 것이 State 패턴의 핵심.

초기 상태는 일반적으로 로그인 전(LoggedOut)이므로 this.loggedOut으로 설정.


*/


enum StateInfo {
    LOGGED_IN, LOGGED_OUT, SUSPENDED, ERROR
}

interface BankAccountState {
    public StateInfo login(String password);
    public StateInfo logout();
    public StateInfo unlock(int resetCode);
    public StateInfo withdrawMoney(int amount);
}

class BankAccount {
    private BankAccountState loggedIn;
    private BankAccountState loggedOut;
    private BankAccountState suspended;
    private BankAccountState bankAccountState;
    private int cashBalance;
    private String password;
    private int passwordRetries;
    private int resetCode;

    public BankAccount(int cashBalance, String password, int resetCode) {
        // YOUR SOLUTION HERE
        this.cashBalance = cashBalance;
        this.password = password;
        this.resetCode = resetCode;

        // 상태 객체들은 모두 BankAccount 인스턴스를 받아야 하므로 this 전달
        this.loggedIn = new LoggedIn(this);
        this.loggedOut = new LoggedOut(this);
        this.suspended = new Suspended(this);

        // 초기 상태는 반드시 LoggedOut (로그인 전 상태)
        this.bankAccountState = this.loggedOut;
    }
    public void setState(BankAccountState state) {
        this.bankAccountState = state;
    }

    public BankAccountState getState() {
        return this.bankAccountState;
    }

    public BankAccountState getLoggedInState() {
        return this.loggedIn;
    }

    public BankAccountState getLoggedOutState() {
        return this.loggedOut;
    }

    public BankAccountState getSuspendedState() {
        return this.suspended;
    }

    public StateInfo login(String password) {
        return this.bankAccountState.login(password);
    }

    public StateInfo logout() {
        return this.bankAccountState.logout();
    }

    public StateInfo unlock(int resetCode) {
        return this.bankAccountState.unlock(resetCode);
    }

    public StateInfo withdrawMoney(int amount) {
        return this.bankAccountState.withdrawMoney(amount);
    }

    public void setCashBalance(int amount) {
        this.cashBalance = amount;
    }

    public int getCashBalance() {
        return this.cashBalance;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasswordRetries(int passwordRetries) {
        this.passwordRetries = passwordRetries;
    }

    public int getPasswordRetries() {
        return this.passwordRetries;
    }

    public int getResetCode() {
        return this.resetCode;
    }
}

// YOUR SOLUTION HERE
class LoggedIn implements BankAccountState {
    private BankAccount account;

    public LoggedIn(BankAccount account) {
        this.account = account;
    }

    public StateInfo login(String password) {
        // 이미 로그인된 상태이므로 아무 변화 없이 상태 유지
        return StateInfo.LOGGED_IN;
    }

    public StateInfo logout() {
        // 로그아웃 시 LoggedOut 상태로 전이
        account.setState(account.getLoggedOutState());
        return StateInfo.LOGGED_OUT;
    }

    public StateInfo unlock(int resetCode) {
        // 로그인 상태에서는 unlock이 의미 없으므로 무시
        return StateInfo.LOGGED_IN;
    }

    public StateInfo withdrawMoney(int amount) {
        // 출금은 로그인된 상태에서만 가능
        int balance = account.getCashBalance();
        if (amount <= balance) {
            account.setCashBalance(balance - amount);
        }
        return StateInfo.LOGGED_IN;
    }
}

// YOUR SOLUTION HERE
class LoggedOut implements BankAccountState {
    private BankAccount account;

    public LoggedOut(BankAccount account) {
        this.account = account;
    }

    public StateInfo login(String password) {
        if (password.equals(account.getPassword())) {
            // 비밀번호가 맞으면 로그인 성공 → 상태 전이
            account.setPasswordRetries(0);
            account.setState(account.getLoggedInState());
            return StateInfo.LOGGED_IN;
        } else {
            // 비밀번호 틀릴 경우 retry 증가
            int retries = account.getPasswordRetries() + 1;
            account.setPasswordRetries(retries);
            if (retries > 2) {
                // 3회 초과 → 계정 정지
                account.setState(account.getSuspendedState());
                return StateInfo.SUSPENDED;
            }
            return StateInfo.LOGGED_OUT;
        }
    }

    public StateInfo logout() {
        return StateInfo.LOGGED_OUT;
    }

    public StateInfo unlock(int resetCode) {
        return StateInfo.LOGGED_OUT;
    }

    public StateInfo withdrawMoney(int amount) {
        return StateInfo.LOGGED_OUT;
    }
}

// YOUR SOLUTION HERE
class Suspended implements BankAccountState {
    private BankAccount account;

    public Suspended(BankAccount account) {
        this.account = account;
    }

    public StateInfo login(String password) {
        return StateInfo.SUSPENDED;
    }

    public StateInfo logout() {
        return StateInfo.SUSPENDED;
    }

    public StateInfo unlock(int resetCode) {
        if (resetCode == account.getResetCode()) {
            // resetCode가 맞으면 계정 복구 → LoggedOut 상태로 전이
            account.setPasswordRetries(0);
            account.setState(account.getLoggedOutState());
            return StateInfo.LOGGED_OUT;
        } else {
            return StateInfo.SUSPENDED;
        }
    }

    public StateInfo withdrawMoney(int amount) {
        return StateInfo.SUSPENDED;
    }
}

