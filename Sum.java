/**
 * Created by Admin on 14.03.14.
 */
public class Sum implements Operation {
    public  MatrixObject calculate(MatrixObject m1, MatrixObject m2){
        if ((m1.columns != m2.columns) && (m1.lines != m2.lines)){
            throw new IllegalArgumentException("incorrect sizes of matrix");
        } else {
            MatrixObject res = new MatrixObject(m1.columns, m2.lines);
            int i = 0, j = 0;
            for (; j < res.lines; j++){
                for (; i < res.columns; i++){

                    res.content[j][i] = m1.content[j][i] + m2.content[j][i];
                }
                i = 0;
            }
            return res;
        }
    }
    public Vector vCalculate(Vector v1, Vector v2){
        Vector res = new Vector(v1.lines);
        res = mToV(calculate(v1, v2));
        return res;
    }
    private Vector mToV(MatrixObject m){
        if (m.columns != 1)
            throw new IllegalArgumentException("incorrect size of matrix");
        Vector res = new Vector(m.lines);
        int i = 0;
        for (; i < m.lines; i ++){
            res.content[i][0] = m.content[i][0];
        }
        return res;
    } 
}
