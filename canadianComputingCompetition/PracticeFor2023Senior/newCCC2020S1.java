import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Collections;
import java.util.*;

class Point
{
  int time;
  int pos;

  public Point(int time, int pos)
  {
    this.time = time;
    this.pos = pos;
  }

  public int getTime()
  {
    return time;
  }

  public int getPos()
  {
    return pos;
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    String[] info;
    
    int numObservations = Integer.parseInt(input.nextLine());

    ArrayList<Point> points = new ArrayList<Point>();
    int curTime = 0; 
    int curPos = 0;
    int timeDiff = 0;
    int dist = 0;
    double curSpeed = 0;
    double maxSpeed = 0;
    
    for (int i = 0; i < numObservations; i++)
    {
      info = input.nextLine().split(" ");
      points.add(new Point(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
    }

    Comparator<Point> timeComparer = Comparator.comparing(Point::getTime);
    Collections.sort(points, timeComparer);

    curTime = points.get(0).getTime();
    curPos = points.get(0).getPos();
    
    for (Point p : points)
    {
      timeDiff = p.getTime() - curTime;
      dist = Math.abs(p.getPos() - curPos);
      curSpeed = (double)dist / timeDiff;
      
      if (curSpeed > maxSpeed)
      {
        maxSpeed = curSpeed;
      }

      curTime = p.getTime();
      curPos = p.getPos();
    }

    System.out.println(maxSpeed);
  }
}