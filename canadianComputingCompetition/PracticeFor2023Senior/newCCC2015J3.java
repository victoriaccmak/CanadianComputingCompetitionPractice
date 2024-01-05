import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main 
{
  public static void main(String[] args) throws IOException
  {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);

    String word = br.readLine();
    String newWord = "";
    int distFromA;
    int distFromE;
    int distFromI;
    int distFromO;
    int distFromU;

    for (int i = 0; i < word.length(); i++)
    {
      newWord += word.charAt(i);
      
      if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && 
          word.charAt(i) != 'i' && word.charAt(i) != 'o' && 
          word.charAt(i) != 'u')
      {
        if (word.charAt(i) < 'a')
        {
          newWord += 'a';
        }
        else if (word.charAt(i) < 'e')
        {
          if (word.charAt(i) - 'a' > 'e' - word.charAt(i))
          {
            newWord += 'e';
          }
          else
          {
            newWord += 'a';
          }
        }
        else if (word.charAt(i) < 'i')
        {
          if (word.charAt(i) - 'e' > 'i' - word.charAt(i))
          {
            newWord += 'i';
          }
          else
          {
            newWord += 'e';
          }
        }
        else if (word.charAt(i) < 'o')
        {
          if (word.charAt(i) - 'i' > 'o' - word.charAt(i))
          {
            newWord += 'o';
          }
          else
          {
            newWord += 'i';
          }
        }
        else if (word.charAt(i) < 'u')
        {
          if (word.charAt(i) - 'o' > 'u' - word.charAt(i))
          {
            newWord += 'u';
          }
          else
          {
            newWord += 'o';
          }
        }
        else
        {
          newWord += 'u';
        }

        if (word.charAt(i) != 'z')
        {
          if (word.charAt(i) == 'd' || word.charAt(i) == 'h' ||
              word.charAt(i) == 'n' || word.charAt(i) == 't')
          {
            newWord += (char)(word.charAt(i) + 2);
          }
          else
          {
            newWord += (char)(word.charAt(i) + 1);
          }
        }
        else
        {
          newWord += 'z';
        }
      }
    }

    System.out.println(newWord);
  }
}