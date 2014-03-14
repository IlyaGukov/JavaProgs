/**
 * Created by Admin on 14.03.14.
 */
public  interface Operation {
     abstract MatrixObject calculate(MatrixObject m1, MatrixObject m2);
     abstract Vector vCalculate(Vector v1, Vector v2);
}
