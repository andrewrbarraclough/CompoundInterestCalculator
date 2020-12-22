import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
  public static Node calculate(Node previousNode, double yearlyInterestRate, int years, double monthlyDeposits) {
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

  public static void main(String[] args) {
    Node initialNode = new Node(15000.0, 0.0, 15000.0, 0.0, 15000.0);
    LinkedList<Node> nodeList = new LinkedList<Node>();
    nodeList.add(initialNode);

    Scanner s = new Scanner(System.in);
    System.out.print("Years?\n> ");
    int years = s.nextInt();

    for (int i = 0; i < years; i++) {
      Node newNode = calculate(nodeList.get(i), 0.08, years, 100);
      nodeList.add(newNode);
    }

    for (int i = 1; i < nodeList.size(); i++) {
      System.out.print("Year " + i + " | ");
      nodeList.get(i).printNode();
    }
  }
}
