import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanExpression extends Expression
{
    private static RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
    private String numeralToRoman;
    private int romanToInteger;

    private String getNumeralToRoman()
    {
        return numeralToRoman;
    }

    private void setNumeralToRoman(String numeralToRoman)
    {
        this.numeralToRoman = numeralToRoman;
    }

    private int getRomanToInteger()
    {
        return romanToInteger;
    }

    private void setRomanToInteger(int romanToInteger)
    {
        this.romanToInteger = romanToInteger;
    }

    private void readExpression()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression with 2 roman numerals");
        this.setExpression(scanner.nextLine());
        //регуляркой ищем "посторонние" символы в выражении, т.е. все, кроме букв и +, -, /, *
        Pattern p = Pattern.compile("[0-9!\"#$%&'(),.:;<=>?@\\[\\]^_{|}~]");
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

    private void convert(String str)
    {
        try
        {
            char c = str.charAt(0);

            if (Character.isDigit(c))
            {
                int intValue = Integer.parseInt(str);
                setNumeralToRoman(romanNumeralConverter.convertIntegerToRoman(intValue));
            } else
                {
                    setRomanToInteger(romanNumeralConverter.convertRomanToInt(str));
                }
        } catch (NumberFormatException e)
        {
            System.out.println("Problem: Invalid format");
        }
    }

    public void run()
    {
        readExpression();
        try
        {
            String[] arrayOfNumbers = getExpression().trim().split("\\W");

            if(arrayOfNumbers.length > 2){
                throw new Exception();
            }

            convert(arrayOfNumbers[0]);
            setFirstNumber(getRomanToInteger());

            convert(arrayOfNumbers[1]);
            setSecondNumber(getRomanToInteger());
            //изначально задумано, что операторов будет больше 1, для этого и массив
            setArrayOfOperators(getExpression().trim().split("[^+-/*]"));

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
        convert((this.getResult()));
        System.out.println(getNumeralToRoman());
    }
}
