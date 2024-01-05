import java.util.Scanner;
import java.util.Arrays;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    
    int days = Integer.parseInt(input.nextLine());
    int lastIndex = days - 1;
    String [] sunflowers = new String[days];
    int [][] heights = new int[days][days];
    int rotation = 0;

    for (int i = 0; i < days; i++)
    {
      sunflowers[i] = input.nextLine();
      String [] inputs = sunflowers[i].split(" ");

      for (int j = 0; j < days; j++)
      {
        heights[i][j] = Integer.parseInt(inputs[j]);
      }
    }

    if (heights[0][0] < heights[0][lastIndex] && heights[lastIndex][0] >= heights[0][0] && heights[lastIndex][0] < heights[lastIndex][lastIndex])
    {
      rotation = 0;
    }
    else if (heights[0][0] <= heights[0][lastIndex] && heights[lastIndex][0] < heights[0][0] && heights[lastIndex][lastIndex] > heights[lastIndex][0])
    {
      rotation = 1;
    }
    else if (heights[0][0] > heights[0][lastIndex] && heights[lastIndex][0] > heights[lastIndex][lastIndex] && heights[lastIndex][0] <= heights[0][0])
    {
      rotation = 2;
    }
    else if (heights[0][0] >= heights[0][lastIndex] && heights[lastIndex][0] > heights[0][0] && heights[lastIndex][lastIndex] > heights[0][lastIndex])
    {
      rotation = 3;
    }

    for (int i = 0; i < rotation; i++)
    {
      heights = RotateCWArray(heights, days);
    }
    
    for (int i = 0; i < days; i++)
    {
      for (int j = 0; j < days; j++)
      {
        System.out.print(heights[i][j] + " ");
      }
      System.out.println("");
    }
  }

  private static int [][] RotateCWArray(int [][] arr, int length)
  {
    int [][] temp = new int[length][length];
    int lastIndex = length - 1;

    for (int i = 0; i < length; i++)
    {
      for (int j = 0; j < length; j++)
      {
        temp[i][j] = arr[lastIndex - j][i];
      }
    }

    return temp;
  }
}