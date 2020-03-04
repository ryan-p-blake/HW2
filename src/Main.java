public class Main {

    public static void main(String[] args){

        MatrixReader mr = new MatrixReader();
        SparseMatrix s = mr.read("src/matrixA.txt");
        s.print();
        System.out.println();
        s.transpose().print();

    }
//
//    public static void testSparseMatrixGet() {
//        SparseMatrix sparse = new SparseMatrix(5,5);
//        sparse.insert(2,3, 45);
//        sparse.insert(2, 4, 55);
//
//        sparse.print();
//
//
//    }
//
//    public static void testInsertToEnd() {
//        MatrixRow rowHead = new MatrixRow();
//        ValueNode v1 = new ValueNode(1, 3, 13);
//        ValueNode v2 = new ValueNode(1, 5, 45);
//        ValueNode v3 = new ValueNode(1, 8, 18);
//        ValueNode v4 = new ValueNode(1, 2, 7);
//        ValueNode v5 = new ValueNode(1, 4, 55);
//
//
//        rowHead.insert(v1);
//        rowHead.insert(v3);
//        rowHead.insert(v4);
//        rowHead.insert(v5);
//        rowHead.insert(v2);
//
//        System.out.println(rowHead.get(6));
//
//
//        printValues(rowHead);
//
//        //print values in MatrixRow
//    }
//
//    public static void testInsertBeforeFirst() {
//        MatrixRow rowHead = new MatrixRow();
//        ValueNode v1 = new ValueNode(1, 3, 13);
//        ValueNode v2 = new ValueNode(1, 2, 22);
//
//        rowHead.insert(v1);
//        rowHead.insert(v2);
//        printValues(rowHead);
//
//        //print values in MatrixRow
//    }
//
//    public static void testInsertBeforeLast() {
//        MatrixRow rowHead = new MatrixRow();
//        ValueNode v1 = new ValueNode(1, 3, 13);
//        ValueNode v2 = new ValueNode(1, 8, 18);
//        ValueNode v3 = new ValueNode(1, 5, 45);
//
//        rowHead.insert(v1);
//        rowHead.insert(v2);
//        rowHead.insert(v3);
//        printValues(rowHead);
//        //print values in MatrixRow
//    }
//
//    public static void printValues(MatrixRow inRow){
//        ValueNode first = inRow.getFirst();
//
//        while(first != null){
//            System.out.println(first.getValue());
//            first = first.getNextColumn();
//        }
//        System.out.println("\n\n");
//
//
//    }

}
