import java.util.Scanner;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node
{
  int row;
  int col;
  int value;
  boolean visited = false;
  List<Node> children = new ArrayList<Node>();

  Node(int row, int col, int value)
  {
    this.row = row;
    this.col = col; 
    this.value = value;
  }
}

class Main 
{
  static int row;
  static int col;

  static Map<Integer, Node> map = new HashMap<Integer, Node>();

  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    row = Integer.parseInt(br.readLine());
    col = Integer.parseInt(br.readLine());

    for (int i = 1; i <= row; i++)
    {
      String in = br.readLine();
      String [] ins = in.split(" ");

      for (int j = 1; j <= col; j++)
      {
        map.put((i - 1) * col + j, new Node(i, j, Integer.parseInt(ins[j - 1])));
      }
    }

    FindPath(map.get(1));

    System.out.println("no");
  }

  private static List<Node> FindChildren(Node node)
  {
    List<Node> childrenNodes = new ArrayList<Node>();

    for (int i = 1; i <= node.value && i <= row; i++)
    {
      if (node.value % i == 0 && node.value / i <= col)
      {
        childrenNodes.add(map.get((i - 1) * col + node.value / i));
      }
    }
    
    return childrenNodes;
  }

  private static void FindPath(Node node)
  {
    if (node.row == row && node.col == col)
    {
      System.out.println("yes");
      System.exit( 0 );
    }
    else
    {
      if (node.visited == false)
      {
        node.visited = true;
        node.children = FindChildren(node);
        node.children.forEach(n -> 
        {
          if (n.visited == false)
          {
            FindPath(n);
          }
        });
      }
    }
  }
}