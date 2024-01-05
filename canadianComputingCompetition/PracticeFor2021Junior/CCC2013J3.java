import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

class Main 
{
  static int firstDigit;

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String given = input.nextLine();
    int [] digits = new int[5];
    boolean found = false;

    for (int i = 4; i > 4 - given.length(); i--)
    {
      digits[i] = Character.getNumericValue(given.charAt(given.length() - 5 + i));
    }

    digits[4] += 1;
    firstDigit = 5 - given.length();

    if (digits[4] >= 10)
    {
      digits = ShiftDigits(digits);
    }
    
    found = TestDigits(digits);

    outermost:
    while (found == false)
    {
      for (int i = firstDigit; i < 5; i++)
      {
        for (int j = i + 1; j < 5; j++)
        {

          if (digits[j] == digits[i])
          {
            digits[j]++;

            if (digits[j] >= 10)
            {
              digits = ShiftDigits(digits);
            }

            for (int k = j + 1; k < 5; k++)
            {
              digits[k] = 0;
            }

            found = TestDigits(digits);
            if (found == true)
            {
              break outermost;
            }
          }
        }
      }
    }

    for (int i = firstDigit; i < 5; i++)
    {
      System.out.print(digits[i]);
    }
  }

  private static boolean TestDigits(int [] digits)
  {
    HashSet<Integer> takenDgts = new HashSet<Integer>();
    boolean distinct = true;

    for (int i = firstDigit; i < 5; i++)
    {
      if (takenDgts.add(digits[i]) == false)
      {
        distinct = false;
        break;
      }
      else
      {
        takenDgts.add(digits[i]);
      }
    }

    return distinct;
  }

  private static int [] ShiftDigits(int [] digits)
  {
    for (int i = 4; i >= firstDigit; i--)
    {
      if (digits[i] >= 10)
      {
        digits[i - 1]++;
        digits[i] = 0;

        if (digits[firstDigit] >= 10)
        {
          digits[firstDigit] = 0;
          firstDigit--;
          digits[firstDigit] = 1;
        }
      }
    }

    return digits;
  }
}