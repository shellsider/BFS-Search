import java.util.*;

public class Main
{
    static void input(int[][] a, int  n)
    {
        Scanner ob = new Scanner(System.in);
        int i, j;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                a[i][j] = ob.nextInt();
    }

    static void setNeg(int[] a, int n)
    {
        int i;
        for(i=0;i<n;i++)
            a[i] = -1;
    }

    static int check(int element, int[] visited, int n)
    {
        int i;
        for(i=0;i<n;i++)
            if(visited[i] == element)
                return 1;
        return 0;
    }

    static void findBFS(int[][] a, int[] queue, int[] visited, int n)
    {
        int j, flag, k=0, front = 0, rear = 0;
        queue[front] = 0;
        while(front <= rear)
        {
            flag = check(queue[front], visited, n);
            if(flag == 0){
                visited[k++] = queue[front++];
                for(j=0;j<n;j++){
                    flag = check(j, visited, n);
                    if(a[visited[k-1]][j] == 1 && flag == 0)
                        queue[++rear] = j;
                }
            }
            else{
                queue[front++] = -1;
            }
        }
    }

    static void print(int[] visited, int n)
    {
        int i;
        System.out.println("BFS Elements Are: ");
        for(i=0;i<n;i++)
        {
            char m = (char)(visited[i] + 65);
            System.out.print(m +" ");
        }
    }

    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        int[][] a;
        int[] queue, visited;
        int n;
        System.out.print("Enter Number Of Elements In Graph: ");
        n = ob.nextInt();
        queue = new int[n*n];
        visited = new int[n];
        a = new int[n][n];
        System.out.println("Enter Graph Statistics: ");
        input(a, n);
        setNeg(visited, n);
        setNeg(queue, n*n);
        findBFS(a, queue, visited, n);
        print(visited, n);
    }
}