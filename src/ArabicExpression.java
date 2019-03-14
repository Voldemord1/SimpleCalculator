import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicExpression extends Expression
{
   private void readExpression()
   {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression with 2 arabic numerals");
        this.setExpression(scanner.nextLine());
        //регуляркой ищем "посторонние" символы в выражении, т.е. все, кроме цифр и +, -, /, *
        Pattern p = Pattern.compile("[a-zA-Z!\"#$%&'(),.:;<=>?@\\[\\]^_{|}~]");
        //если находим хоть один ненужный символ - выводим сообщение и позволяем пользователю ввести выражение ещё раз
        while (true)
        {
            Matcher m = p.matcher(getExpression());
            if(m.find())
            {
                System.out.println("Not valid expression, try again");
                this.setExpression(scanner.nextLine());
            }else
                break;
        }
    }

    public void run()
    {
        readExpression();
        try
        {
            String[] arrayOfNumbers = getExpression().trim().split("\\D");

            if(arrayOfNumbers.length > 2){
                throw new Exception();
            }

            setFirstNumber(Integer.parseInt(arrayOfNumbers[0]));
            setSecondNumber(Integer.parseInt(arrayOfNumbers[1]));
            //изначально задумано, что операторов будет больше 1, для этого и массив
            setArrayOfOperators(getExpression().trim().split("\\d+"));

            calculateExpression();
            printResult();

        }catch (Exception e)
        {
            System.out.println("Invalid expression...");
            run();
        }
    }

    private void printResult()
    {
        System.out.println(this.getResult());
    }
}
