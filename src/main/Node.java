/**
 * Represents a particular year.
 * @author Andrew Barraclough
 * @version 1.1
 * @since 1.0
 */
public class Node {
  private double yearDeposits;
  private double yearInterest;
  private double totalDeposits;
  private double totalInterest;
  private double balance;

  /**
   * Creates a new node (year). 
   * @param yearDeposits the amount of money contributed in this particular year.
   * @param yearInterest the amount of interest earned in this particular year.
   * @param totalDeposits the amount of money contributed to date.
   * @param totalInterest the amount of interest earned to date.
   * @param balance the total amount of money contributed and interest earned to date.
   */
  public Node(double yearDeposits, double yearInterest, double totalDeposits, double totalInterest, double balance) {
    this.yearDeposits = yearDeposits;
    this.yearInterest = yearInterest;
    this.totalDeposits = totalDeposits;
    this.totalInterest = totalInterest;
    this.balance = balance;
  }

  /**
   * Gets the amount of money contributed in this particular year.
   * @return a double representing the money contributed this year.
   */
  public double getYearDeposits() { return this.yearDeposits; }
  /**
   * Gets the amount of interest earned in this particular year.
   * @return a double representing the interest earned this year.
   */
  public double getYearInterest() { return this.yearInterest; }
  /**
   * Gets the amount of money contributed to date.
   * @return a double representing the money contributed to date.
   */
  public double getTotalDeposits() { return this.totalDeposits; }
  /**
   * Gets the amount of interest earned to date.
   * @return a double representing the interest earned to date.
   */
  public double getTotalInterest() { return this.totalInterest; }
  /**
   * Gets the total amount of money contributed and interest earned to date.
   * @return a double representing the total amount of money contributed  and interest earned to date.
   */
  public double getBalance() { return this.balance; }

  /**
   * Sets the amount of money contributed in this particular year.
   * @param yearDeposits a double representing the money contributed this year.
   */
  public void setYearDeposits(double yearDeposits) { this.yearDeposits = yearDeposits; }
  /**
   * Sets the amount of interest earned in this particular year.
   * @param yearInterest a double representing the interest earned this year.
   */
  public void setYearInterest(double yearInterest) { this.yearInterest = yearInterest; }
  /**
   * Sets the amount of money contributed to date.
   * @param totalDeposits a double representing the money contributed to date.
   */
  public void setTotalDeposits(double totalDeposits) { this.totalDeposits = totalDeposits; }
  /**
   * Sets the amount of interest earned to date.
   * @param totalInterest a double representing the interest earned to date.
   */
  public void setTotalInterest(double totalInterest) { this.totalInterest = totalInterest; }
  /**
   * Sets the total amount of money contributed and interest earned to date.
   * @param balance a double representing the money contributed and interest earned to date.
   */
  public void setBalance(double balance) { this.balance = balance; }

  /**
   * Converts the Node's data to a helpful string.
   * @returns a helpful string containing all of the Node's data.
   */
  @Override
  public String toString() {
    return ("Year Deposits: " + this.getYearDeposits() + ", Year Interest: " + this.getYearInterest() + ", Total Deposits: " + this.getTotalDeposits() + ", Total Interest: " + this.getTotalInterest() + ", Balance: " + this.getBalance());
  }
}