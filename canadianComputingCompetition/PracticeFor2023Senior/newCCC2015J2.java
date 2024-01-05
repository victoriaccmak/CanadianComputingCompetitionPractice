import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String text = input.nextLine();
    int numSmiles = 0;
    int numFrowns = 0;
    
    while (text.contains(":-)"))
    {
      text = text.replaceFirst(":-\\)", "");
      numSmiles++;
    }

    while (text.contains(":-("))
    {
      text = text.replaceFirst(":-\\(", "");
      numFrowns++;
    }

    if (numSmiles > numFrowns)
    {
      System.out.println("happy");
    }
    else if (numFrowns > numSmiles)
    {
      System.out.println("sad");
    }
    else
    {
      if (numSmiles > 0 && numFrowns > 0)
      {
        System.out.println("unsure");
      }
      else
      {
        System.out.println("none");
      }
    }
  }
}