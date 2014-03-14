/**
 * Created by Admin on 14.03.14.
 */
public class Div implements Operation {
    public MatrixObject calculate(MatrixObject m1,MatrixObject m2){
        MatrixObject res = new MatrixObject(m1.columns, m1.lines);
        Sum sm = new Sum();
        res = sm.calculate(m1,m2.sMultiplication(-1));
        return res;
    }

    public Vector vCalculate(Vector v1, Vector v2) {
        Vector res = new Vector(v1.lines);
        Div sm = new Div();
        res = mToV(calculate(v1,v2));
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
