import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int [] nums = new int[4];
    String status = "answer";

    for (int i = 0; i < nums.length; i++)
    {
      nums[i] = Integer.parseInt(input.nextLine());
    }

    if ((nums[0] == 8 || nums[0] == 9) && (nums[3] == 8 || nums[3] == 9) && nums[2] == nums[1])
    {
      status = "ignore";
    }

    System.out.println(status);
  }
}