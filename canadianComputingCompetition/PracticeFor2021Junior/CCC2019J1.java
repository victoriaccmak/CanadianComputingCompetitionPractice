import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int A3pt = Integer.parseInt(input.nextLine());
    int A2pt = Integer.parseInt(input.nextLine());
    int A1pt = Integer.parseInt(input.nextLine());
    int B3pt = Integer.parseInt(input.nextLine());
    int B2pt = Integer.parseInt(input.nextLine());
    int B1pt = Integer.parseInt(input.nextLine());

    int Apts = 3 * A3pt + 2 * A2pt + A1pt;
    int Bpts = 3 * B3pt + 2 * B2pt + B1pt;

    if (Apts > Bpts)
    {
      System.out.println("A");
    }
    else if (Apts == Bpts)
    {
      System.out.println("T");
    }
    else
    {
      System.out.println("B");
    }
  }
}