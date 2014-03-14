/**
 * Created by Admin on 10.03.14.
 */
public class Vector extends MatrixObject {
    public Vector(int ln){
        super(1, ln);
    }
    public double det(){
        return 0;
    }
    public double scMultiplication(Vector v){
        if (v.lines != lines) {
            throw new IllegalArgumentException("incorrect sizes of vectors");

        } else {
            int i = 0;
            double k = 0;
            for (; i < lines; i ++){
                k += content[i][0] * v.content[i][0];
            }
            return k;
        }
    }
    public MatrixObject mMultiplication(){
        throw new IllegalArgumentException("incorrect sizes of vectors");
    }
    public MatrixObject doGauss() {
        throw new IllegalArgumentException("incorrect sizes of vectors");
    }
    public Vector vMultiplication(Vector v){
        if ((lines != 3) || (v.lines != 3))
            throw new IllegalArgumentException("incorrect sizes of vectors");
        Vector res = new Vector(3);
        res.content[0][0] = content[1][0]*v.content[2][0] - content[2][0]*v.content[1][0];
        res.content[1][0] = - content[0][0]*v.content[2][0] + content[2][0]*v.content[0][0];
        res.content[2][0] = content[0][0]*v.content[1][0] - content[1][0]*v.content[0][0];
        return res;
    }
    public Vector mToV(MatrixObject m){
        if (m.columns != 1)
            throw new IllegalArgumentException("incorrect size of matrix");
        Vector res = new Vector(m.lines);
        int i = 0;
        for (; i < lines; i ++){
            res.content[i][0] = m.content[i][0];
        }
        return res;
    }
    public Vector svMultiplication(int k){
        return mToV(sMultiplication(k));
    }
}
