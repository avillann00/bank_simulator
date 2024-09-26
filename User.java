// put this in the bank package
package bank;

// user class 
public class User{
  // attributes for the user class
  private String first_name;
  private String last_name;
  private String username;
  private String password;
  private String bank;
  private int account_id;
  private int user_id;
  private boolean logged_in;

  // account class within the user
  private Account account;

  // constructor method
  public User(String given_first_name, String given_last_name, String given_username, String given_password, String given_bank){
    this.first_name = given_first_name;
    this.last_name = given_last_name;
    this.username = given_username;
    this.password = given_password;
    this.bank = given_bank;
    this.user_id = (int)(Math.random() * 10000);
    this.logged_in = true;

    this.account = new Account(this.user_id);

    this.account_id = this.account.get_account_id();
  }

  // login method
  public boolean login(String given_username, String given_password){
    if(this.username == given_username && this.password == given_password){
      logged_in = true;
      return true;
    }
    
    return false;
  }

  // logout method
  public void logout(){
    this.logged_in = false;
  }

  // returns the logged in status
  public boolean get_status(){
    return this.logged_in;
  }
  
  // returns the username
  public String get_username(){
    if(this.logged_in == true){
      return this.username;
    }

    return null;
  } 

  // returns the password
  public String get_password(){
    if(this.logged_in == true){
      return this.password;
    }

    return null;
  } 

  // returns the bank
  public String get_bank(){
    if(this.logged_in == true){
      return this.bank;
    }
    return null;
  }

  // returs the account id
  public int get_account_id(){
    if(this.logged_in == true){
      return this.account_id;
    }

    return -1;
  }

  // returns the user id
  public int get_user_id(){
    if(this.logged_in == true){
      return this.user_id;
    }

    return -1;
  }

  // method to change the username
  public boolean change_username(String old_username, String new_username){
    if(this.username.equals(old_username) && this.logged_in == true){
      this.username = new_username;
      return true;
    }

    return false;
  } 

  // method to change the password
  public boolean change_password(String old_password, String new_password){
    if(this.password.equals(old_password) && this.logged_in == true){
      this.password = new_password;
      return true;
    }

    return false;
  }   

  // method to change the bank
  public boolean change_bank(String old_bank, String new_bank){
    if(this.bank.equals(old_bank) && this.logged_in == true){
      this.bank = new_bank;
      return true;
    }

    return false;
  } 

  // withdraw method
  public float withdraw(float ammount){
    return this.account.withdraw(ammount);
  }

  // deposit method
  public float deposit(float ammount){
    return this.account.deposit(ammount);
  }

  // returns the current balance
  public float get_balance(){
    return this.account.get_balance();
  }
}
