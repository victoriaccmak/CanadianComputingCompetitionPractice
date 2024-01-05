import java.util.ArrayList;
import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numLines = Integer.parseInt(input.nextLine());

    ArrayList<Character>[] symbols = new ArrayList[numLines];
    ArrayList<Integer>[] numSymbols = new ArrayList[numLines];

    for (int i = 0; i < numLines; i++)
    {
      String inputs = input.nextLine();
      symbols[i] = new ArrayList<Character>();
      numSymbols[i] = new ArrayList<Integer>();

      symbols[i].add(inputs.charAt(0));
      numSymbols[i].add(1);

      for (int j = 1; j < inputs.length(); j++)
      {
        if (inputs.charAt(j) != inputs.charAt(j - 1))
        {
          symbols[i].add(inputs.charAt(j));
          numSymbols[i].add(1);
        }
        else
        {
          numSymbols[i].set(numSymbols[i].size() - 1, numSymbols[i].get(numSymbols[i].size() - 1) + 1);
        }
      }
    }

    for (int i = 0; i < numLines; i++)
    {
      for (int j = 0; j < symbols[i].size(); j++)
      {
        System.out.print(numSymbols[i].get(j) + " " + symbols[i].get(j) + " ");
      }
      System.out.println("");
    }
  }
}