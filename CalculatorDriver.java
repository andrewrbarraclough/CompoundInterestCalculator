public class CalculatorDriver {
  public static void main(String[] args) {
    CalculatorView view = CalculatorView.getInstance();
    CalculatorModel model = new CalculatorModel();

    new CalculatorController(model, view);
  }
}
