public class Expression {
    private String result;
    private String expression;
    private int firstNumber, secondNumber;
    private String[] arrayOfOperators;

    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {this.expression = expression;}

    public int getFirstNumber() {return firstNumber;}

    public void setFirstNumber(int firstNumber) {this.firstNumber = firstNumber;}

    public int getSecondNumber() {return secondNumber;}

    public void setSecondNumber(int secondNumber) {this.secondNumber = secondNumber;}

    public String[] getArrayOfOperators() {return arrayOfOperators;}

    public void setArrayOfOperators(String[] arrayOfOperators) {this.arrayOfOperators = arrayOfOperators;}

    public void calculateExpression()
    {
        BasicOperations basicOperations = new BasicOperations(getFirstNumber(), getSecondNumber());

        String[] array = getArrayOfOperators();

        LOOP:
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case "+":
                    setResult(String.valueOf(basicOperations.plus()));
                    break LOOP;
                case "-":
                    setResult(String.valueOf(basicOperations.minus()));
                    break LOOP;
                case "*":
                    setResult(String.valueOf(basicOperations.multiply()));
                    break LOOP;
                case "/":
                    setResult(String.valueOf(basicOperations.division()));
                    break LOOP;
            }
        }
    }
}
