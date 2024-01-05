import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numLines = Integer.parseInt(input.nextLine());
    String message;
    int [] lengths = new int[numLines];
    char [] symbols = new char[numLines];

    for (int i = 0; i < numLines; i++)
    {
      message = input.nextLine();
      lengths[i] = Integer.parseInt(message.substring(0, message.indexOf(" ")));
      symbols[i] = message.charAt(message.indexOf(" ") + 1);
    }

    for (int i = 0; i < numLines; i++)
    {
      for (int j = 0; j < lengths[i]; j++)
      {
        System.out.print(symbols[i]);
      }
      System.out.println("");
    }
  }
}