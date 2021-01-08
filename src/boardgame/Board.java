package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {

		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar tabuleiro: � necessario que haja pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionsExists(row, column)) {

			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionsExists(position)) {

			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsApiece(position)) {

			throw new BoardException("Ja existe 1 pe�a na posi��o: " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionsExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionsExists(Position position) {
		return positionsExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsApiece(Position position) {
		if (!positionsExists(position)) {

			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		return piece(position) != null;
	}

}
