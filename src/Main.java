import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int correctPIN = 1234;
        double initialBalance = 2500.75;
        double currentBalance=initialBalance;
        Scanner scanner=new Scanner(System.in);
        int n=0;
        int choice =0;
        int transactions = 0;
        do{
            System.out.println("Please enter 4-digit Pin");
            int inputPin=scanner.nextInt();
            if(inputPin==correctPIN){
            while(choice !=5){
                System.out.println("========= ATM =========\n" +
                        "1. Check Balance\n" +
                        "2. Deposit\n" +
                        "3. Withdraw\n" +
                        "4. Show Account Status\n" +
                        "5. Exit\n" +
                        "=======================");
                System.out.println("Please enter your choice");
                choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("balance is "+ currentBalance);
                        break;

                    case 2 :
                        System.out.println("Please enter the deposit amount");
                        double deposit=scanner.nextDouble();
                        if(deposit>0){
                            currentBalance +=deposit;
                            transactions++;
                            System.out.println("updated balance "+currentBalance);
                        }
                        else{
                            System.out.println("invalid amount");
                        }
                        break;

                    case 3:
                        System.out.println("Please enter the withdraw amount");
                        double withdraw=scanner.nextDouble();
                        if(withdraw==0){
                            System.out.println("Transaction cancelled");
                        }
                        else if(withdraw >0 && withdraw <= currentBalance){
                            currentBalance-=withdraw;
                            transactions++;
                            System.out.println("updated balance "+currentBalance);

                            if (currentBalance == 0) {
                                System.out.println("Warning: Your account is empty.");
                            }
                        }
                        else{
                            System.out.println("Insufficient balance");
                        }
                        break;

                    case 4:
                        if(currentBalance >=5000){
                            System.out.println("VIP Customer");
                        } else if (currentBalance >= 1000 && currentBalance < 5000) {
                            System.out.println("Regular Customer");
                        }
                        else {
                            System.out.println("Low Balance");
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM");
                        System.out.println("Total successful transactions: " + transactions);
                        break;
                    default:
                        System.out.println("Invalid option.");
                        }


                }}

            else{
                n++;
            }
        }while(n < 3 && choice != 5);
        if(n==3){
        System.out.println("Your account has been locked");}
    }
}