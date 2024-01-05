import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String coordinates1 = input.nextLine();
    String coordinates2 = input.nextLine();
    int elecCharge = Integer.parseInt(input.nextLine());

    int x1 = Integer.parseInt(coordinates1.substring(0, coordinates1.indexOf(" ")));
    int y1 = Integer.parseInt(coordinates1.substring(coordinates1.indexOf(" ") + 1));
    int x2 = Integer.parseInt(coordinates2.substring(0, coordinates2.indexOf(" ")));
    int y2 = Integer.parseInt(coordinates2.substring(coordinates2.indexOf(" ") + 1));

    int blocksAway = Math.abs(x2 - x1) + Math.abs(y2 - y1);
    
    if (blocksAway < elecCharge)
    {
      if (elecCharge % 2 == blocksAway % 2)
      {
        System.out.println("Y");
      }
      else
      {
        System.out.println("N");
      }
    }
    else if (blocksAway == elecCharge)
    {
      System.out.println("Y");
    }
    else
    {
      System.out.println("N");
    }
  }
}