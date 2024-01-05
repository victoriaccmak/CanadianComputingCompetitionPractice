import java.util.Scanner;

class Main 
{
  static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String word = input.nextLine();
    String nextConsonant = " ";
    String closestVowel = " ";
    int upperVowelDist = 0;
    int lowerVowelDist = 0;
    String newWord = "";

    for (int i = 0; i < word.length(); i++)
    {
      if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u')
      {
        for (int j = 0; j < ALPHABET.length() && nextConsonant.equals(" "); j++)
        {
          if (word.charAt(i) == ALPHABET.charAt(j))
          {
            if (ALPHABET.charAt(j) == 'z')
            {
              nextConsonant = "z";
            }
            else if (ALPHABET.charAt(j + 1) == 'e' || ALPHABET.charAt(j + 1) == 'i' || ALPHABET.charAt(j + 1) == 'o' || ALPHABET.charAt(j + 1) == 'u')
            {
              nextConsonant = Character.toString(ALPHABET.charAt(j + 2));
            }
            else
            {
              nextConsonant = Character.toString(ALPHABET.charAt(j + 1));
            }

            for (int k = 1; k <= j && upperVowelDist == 0; k++)
            {
              if (ALPHABET.charAt(j - k) == 'a' || ALPHABET.charAt(j - k) == 'e' || ALPHABET.charAt(j - k) == 'i' || ALPHABET.charAt(j - k) == 'o' || ALPHABET.charAt(j - k) == 'u')
              {
                upperVowelDist = k;
              }
              else if (k == j)
              {
                upperVowelDist = 26;
              }
            }

            for (int k = 0; k <= 25 - j && lowerVowelDist == 0; k++)
            {
              if (ALPHABET.charAt(j + k) == 'a' || ALPHABET.charAt(j + k) == 'e' || ALPHABET.charAt(j + k) == 'i' || ALPHABET.charAt(j + k) == 'o' || ALPHABET.charAt(j + k) == 'u')
              {
                lowerVowelDist = k;
              }
              else if (k == 25 - j)
              {
                lowerVowelDist = 26;
              }
            }

            if (lowerVowelDist < upperVowelDist)
            {
              closestVowel = Character.toString(ALPHABET.charAt(j + lowerVowelDist));
            }
            else
            {
              closestVowel = Character.toString(ALPHABET.charAt(j - upperVowelDist));
            }
          }
        }

        newWord = newWord + Character.toString(word.charAt(i)) + closestVowel + nextConsonant;
      }
      else
      {
        newWord = newWord + Character.toString(word.charAt(i));
      }
      
      upperVowelDist = 0;
      lowerVowelDist = 0; 
      closestVowel = " ";
      nextConsonant = " ";
    }

    System.out.println(newWord);
  }
}