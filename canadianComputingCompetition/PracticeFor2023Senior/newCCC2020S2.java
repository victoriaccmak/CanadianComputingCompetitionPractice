import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Node
{
  int value;
  int row;
  int col;
  ArrayList<Node> children = new ArrayList<Node>();
  boolean checked = false;

  Node(int value, int row, int col)
  {
    this.value = value;
    this.row = row;
    this.col = col;
  }

  public void setChecked()
  {
    checked = true;
  }
}

class Main 
{
  static int numRows;
  static int numCols;

  static Node[][] boxes;
  
  public static void main(String[] args) throws Exception
  {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(in);

    numRows = Integer.parseInt(br.readLine());
    numCols = Integer.parseInt(br.readLine());

    boxes = new Node[numRows][numCols];
    String[] info;

    for (int i = 0; i < numRows; i++)
    {
      info = br.readLine().split(" ");

      for (int j = 0; j < numCols; j++)
      {
        boxes[i][j] = new Node(Integer.parseInt(info[j]), i + 1, j + 1);
      }
    }

    FindPath(boxes[0][0]);
    
    System.out.println("no");
  }

  private static void FindPath(Node box)
  {
    if (box.row == numRows && box.col == numCols)
    {
      System.out.println("yes");
      System.exit(0);
    }
    else
    {
      if (!box.checked)
      {
        box.setChecked();
        box.children = AddChildren(box);
        for (Node child : box.children)
        {
          FindPath(child);
        }
      }
    }
  }

  private static ArrayList<Node> AddChildren(Node head)
  {
    ArrayList<Node> children = new ArrayList<Node>();
    
    for (int i = 1; i <= head.value && i <= numRows; i++)
    {
      if (head.value % i == 0 && head.value / i <= numCols)
      {
        children.add(boxes[i - 1][head.value / i - 1]);
      }
    }

    return children;
  }
}