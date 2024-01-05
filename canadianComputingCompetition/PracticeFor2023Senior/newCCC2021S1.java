import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numFences = Integer.parseInt(input.nextLine());
    String info = input.nextLine();
    String [] leftHeightsSplit = info.split(" ");

    info = input.nextLine();
    String [] widthsSplit = info.split(" ");

    int [] leftHeights = new int[numFences + 1];
    int [] widths = new int[numFences];

    double area = 0;
    
    for (int i = 0; i < numFences; i++)
    {
      leftHeights[i] = Integer.parseInt(leftHeightsSplit[i]);
      widths[i] = Integer.parseInt(widthsSplit[i]);
    }

    leftHeights[numFences] = Integer.parseInt(leftHeightsSplit[numFences]);

    for (int i = 0; i < numFences; i++)
    {
      area += 0.5 * widths[i] * (leftHeights[i] + leftHeights[i + 1]);
    }

    System.out.println(area);
  }
}