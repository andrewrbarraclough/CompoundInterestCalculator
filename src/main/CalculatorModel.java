import java.util.LinkedList;

/**
 * The Model component of the MVC Archetecture.
 * @author Andrew Barraclough
 * @version 1.0
 * @since 1.0
 */
public class CalculatorModel {
  private Calculator calculator = new Calculator();
  private LinkedList<Node> list;

  /**
   * Calculates the compound interest of an investment yearly for a set calculation period.
   * @param initialBalance the initial amount of the investment.
   * @param yearlyInterestRate the assumed yearly interest rate.
   * @param calculationPeriod the number of years to run the calculation for.
   * @param monthlyDeposits the amount of money contibuted monthly.
   * @return a list of Nodes, of size calculationPeriod + 1, representing each year within the calcuation period.
   */
  public LinkedList<Node> calculate(double initialBalance, double yearlyInterestRate, int calculationPeriod, double monthlyDeposits) {
    list = new LinkedList<Node>();
    // The first Node (Year 0) in the list contains the initial balances.
    list.add(new Node(initialBalance, 0, initialBalance, 0));

    // Adds a new Node to the list for each year within the calculation period.
    for (int i = 0; i < calculationPeriod; i++) {
      list.add(calculator.calculate(list.get(i), yearlyInterestRate, monthlyDeposits));
    }

    return list;
  }
}