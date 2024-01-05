import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Node 
{
  int value;
  List<Node> children;

  Node ()
  {
    children = new ArrayList<Node>();
  }

  public void SetValue(int newValue)
  {
    value = newValue;
  }

  public List<Node> GetChildren()
  {
    return children;
  }
}

class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    int numPages = Integer.parseInt(input.nextLine());
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    
    for (int i = 0; i < numPages; i++)
    {
      Node page = new Node();
      page.SetValue(i + 1);
      map.put(i + 1, page);
    }

    for (int i = 0; i < numPages; i++)
    {
      int num = input.nextInt();

      for (int j = 0; j < num; j++)
      {
        int p = input.nextInt();
        map.get(i + 1).children.add(map.get(p));
      }
    }

    Set<Integer> pages = new TreeSet<Integer>();
    GetReachablePages(map.get(1), pages);

    if (pages.size() == numPages)
    {
      System.out.println("Y");
    }
    else
    {
      System.out.println("N");
    }

    List<Node> nodesToCheck = new ArrayList<Node>();
    nodesToCheck.add(map.get(1));
    int pathSize = GetShortestPath(nodesToCheck, 0);
    System.out.println(pathSize);
  }

  private static void GetReachablePages(Node node, Set<Integer> pages)
  {
    if (!pages.contains(node.value))
    {
      pages.add(node.value);
      
      node.GetChildren().forEach(n -> 
      {
        GetReachablePages(n, pages);
      });
    }
  }

  private static int GetShortestPath(List<Node> nodesToCheck, int pathSize)
  {
    pathSize++;

    List<Node> childNodes = new ArrayList<Node>();

    for (Node node : nodesToCheck)
    {
      if (node.GetChildren().size() == 0)
      {
        return pathSize;
      }
      else
      {
        for (int i = 0; i < node.GetChildren().size(); i++)
        {
          childNodes.add(node.GetChildren().get(i));
        }
      }
    }
    return GetShortestPath(childNodes, pathSize);
  }
}