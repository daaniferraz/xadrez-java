package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (true) {
			
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch,captured);
				System.out.println();
				System.out.print("Origem:");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean [][] possibleMovies = chessMatch.possibleMovies(source);
				UI.clearScreen();
				UI.printBoard (chessMatch.getPieces(),possibleMovies);
				

				System.out.println();
				System.out.print("Destino:");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capituredPiece = chessMatch.performChessMove(source, target);
				if(captured != null) {
					captured.add(capituredPiece);
				}
				
			} catch (ChessException e) {
                 System.out.println(e.getMessage());
                 sc.nextLine();
                 
			} catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                
			}
		}
	}
}
