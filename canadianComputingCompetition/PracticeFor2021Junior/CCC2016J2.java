import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String [] lines = new String[4];
    int [][] nums = new int[4][4];
    int [] sums = new int[8];

    for (int i = 0; i < lines.length; i++)
    {
      lines[i] = input.nextLine();

      nums[i][0] = Integer.parseInt(lines[i].substring(0, lines[i].indexOf(" ")));
      lines[i] = lines[i].substring(lines[i].indexOf(" ") + 1);
      nums[i][1] = Integer.parseInt(lines[i].substring(0, lines[i].indexOf(" ")));
      lines[i] = lines[i].substring(lines[i].indexOf(" ") + 1);
      nums[i][2] = Integer.parseInt(lines[i].substring(0, lines[i].indexOf(" ")));
      lines[i] = lines[i].substring(lines[i].indexOf(" ") + 1);
      nums[i][3] = Integer.parseInt(lines[i]);

      sums[i] = nums[i][0] + nums[i][1] + nums[i][2] + nums[i][3];
    }

    for (int i = 0; i < lines.length; i++)
    {
      sums[i + 4] = nums[0][i] + nums[1][i] + nums[2][i] + nums[3][i];
    }

    if (sums[0] == sums[1] && sums[0] == sums[2] && sums[0] == sums[3] && sums[0] == sums[4] && sums[0] == sums[5] && sums[0] == sums[6] && sums[0] == sums[7])
    {
      System.out.println("magic");
    }
    else
    {
      System.out.println("not magic");
    }
  }
}