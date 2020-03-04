
public class Homework2 {
    public void run() {
        MatrixReader mr = new MatrixReader();
        SparseMatrix A = mr.read("src/matrixA.txt");
        System.out.print("Matrix A: \n");
        A.print();
        System.out.println();

        SparseMatrix B = mr.read("src/matrixB.txt");
        System.out.print("Matrix B: \n");
        B.print();
        System.out.println();

        SparseMatrix aTrans = A.transpose();
        System.out.print("Matrix A transpose: \n");
        aTrans.print();
        System.out.println();

        SparseMatrix bTrans = B.transpose();
        System.out.print("Matrix B transpose: \n");
        bTrans.print();
        System.out.println();

        SparseMatrix product = A.product(B);

        System.out.println("Product of A and B:");
        product.print();
        System.out.println();
    }
}
