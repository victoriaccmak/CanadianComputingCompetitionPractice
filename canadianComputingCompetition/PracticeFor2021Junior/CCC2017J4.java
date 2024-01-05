import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    
    int timePassed = Integer.parseInt(input.nextLine());

    int remainingMins = 0;
    int numOfSequences = 0;

    if (timePassed > 720)
    {
      numOfSequences = 31 * (timePassed / 720);
      remainingMins = timePassed - ((timePassed / 720) * 720);
    }
    else
    {
      remainingMins = timePassed;
    }

    if (remainingMins >= 671)
    {
      numOfSequences += 31;
    }
    else if (remainingMins >= 591)
    {
      numOfSequences += 30;
    }
    else if (remainingMins >= 532)
    {
      numOfSequences += 29;
    }
    else if (remainingMins >= 520)
    {
      numOfSequences += 28;
    }
    else if (remainingMins >= 473)
    {
      numOfSequences += 27;
    }
    else if (remainingMins >= 461)
    {
      numOfSequences += 26;
    }
    else if (remainingMins >= 414)
    {
      numOfSequences += 25;
    }
    else if (remainingMins >= 402)
    {
      numOfSequences += 24;
    }
    else if (remainingMins >= 390)
    {
      numOfSequences += 23;
    }
    else if (remainingMins >= 355)
    {
      numOfSequences += 22;
    }
    else if (remainingMins >= 343)
    {
      numOfSequences += 21;
    }
    else if (remainingMins >= 331)
    {
      numOfSequences += 20;
    }
    else if (remainingMins >= 296)
    {
      numOfSequences += 19;
    }
    else if (remainingMins >= 284)
    {
      numOfSequences += 18;
    }
    else if (remainingMins >= 272)
    {
      numOfSequences += 17;
    }
    else if (remainingMins >= 260)
    {
      numOfSequences += 16;
    }
    else if (remainingMins >= 237)
    {
      numOfSequences += 15;
    }
    else if (remainingMins >= 225)
    {
      numOfSequences += 14;
    }
    else if (remainingMins >= 213)
    {
      numOfSequences += 13;
    }
    else if (remainingMins >= 201)
    {
      numOfSequences += 12;
    }
    else if (remainingMins >= 178)
    {
      numOfSequences += 11;
    }
    else if (remainingMins >= 166)
    {
      numOfSequences += 10;
    }
    else if (remainingMins >= 154)
    {
      numOfSequences += 9;
    }
    else if (remainingMins >= 142)
    {
      numOfSequences += 8;
    }
    else if (remainingMins >= 130)
    {
      numOfSequences += 7;
    }
    else if (remainingMins >= 119)
    {
      numOfSequences += 6;
    }
    else if (remainingMins >= 107)
    {
      numOfSequences += 5;
    }
    else if (remainingMins >= 95)
    {
      numOfSequences += 4;
    }
    else if (remainingMins >= 83)
    {
      numOfSequences += 3;
    }
    else if (remainingMins >= 71)
    {
      numOfSequences += 2;
    }
    else if (remainingMins >= 34)
    {
      numOfSequences += 1;
    }

    System.out.println(numOfSequences);
  }
}