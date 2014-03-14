import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by Admin on 28.02.14.
 */
public class Matrix {
    public static void main(String args[]) {
        MatrixObject m = new MatrixObject(2, 2);
        MatrixObject m2 = new MatrixObject(2, 2);
        Vector v1 = new Vector(3);
        Vector v2 = new Vector(3);
        Sum sm = new Sum();
        m.setContent();
        m2.setContent();
        m.mPrint();
        System.out.println();
        m2.mPrint();
        System.out.println();
        m.mMultiplication(m2).mPrint();
        System.out.println();
        m2.doGauss().mPrint();
        System.out.println();
        m2.mT().mPrint();
        System.out.println();
        m2.sMultiplication(7).mPrint();
        System.out.println();
        System.out.println();
        System.out.println(m2.det());
        System.out.println();
        v1.setContent();
        v2.setContent();
        System.out.println();
        System.out.println(v1.scMultiplication(v2));
        System.out.println();
        v1.vMultiplication(v2).mPrint();
        sm.calculate(m,m2).mPrint();
        System.out.println();
        sm.vCalculate(v1,v2).mPrint();

    }
}
