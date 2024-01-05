import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String word = input.nextLine();

    int leftToCenter;
    int rightToCenter;

    int paliLength = 1;

    for (int i = 0; i < word.length(); i++)
    {
      leftToCenter = i;
      rightToCenter = word.length() - 1 - i;

      for (int j = 0; j <= leftToCenter && j <= rightToCenter && word.charAt(i - j) == word.charAt(i + j); j++)
      {
        if (word.charAt(i - j) == word.charAt(i + j))
        {
          if (j * 2 + 1 > paliLength)
          {
            paliLength = j * 2 + 1;
          }
        }
      }

      if (i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1))
      {
        for (int j = 0; j <= leftToCenter && j < rightToCenter && word.charAt(i - j) == word.charAt(i + 1 + j); j++)
        {
          if (word.charAt(i - j) == word.charAt(i + 1 + j))
          {
            if (j * 2 + 2 > paliLength)
            {
              paliLength = j * 2 + 2;
            }
          }
        }
      }
    }

    System.out.println(paliLength);
  }
}