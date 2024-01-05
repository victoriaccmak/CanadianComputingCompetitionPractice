import java.util.Scanner;
import java.util.TreeSet;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numDrops = Integer.parseInt(input.nextLine());
    TreeSet<Integer> x = new TreeSet<Integer>();
    TreeSet<Integer> y = new TreeSet<Integer>();
    int BLX;
    int BLY;
    int TRX;
    int TRY;

    for (int i = 0; i < numDrops; i++)
    {
      String in = input.nextLine();
      x.add(Integer.parseInt(in.substring(0, in.indexOf(","))));
      y.add(Integer.parseInt(in.substring(in.indexOf(",") + 1)));
    }

    BLX = x.first() - 1;
    BLY = y.first() - 1;
    TRX = x.last() + 1;
    TRY = y.last() + 1;

    System.out.println(BLX + "," + BLY);
    System.out.println(TRX + "," + TRY);
  }
}