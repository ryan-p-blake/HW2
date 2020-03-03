import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/*
4
6
1,8 6,60 2,5
2,33 4,36
5,18 4,32 3,31
6,98

 */

public class MatrixReader {

    public SparseMatrix read(String inFile){
        File file = new File(inFile);
        try {
            Scanner s = new Scanner(file);
            int rows = Integer.parseInt(s.nextLine());
            int columns = Integer.parseInt(s.nextLine());

            SparseMatrix output = new SparseMatrix(rows, columns);
            int rowCount = 1;

            while(s.hasNext()){

                String currentLine = s.nextLine();
                String[] tokens = currentLine.split(" ");

                int val = 0;
                int col = 0;

                for(String token : tokens){
                    String[] tokens2 = token.split(",");
                    col = Integer.parseInt(tokens2[0]);
                    val = Integer.parseInt(tokens2[1]);

                    output.insert(rowCount, col, val);

                }
                rowCount++;

            }
            return output;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }
}
