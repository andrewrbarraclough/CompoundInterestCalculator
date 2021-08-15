public class Node {
  private double yearDeposits;
  private double yearInterest;
  private double totalDeposits;
  private double totalInterest;
  private double balance;

  public Node(double yearDeposits, double yearInterest, double totalDeposits, double totalInterest, double balance) {
    this.yearDeposits = yearDeposits;
    this.yearInterest = yearInterest;
    this.totalDeposits = totalDeposits;
    this.totalInterest = totalInterest;
    this.balance = balance;
  }

  public double getYearDeposits() { return this.yearDeposits; }
  public double getYearInterest() { return this.yearInterest; }
  public double getTotalDeposits() { return this.totalDeposits; }
  public double getTotalInterest() { return this.totalInterest; }
  public double getBalance() { return this.balance; }

  public void setYearDeposits(double yearDeposits) { this.yearDeposits = yearDeposits; }
  public void setYearInterest(double yearInterest) { this.yearInterest = yearInterest; }
  public void setTotalDeposits(double totalDeposits) { this.totalDeposits = totalDeposits; }
  public void setTotalInterest(double totalInterest) { this.totalInterest = totalInterest; }
  public void setBalance(double balance) { this.balance = balance; }

  public void printNode() {
    System.out.println("Year Deposits: " + this.getYearDeposits() + ", Year Interest: " + this.getYearInterest() + ", Total Deposits: " + this.getTotalDeposits() + ", Total Interest: " + this.getTotalInterest() + ", Balance: " + this.getBalance());
  }
}