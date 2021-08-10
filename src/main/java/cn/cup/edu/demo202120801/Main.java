package cn.cup.edu.demo202120801;

import cn.cup.edu.demo202120801.Model.Duoyuanfangcheng;
import cn.cup.edu.demo202120801.Model.Nihe;
import cn.cup.edu.demo202120801.Model.Pump;
import cn.cup.edu.demo202120801.Model.Vis_convert;

/**
 * @descriptions
 * @author：jsp
 * @date: 2021/8/1 16:54
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Pump pump = new Pump();
        Nihe nihe = new Nihe();
        //double[] Q = {3.04,288.81,557.79,757.41,956.57,1154.89,1346.04,1592.67};
        //double[] H = {303.9,314.87,320.61,318.68,304.26,286.82,266.54,237.46};
        double[] Q = {3.89,
        234.54,
        433.53,
        626.28,
        851.31,
        1008.32,
        1159.86,
        1306.44,
        1474.48};
        double[] H = {663.85,
                662.73,
                658.59,
                651.1,
                629.77,
                603.11,
                566.41,
                527.95,
                465.98
        };
        double[] efficiency = {0.69,
                36.47,
                57.86,
                70.92,
                79.86,
                82.75,
                83.05,
                82.29,
                77.48,
        };


        int a = 2;
        double[] coeff = nihe.nihe(Q,H,a);

      /*  for (int i = 0; i < coeff.length; i++){
            System.out.println("coeff["+ i +"] = " + coeff[i]);
        }*/

//-----------------------------------------------------
        //非线性最小二乘
        Duoyuanfangcheng duoyuanfangcheng = new Duoyuanfangcheng();
        /*double[][] A = {{1,1,1},{1,-2,1},{1,2,3}};
        double[] b = {2,-1,-1};*/
        double[][] A = new double[3][3];
        double[] b = new double[3];



        for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < Q.length; l++) {
                        A[k][j] += Math.pow(Q[l],j+k);
                        //System.out.println("A["+k+"]["+j+"] = " + A[k][j]);
                        //只循环一次
                        if(j==0){
                            b[k] += H[l] * Math.pow(Q[l],k);
                            //System.out.println("b["+k+"] = " + b[k]);
                        }

                    }
                }

            }
       /* for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print("A["+i+"]["+j+"] = " + A[i][j]+"  ");
            }
            System.out.println();
        }*/

      /*  for (int i = 0; i < Q.length; i++) {
            Q[i] = Math.pow(Q[i],1.75);
            System.out.println("Q["+i+"] = " + Q[i]);
        }
        nihe.nihe(Q,H,1);*/

        double[] X = duoyuanfangcheng.Duoyuanfangcheng(A,b);
        for (int i = 0; i < X.length; i++) {
            System.out.println("X["+i+"] = " + X[i]);
        }

        //粘性换算测试
        double N = 1475;
        Vis_convert vis_convert = new Vis_convert();
        vis_convert.vis_convert(200,1,Q,H,efficiency,N);
        double Cq[] = vis_convert.getCq();
        double Ch[] = vis_convert.getCh();
        double[] cefficiency = vis_convert.getCefficiency();
        for (int i = 0; i < Q.length; i++) {
            /*System.out.print("Cq["+i+"] = " + Cq[i] +" ");
            System.out.print("Ch["+i+"] = " + Ch[i] +" ");
            System.out.println("cefficiency["+i+"] = " + cefficiency[i] +" ");*/
            Q[i] = Cq[i] * Q[i];
            H[i] = Ch[i] * H[i];
            efficiency[i] = cefficiency[i] * efficiency[i];

            //System.out.println("Q["+i+"] = " + Q[i] +" ");
            System.out.println(efficiency[i]);
            //System.out.print("H["+i+"] = " + H[i] +" ");
            //System.out.println("efficiency["+i+"] = " + efficiency[i] +" ");
        }
        nihe.nihe(Q,efficiency,2);

        //转速改变




    }


    public static void speed_change(Double new_speed,Double[] Q,Double H,Double Power){

    }
}
