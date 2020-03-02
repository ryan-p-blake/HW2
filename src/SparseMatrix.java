
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        this.firstRow = new MatrixRow();
        this.firstColumn = new MatrixColumn();

        MatrixRow currentRow = firstRow;

        for(int i = 1; i <= rows; i++){
            currentRow.setNext(new MatrixRow());
            currentRow = currentRow.getNext();
        }

        MatrixColumn currentCol= firstColumn;

        for(int i = 1; i <= columns; i++){
            currentCol.setNext(new MatrixColumn());
            currentCol = currentCol.getNext();
        }



    }

    public void insert(int row, int column, int value) {
        ValueNode newNode = new ValueNode(row, column, value);
        MatrixRow r = getRow(row);
        MatrixColumn c = getColumn(column);

        r.insert(newNode);
        c.insert(newNode);

    }

    public MatrixRow getRow(int position) {
        MatrixRow current = firstRow;

        for(int i = 1; i < position; i++){ // may or may not need <
            current = current.getNext();
        }
        return current;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn current = firstColumn;

        for(int i = 1; i < position; i++){ // may or may not need <=
            current = current.getNext();
        }
        return current;
    }

    public int getValue(int row, int column) {

        MatrixRow current = firstRow;

        for(int i = 0; i < row; i++ ){
            current = current.getNext();
        }



        return 0;
    }

    public void print() {

    }

    public SparseMatrix transpose() {
        return null;
    }

    public SparseMatrix produce(SparseMatrix other) {
        return null;
    }
}
