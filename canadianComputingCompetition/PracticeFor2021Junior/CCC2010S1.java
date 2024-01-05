import java.util.Scanner;
import java.util.ArrayList;

class Computer
{
  String name;
  int R;
  int S;
  int D;
  int value;

  Computer (String name, String R, String S, String D)
  {
    this.name = name;
    this.R = Integer.parseInt(R);
    this.S = Integer.parseInt(S);
    this.D = Integer.parseInt(D);
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int n = Integer.parseInt(input.nextLine());
    Computer[] comps = new Computer[n];

    ArrayList<Computer> top2 = new ArrayList<Computer>();

    for (int i = 0; i < n; i++)
    {
      String line = input.nextLine();
      String[] arrOfStr = line.split(" ");
      comps[i] = new Computer(arrOfStr[0], arrOfStr[1], arrOfStr[2], arrOfStr[3]);
      
      comps[i].value = 2 * comps[i].R + 3 * comps[i].S + comps[i].D;

      if (i == 0)
      {
        top2.add(comps[0]);
      }
      else if (comps[i].value > top2.get(0).value || (comps[i].value == top2.get(0).value && comps[i].name.compareTo(top2.get(0).name) < 0))
      {
        top2.add(0, comps[i]);
      }
      else if (i == 1 || (comps[i].value == top2.get(0).value && comps[i].name.compareTo(top2.get(0).name) > 0) || comps[i].value > top2.get(1).value || (comps[i].value == top2.get(1).value && comps[1].name.compareTo(top2.get(1).name) > 0))
      {
        top2.add(1, comps[i]);
      }
    }

    for (int i = 0; i < 2 && i < n; i++)
    {
      System.out.println(top2.get(i).name);
    }
  }
}