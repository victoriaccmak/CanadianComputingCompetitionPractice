import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String string = input.nextLine();
    String word = input.nextLine();
    boolean found = false;

    for (int i = 0; i < word.length() && found == false; i++)
    {
      String shiftedWord = word.substring(i) + word.substring(0, i);
      
      if (string.contains(shiftedWord))
      {
        found = true;
        break;
      }
    }

    if (found == true)
    {
      System.out.println("yes");
    }
    else
    {
      System.out.println("no");
    }
  }
}