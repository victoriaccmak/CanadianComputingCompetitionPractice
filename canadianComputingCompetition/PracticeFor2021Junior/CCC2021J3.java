import java.util.Scanner;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    boolean notDone = true;
    ArrayList<String> directions = new ArrayList<String>();
    ArrayList<Integer> steps = new ArrayList<Integer>();
    String previousDir;

    while (notDone == true)
    {
      String in = input.nextLine();

      if (in.equals("99999"))
      {
        notDone = false;
        break;
      }

      int dir = Character.getNumericValue(in.charAt(0)) + Character.getNumericValue(in.charAt(1));

      if (dir % 2 == 1)
      {
        directions.add("left");
      }
      else if (dir == 0)
      {
        directions.add(directions.get(directions.size() - 1));
      }
      else
      {
        directions.add("right");
      }

      steps.add(Integer.parseInt(in.substring(2)));
    }

    for (int i = 0; i < directions.size(); i++)
    {
      System.out.println(directions.get(i) + " " + steps.get(i));
    }
  }
}