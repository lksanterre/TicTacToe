import java.util.*;
import java.io.*;
public class TicTacToe 
{

    public static void main(String[] args)
    {
        System.out.println("Welcome to this game of TicTacToe");
        System.out.println("You and another player will play");
        System.out.println("X will play First and then O will follow");
        System.out.println("Player ONE enter your name");

        Scanner p1 = new Scanner(System.in);
        String name1 = p1.nextLine();
        System.out.println("Player TWO enter your name");
        Scanner p2 = new Scanner(System.in);
        String name2 = p2.nextLine();
        Random r = new Random();
        int number = r.nextInt(2);
    
        XOPiece.XO[] arr = XOPiece.XO.values();
        XOPiece player1piece = new XOPiece(arr[0]);
        XOPiece player2piece = new XOPiece(arr[1]);
        Player player1;
        Player player2;
        if (number%2 == 0){
            player1 = new Player(name1, player1piece);
            player2 = new Player(name2 , player2piece);
            System.out.println("Player 1: " + name1 + " Piece: " + player2.getPiece().toString());
        
            System.out.println("Player 2: " + name2 + " Piece: " + player1.getPiece().toString());
        
        }
        else{
            player1 = new Player(name1 , player2piece);
            player2 = new Player(name2 , player1piece);
            System.out.println("Player 1: " + name1 + " Piece: " + player1.getPiece().toString());
        
            System.out.println("Player 2: " + name2 + " Piece: " + player2.getPiece().toString());
        
        }
       
        SquareBoard board = new SquareBoard(3, new XOPiece());
        board.printBoardCoordinates();
        System.out.println(board);
        int row = 0;
        int col = 0;
        Scanner in = new Scanner(System.in);


        boolean gameWon = false;
        while(gameWon != true){
            System.out.print("X Enter a row number (0, 1, or 2): ");
            row = in.nextInt();
            System.out.print("X Enter a column number (0, 1, or 2): ");
            col = in.nextInt();
            if(row < 0 || col < 0 || row > 2 || col > 2) {
                System.out.println("This is not in the board.");}  
            else{
                board.setPiece(player1piece,row,col);
            }
            board.printBoardCoordinates();
            System.out.println(board);
            if(checkWin(board)=player1piece){
                System.out.println(player1piece+"Has won");
                gameWon=true;}
            else if(checkWin(board)=player2piece){
                System.out.println(player2piece+"Has won");
                gameWon=true;
            }
        

            System.out.print("O Enter a row number (0, 1, or 2): ");
            row = in.nextInt();
            System.out.print("O Enter a column number (0, 1, or 2): ");
            col = in.nextInt();
            if(row < 0 || col < 0 || row > 2 || col > 2) {
                System.out.println("This is not in the board.");}
            
            else{
                board.setPiece(player2piece,row,col);
            }
            board.printBoardCoordinates();
            System.out.println(board);
               if(checkWin(board)=player1piece){
                System.out.println(player1piece+"Has won");
                gameWon=true;}
            else if(checkWin(board)=player2piece){
                System.out.println(player2piece+"Has won");
                gameWon=true;
            }
            

        }}
        public static XOPiece checkWin(XOPiece[][] board){
            for(int j = 0; j<3; j++){
                if(board[0][j] == board[1][j] && board[1][j] == board[2][j] ){
                    return board[0][j];}}
            for(int i = 0; i<3; i++){
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2] ){
                    return board[0][i];}}
            for(int k = 0; k<3; k++){
                if(board[0][0] == board[1][1] && board[1][1] == board[2][2] ){
                    return board[0][0];}}
            for(int w = 0; w<3; w++){
                if(board[0][2] == board[1][1] && board[1][1] == board[2][0] ){
                    return board[0][2];}}
        }




  }






    