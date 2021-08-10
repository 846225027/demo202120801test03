package cn.cup.edu.demo202120801.Model;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class Nihe {
    /**
     *
     * @param Q 流量
     * @param H 扬程
     * @param a 拟合多项式次数
     * @return 返回多项式拟合参数
     */
    public double[] nihe(double[] Q,double[] H,int a){

        WeightedObservedPoints weightedObservedPoints = new WeightedObservedPoints();
        for (int i = 0;i < Q.length;i++){
            weightedObservedPoints.add(Q[i],H[i]);
        }

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(a);
        double[] coeff = fitter.fit(weightedObservedPoints.toList());
        for (double d : coeff){
            System.out.println(d);
        }
        return coeff;
    }

}
