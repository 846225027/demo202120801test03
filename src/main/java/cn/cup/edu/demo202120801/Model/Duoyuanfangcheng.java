package cn.cup.edu.demo202120801.Model;

import org.apache.commons.math3.linear.*;



/**
 * @descriptions 多元方程求解
 * @author：jsp
 * @date: 2021/8/2 10:55
 * @Version: 1.0
 */
public class Duoyuanfangcheng {
    public double[] Duoyuanfangcheng(double[][] A,double[] b) {

        //建立一个矩阵 传入系数
        RealMatrix coefficients =
                new Array2DRowRealMatrix(A, false);
        //创建求解器
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
        //传入等号后面的值
        RealVector constants = new ArrayRealVector(b, false);
        //计算
        RealVector solution = solver.solve(constants);

        //返回解向量
        double[] X = new double[solution.getDimension()];
        for (int i = 0; i < solution.getDimension() ; i++) {
            X[i] = solution.getEntry(i);
        }
        return X;
    }

}
