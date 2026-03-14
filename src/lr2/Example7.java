package lr2;

public class Example7 {
    interface BankAccount {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    static class SavingsAccount implements BankAccount {
        private String owner;
        private double balance;

        public SavingsAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        @Override
        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Сумма депозита должна быть положительной.");
                return;
            }
            balance += amount;
            System.out.printf("Депозит: +%.2f. Баланс: %.2f%n", amount, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Сумма снятия должна быть положительной.");
                return;
            }
            if (amount > balance) {
                System.out.println("Недостаточно средств.");
                return;
            }
            balance -= amount;
            System.out.printf("Снятие: -%.2f. Баланс: %.2f%n", amount, balance);
        }

        @Override
        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "SavingsAccount{owner='" + owner + "', balance=" + balance + "}";
        }
    }

    public static void main(String[] args) {
        BankAccount account = new SavingsAccount("Иван", 1000.0);
        System.out.println(account);

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0);

        System.out.printf("Итоговый баланс: %.2f%n", account.getBalance());
    }
}