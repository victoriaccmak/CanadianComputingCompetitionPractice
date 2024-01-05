import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Arrays;

class Main 
{
  static HashMap<Character, Integer> sizes = new HashMap<Character, Integer>();

  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    sizes.put('L', 1);
    sizes.put('M', 2);
    sizes.put('S', 3);

    String in = br.readLine();
    int numBooks = in.length();
    int [] books = new int[numBooks];
    int numSwaps = 0;
    int currentInSet;
    int [] sizeOccs = new int[3];


    for (int i = 0; i < in.length(); i++)
    {
      int size = sizes.get(in.charAt(i));
      books[i] = size;
      sizeOccs[size - 1]++;
    }

    //System.out.println(Arrays.toString(books));
    //System.out.println();

    int [] startOf = new int[3];
    startOf[0] = 0;
    startOf[1] = sizeOccs[0];
    startOf[2] = sizeOccs[0] + sizeOccs[1];
    //System.out.println(startOf[0] + " " + startOf[1] + " " + startOf[2]);

    for (int s = 1; s < 3; s++)
    {
      //System.out.println("S: " + s);
      for (int i = startOf[s - 1]; i < startOf[s - 1] + sizeOccs[s - 1]; i++)
      {
        //System.out.println("i: " + i + " " + books[i]);
        if (books[i] != s)
        {
          int incorrectSize = books[i];
          //System.out.println("Needs fixing" + incorrectSize);
          second:
          for (int j = startOf[incorrectSize - 1] - 1; j < numBooks; j++)
          {
            //System.out.println("j:" + j + " " + books[j]);
            if (books[j] == s)
            {
              int temp = books[i];
              books[i] = books[j];
              books[j] = temp;
              numSwaps++;
              //System.out.println(Arrays.toString(books));
              //System.out.println(numSwaps);
              break second;
            }
          }
        }
      }
    }
    

    System.out.println(numSwaps);
  }
}