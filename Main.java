// put this in the bank package
package bank;

// import the scanner library
import java.util.Scanner;

// main class that handles the user interface
public class Main{
  public static void main(String[] args) {
    System.out.println("Hello, welcome to the banking program. You will be prompted to enter your info to make an account.");

    // initialize scanner
    Scanner scanner = new Scanner(System.in);

    // take all of the users info
    System.out.println("Enter your first name: ");
    String first_name = scanner.nextLine();
    System.out.println(" ");

    System.out.println("Enter your last name: ");
    String last_name = scanner.nextLine();
    System.out.println(" ");

    System.out.println("Enter username: ");
    String username = scanner.nextLine();
    System.out.println(" ");

    String password1;

    // keep asking for password until they match
    while(true){
      System.out.println("Enter password");
      password1 = scanner.nextLine();
      System.out.println(" ");

      System.out.println("Confirm password");
      String password2 = scanner.nextLine();
      System.out.println(" ");

      if(password1.equals(password2)){
        break;
      }
      else{
        System.out.println("Passwords do not match try again");
      }
    }

    System.out.println("Enter your bank: ");
    String bank = scanner.nextLine();
    System.out.println(" ");

    // create the new user object
    User user = new User(first_name, last_name, username, password1, bank);
    
    System.out.println("User successfully created!");

    // promt the user to enter a command until they exit
    while(true){
      System.out.println("Enter number of command...\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Change username\n5. Change password\n6. Exit");
      int command = scanner.nextInt();
      scanner.nextLine();

      if(command == 6){
        break;
      }

      // execute the command based off the users choice
      switch(command){
        case 1: // print the balance
          System.out.println("Your current balance is " + user.get_balance());
          break;
        case 2: // deposit money
          System.out.println("Enter how much you'd like to deposit (x.xx): ");
          float deposit = scanner.nextFloat();
          System.out.println("Your new current balance is " + user.deposit(deposit));
          break;
        case 3: // withdraw money
          System.out.println("Enter how much you'd like to withdraw (x.xx): ");
          float withdraw = scanner.nextFloat();
          System.out.println("Your new current balance is " + user.withdraw(withdraw));
          break;
        case 4: // change the username
          System.out.println("Enter your current username: ");
          String old_username = scanner.nextLine();

          System.out.println("Enter your new username: ");
          String new_username = scanner.nextLine();

          if(user.change_username(old_username, new_username) == true){
            System.out.println("Successfully changed username!");
          }
          else{
            System.out.println("Incorrect current username");
          }
          break;
        case 5: // change the password
          System.out.println("Enter your current password: ");
          String old_password = scanner.nextLine();

          System.out.println("Enter your new password: ");
          String new_password = scanner.nextLine();

          if(user.change_password(old_password, new_password) == true){
            System.out.println("Successfully changed password!");
          }
          else{
            System.out.println("Incorrect current password");
          }         
          break;
      }
      System.out.println(" ");
    }

    scanner.close();

    System.out.println("Thank you have a nice day!");
  }
}
