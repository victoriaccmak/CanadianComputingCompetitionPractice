import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int boilingTemp = Integer.parseInt(input.nextLine());

    int kPa = 5 * boilingTemp - 400;
    int level;

    if (kPa > 100)
    {
      level = -1;
    }
    else if (kPa == 100)
    {
      level = 0;
    }
    else
    {
      level = 1;
    }
    
    System.out.println(kPa);
    System.out.println(level);
  }
}