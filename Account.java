// put this file in the bank package
package bank;

// account class
public class Account{
  // attributes for the account class
  private int account_id;
  private int user_id;
  private float balance;

  // constructor method
  public Account(int given_user_id){
    this.account_id = (int)(Math.random() * 10000);
    this.user_id = given_user_id;
    this.balance = 0.00f;
  }

  // withdraw method
  public float withdraw(float ammount){
    this.balance -= ammount;
    return this.balance;
  }

  // deposit method
  public float deposit(float ammount){
    this.balance += ammount;
    return this.balance;
  }

  // returns the account id
  public int get_account_id(){
    return this.account_id;
  }

  // returns the user id
  public int get_user_id(){
    return this.user_id;
  }

  // returns the current account balance
  public float get_balance(){
    return this.balance;
  }
}
