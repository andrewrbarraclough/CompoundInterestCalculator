import java.util.LinkedList;

public class CalculatorModel {
  private Calculator calculator = new Calculator();
  private LinkedList<Node> list = new LinkedList<Node>();

  public LinkedList<Node> calculate(double initialBalance, double yearlyInterestRate, int calculationPeriod, double monthlyDeposits) {
    list.add(new Node(initialBalance, 0, initialBalance, 0, initialBalance));

    for (int i = 0; i < calculationPeriod; i++) {
      list.add(calculator.calculate(list.get(i), yearlyInterestRate, monthlyDeposits));
    }

    return list;
  }
}
