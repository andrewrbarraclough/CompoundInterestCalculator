public class CalculatorController {
  private CalculatorModel model;
  private CalculatorView view;

  public void calculate() {
    double initialBalance = view.getInitialBalance();
    double yearlyInterestRate = view.getInterestRate();
    int calculationPeriod = view.getCalculationPeriod();
    double monthlyDeposits = view.getMonthlyDeposits();

    view.drawGraph(model.calculate(initialBalance, yearlyInterestRate, calculationPeriod, monthlyDeposits));
  }

  public void clear() {
    view.clear();
  }

  public CalculatorController(CalculatorModel model, CalculatorView view) {
    this.model = model;
    this.view = view;
    view.addCalcObserver(this::calculate);
    view.addClearObserver(this::clear);
  }
}
