import java.util.Scanner;
import java.util.HashSet;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numRows = Integer.parseInt(input.nextLine());
    int numCols = Integer.parseInt(input.nextLine());
    int numSwitches = Integer.parseInt(input.nextLine());

    HashSet<Integer> rowSwitches = new HashSet<Integer>();
    HashSet<Integer> colSwitches = new HashSet<Integer>();

    int [] numOccR = new int[numRows];
    int [] numOccC = new int[numCols];

    int gold = 0;
    int switchedRows = 0;

    for (int i = 0; i < numSwitches; i++)
    {
      String in = input.nextLine();
      int num = Integer.parseInt(in.substring(2));

      switch (in.charAt(0))
      {
        case 'R':
          rowSwitches.add(num);
          numOccR[num - 1]++;
          break;
        case 'C':
          colSwitches.add(num);
          numOccC[num - 1]++;
          break;
      }
    }

    for (int i : rowSwitches)
    {
      if (numOccR[i - 1] % 2 == 1)
      {
        gold += numCols;
        switchedRows++;
      }
    }

    int switchedRowsEffect = numRows - switchedRows - switchedRows;

    for (int i : colSwitches)
    {
      if (numOccC[i - 1] % 2 == 1)
      {
        gold += switchedRowsEffect;
      }
    }

    System.out.println(gold);
  }
}