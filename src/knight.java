import java.util.Scanner;

public class knight {


    //Main Program
    public static boolean knightMain(int a, int b, int N) {
        // Creates Board with size N+1 for theoretical max board size.
        int[][] plass = new int[N+1][N+1];

        //Initialize board
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                plass[i][j] = -1;
            }
        }
        //Possible & Allowed steps to take
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        //Picks startin cell
        plass[a][b] = 0;
        //Checking if the board has a possible solution or not
        if (knightTest(plass, a, b, 1, xMove, yMove,N)) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    System.out.print(plass[i][j]+"\t");
                }
                System.out.println("\n");
            }
            return true;
        }
        //No solution found. Exiting
        System.out.println("Solution does not exist");
        return false;
    }
    //Stopping the program if the current step = size of the board
    public static boolean knightTest(int plass[][], int i, int j, int stepCount, int xMove[], int yMove[], int N) {
        if (stepCount == N*N)
            return true;
        //Checking allowed steps, is board done?
        for(int k=0; k<8; k++) {
            int nextI = i+xMove[k];
            int nextJ = j+yMove[k];

            if(isAllowed(nextI, nextJ, plass, N)) {
                plass[nextI][nextJ] = stepCount;
                if (knightTest(plass, nextI, nextJ, stepCount+1, xMove, yMove, N))
                    return true;
                plass[nextI][nextJ] = -1;  //Backtracking
            }
        }

        return false;
    }
    //Function takes in x & y positions and board size and checks if next step is allowed or used
    public static boolean isAllowed(int i, int j, int plass[][], int N) {
        if (i>=1 && i<=N && j>=1 && j<=N) {
            if(plass[i][j]==-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Board size Examples - 5 = 5x5, 7 = 7x7");
        System.out.print("Board size: ");
        int N = scanner.nextInt();

        System.out.print("Start pos X (1 - " + N +"): ");
        int b = scanner.nextInt();

        System.out.print("Start pos Y (1 - " + N +"): ");
        int a = scanner.nextInt();

        knightMain(a,b,N);
    }
}