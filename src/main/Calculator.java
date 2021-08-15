import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents the Compound Interest Calculator.
 * @author Andrew Barraclough
 * @version 1.0
 * @since 1.0
 */
public class Calculator {
  /**
   * Calculates the values of the next Node based on the previous Node, yearly interest rate, and the amount of monthly deposits.
   * @param previousNode the previous Node (year).
   * @param yearlyInterestRate the interest rate for the new year.
   * @param monthlyDeposits the amount of money deposited monthly in the new year.
   * @return a new Node (year).
   */
  public Node calculate(Node previousNode, double yearlyInterestRate, double monthlyDeposits) {
    double initialBalance = previousNode.getBalance();

    BigDecimal bd;
    // Calculates the interest monthly.
    double interestRate = yearlyInterestRate / 12;

    // Calculates the simple compound interest of an investment.
    double simpleCompoundInterest = initialBalance * Math.pow(1 + interestRate, 12);
    // Calculates the compound interest of the monthly contributions.
    double contributionCompoundInterest = monthlyDeposits * ((Math.pow(1 + interestRate, 12) - 1) / interestRate);
    
    bd = new BigDecimal(simpleCompoundInterest + contributionCompoundInterest).setScale(2, RoundingMode.HALF_DOWN);
    double balance = bd.doubleValue();

    double yearDeposits = monthlyDeposits * 12;
    double totalDeposits = previousNode.getTotalDeposits() + yearDeposits;
    bd = new BigDecimal(balance - totalDeposits).setScale(2, RoundingMode.HALF_DOWN);
    double totalInterest = bd.doubleValue();
    bd = new BigDecimal(totalInterest - previousNode.getTotalInterest()).setScale(2, RoundingMode.HALF_DOWN);
    double yearInterest = bd.doubleValue();

    return new Node(yearDeposits, yearInterest, totalDeposits, totalInterest);
  }
}