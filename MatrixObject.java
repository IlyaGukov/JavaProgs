
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Admin on 28.02.14.
 */
public class MatrixObject {
    protected int columns, lines;
    protected double content[][];
    public MatrixObject(int col,int ln){
        columns = col;
        lines = ln;
       content = new double [lines] [columns];
    }
    public double[][] getContent() {
        return content;
    }

    public MatrixObject mMultiplication (MatrixObject m){
        if (columns != m.lines){
            throw new IllegalArgumentException("incorrect sizes of matrix");
        }
        MatrixObject res = new MatrixObject (m.columns, lines);
        int i = 0, j = 0, k = 0;
        for (;j < res.lines; j++){
            for (; i < res.columns; i++){
                res.content[j][i] = 0;
                for (;k < columns; k++){
                        res.content[j][i] += content[j][k] * m.content[k][i];
                }
                k = 0;
            }
            i = 0;
        }
        return res;
    }
    public MatrixObject sMultiplication( int k){
        MatrixObject res = new MatrixObject (columns, lines);
        int i = 0, j = 0;
        for (; j < res.lines; j++){
            for (; i < res.columns; i++){
                res.content[j][i] = k*content[j][i];
            }
            i = 0;
        }
        return res;
    }

    public MatrixObject mT(){
        MatrixObject res = new MatrixObject (lines, columns);
        int i = 0, j = 0;
        for (; j < res.lines; j++){
            for (; i < res.columns; i++){
                res.content[j][i] = content[i][j];
            }
            i = 0;
        }
        return res;

    }
    public void setContent() {
        Scanner s = new Scanner(System.in);
        for (int j = 0; j < lines; j++){
           for (int i = 0; i < columns; i++){
               if(s.hasNextDouble()){
                content[j][i] = s.nextDouble();
               }
           }
       }
    }
    public MatrixObject doGauss(){
        MatrixObject res = new MatrixObject (columns, lines);
        int i = 0, j = 0, k = 0;
         //res.setContent(content);
        copyContent(res);
        double l;
        for (; i < columns; i++){
            for (; j < lines; j++) {
                if ( (j > i) && (content[j][i] != 0)){
                 l = (double)res.content[j][i]/res.content[i][i];
                    for (; k < columns; k ++){
                        res.content[j][k] = res.content[j][k] - l*res.content[i][k];
                    }
                    k = 0;
                }
            }
            j = 0;
        }
        return res;
    }
    public double det(){
        if (lines != columns){
            System.out.println("matrix isn't square");
            return 0;
        }
        double d = 1;
        MatrixObject res = new MatrixObject (columns, lines);
        res = doGauss();
        int i = 0;
        for (; i < columns; i ++){
          d *= res.content[i][i];
        }
        return d;
    }
    protected void copyContent(MatrixObject res){
        for (int j = 0; j < lines; j++){
            for (int i = 0; i < columns; i++){
                res.content[j][i] = content[j][i];
            }
        }
    }
    public int getColumns() {
        return columns;
    }
    public void mPrint(){
        int i = 0, j = 0;
        for (;j < lines; j++ ){
            for (; i < columns; i ++){
                System.out.print(content[j][i] + " ");
            }
            System.out.println();
            i = 0;
        }
    }
    public void setContentFromFile(String str){
        try{
            FileInputStream FileStream = new FileInputStream(str);
            Scanner s = new Scanner (FileStream);
            for (int j = 0; j < lines; j++){
                for (int i = 0; i < columns; i++){
                    if(s.hasNextDouble()){
                        content[j][i] = s.nextDouble();
                    }
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public int getLines() {
        return lines;
    }
}
