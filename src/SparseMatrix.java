import org.xml.sax.SAXParseException;

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

        MatrixRow r = firstRow;
        MatrixColumn c = firstColumn;

        for(int i = 0; i < row; i++){
            r = r.getNext();
        }
        for(int i = 0; i < column; i++){
            c = c.getNext();
        }


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
            if(current.getNext() != null) {
                current = current.getNext();
            }else{
                return 0;
            }
        }

        return current.get(column);
    }

    public void print() {

        for(int i = 1; i <= this.totalRows; i++){
            for(int j = 1; j <= this.totalColumns; j++){
                int x = this.getValue(i,j);
                if(x < 9){
                    System.out.printf("   %d   ", this.getValue(i,j));
                }else if(x < 100){
                    System.out.printf("   %d  ", this.getValue(i,j));
                }else if(x < 1000){
                    System.out.printf("   %d ", this.getValue(i,j));
                }else if(x < 10000){
                    System.out.printf("   %d", this.getValue(i,j));
                }
            }
            System.out.println();
        }

    }

    public SparseMatrix transpose() {
        SparseMatrix transposedMatrix = new SparseMatrix(totalColumns, totalRows);

            for (int i = 1; i <= this.totalRows; i++) {
                for (int j = 1; j <= this.totalColumns; j++) {
                    transposedMatrix.insert(j, i, getValue(i, j));
                }
            }
        return transposedMatrix;
    }

    public SparseMatrix product(SparseMatrix other){
        SparseMatrix output = new SparseMatrix(this.totalRows, other.totalColumns);

        for(int i = 1; i <= this.totalRows; i++){

            for(int j = 1; j <= other.totalColumns; j++){
                int sum = 0;

                for(int k = 1; k <= this.totalColumns; k++){
                    sum += this.getValue(i, k) * other.getValue(k,j);
                }
                output.insert(i , j, sum);
            }
        }


        return output;
    }


}
