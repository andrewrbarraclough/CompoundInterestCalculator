import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
  public Node calculate(Node previousNode, double yearlyInterestRate, double monthlyDeposits) {
    double initialBalance = previousNode.getBalance();

    BigDecimal bd;
    double interestRate = yearlyInterestRate / 12;

    double simpleCompoundInterest = initialBalance * Math.pow(1 + interestRate, 12);
    double contributionCompoundInterest = monthlyDeposits * ((Math.pow(1 + interestRate, 12) - 1) / interestRate);
    
    bd = new BigDecimal(simpleCompoundInterest + contributionCompoundInterest).setScale(2, RoundingMode.HALF_DOWN);
    double balance = bd.doubleValue();

    double yearDeposits = monthlyDeposits * 12;
    double totalDeposits = previousNode.getTotalDeposits() + yearDeposits;
    bd = new BigDecimal(balance - totalDeposits).setScale(2, RoundingMode.HALF_DOWN);
    double totalInterest = bd.doubleValue();
    bd = new BigDecimal(totalInterest - previousNode.getTotalInterest()).setScale(2, RoundingMode.HALF_DOWN);
    double yearInterest = bd.doubleValue();

    Node newNode = new Node(yearDeposits, yearInterest, totalDeposits, totalInterest, balance);
    return newNode;
  }
}