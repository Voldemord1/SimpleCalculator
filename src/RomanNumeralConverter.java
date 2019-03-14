public class RomanNumeralConverter
{
    private static int numbers[]  = {1, 4, 5, 9, 10, 50, 100, 500, 1000 };
    private static String letters[]  = { "I", "IV", "V", "IX", "X", "L", "C", "D", "M"};

    public static int convertRomanToInt(String romanNumeral) throws NumberFormatException
    {
        int intNumeral = 0;

        for (int i = 0; i < romanNumeral.length(); i++)
        {
            char ch = romanNumeral.charAt(i);

            int number = letterToNumber(ch);

            if ( number == -1)
            {
                throw new NumberFormatException("Invalid format");
            }

            intNumeral += number;
        }

        return intNumeral;
    }

    private static int letterToNumber(char letter)
    {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }
    public static String convertIntegerToRoman(int number)
    {
        String romanValue = "";

        int n = number;

        while ( n > 0 )
        {
            for (int i = 0; i < numbers.length; i++)
            {
                if ( n < numbers[i] )
                {
                    n -= numbers[i-1];
                    romanValue += letters[i-1];
                    break;
                }
            }
        }
        return romanValue;
    }
}