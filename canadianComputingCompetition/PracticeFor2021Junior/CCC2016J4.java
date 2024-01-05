import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String writtenTime = input.nextLine();
    int inTime = Integer.parseInt(writtenTime.substring(0, 2)) * 60 + Integer.parseInt(writtenTime.substring(3));
    int curTime = inTime;
    double distance = 0;
    String outTime;

    for (curTime = inTime; distance < 120; curTime++)
    {
      if ((curTime >= 420 && curTime < 600) || (curTime >= 900 && curTime < 1140))
      {
        distance += 0.5;
      }
      else
      {
        distance++;
      }
    }

    if (curTime >= 1440)
    {
      curTime -= 1440;
    }

    if (curTime / 60 < 10)
    {
      outTime = "0" + Integer.toString(curTime / 60) + ":";
    }
    else
    {
      outTime = Integer.toString(curTime / 60) + ":";
    }

    if (curTime - (curTime / 60) * 60 == 0)
    {
      outTime = outTime + "00";
    }
    else
    {
      outTime = outTime + Integer.toString(curTime - (curTime / 60) * 60);
    }

    System.out.println(outTime);
  }
}