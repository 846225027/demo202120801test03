package cn.cup.edu.demo202120801.Model;



/**
 * @descriptions 粘性换算
 * @author：jsp
 * @date: 2021/8/3 15:09
 * @Version: 1.0
 */
public class Vis_convert {
    private double[] Cq;
    private double[] Ch;
    private double[] Cefficiency;

    public void vis_convert(double vis_oil, double vis_w, double[] Q,double[] H, double[] cefficiency,double N){

        double B;
        double Hbep_w = 0,Qbep_w = 0,nbep_w = 0;
        double[] Cq = new double[Q.length];
        double[] Ch = new double[Q.length];
        double[] Cn = new double[Q.length];

        for (int i = 0; i < Q.length; i++) {
            //取得测试最高效率
           nbep_w= Math.max(nbep_w,cefficiency[i]);
        }
        for (int i = 0; i < Q.length; i++) {
            if (nbep_w == cefficiency[i]){
                Hbep_w = H[i];
                Qbep_w = Q[i];
            }
        }

        System.out.println("nbep_w = " + nbep_w);
        System.out.println("Qbep_w = " + Qbep_w);
        System.out.println("Hbep_w = " + Hbep_w);


        B = 16.5 * Math.pow(vis_oil,0.5) * Math.pow(Hbep_w,0.0625)
                / (Math.pow(Qbep_w,0.375) * Math.pow(N,0.25));
        //有几组算几组，

        if(B > 0 && B <= 1){
            for (int i = 0; i < Q.length; i++) {
               Cq[i] = 1;
               Ch[i] = 1;
               Cn[i] = (1 - (1-nbep_w) * Math.pow((vis_oil/vis_w),0.07)) / nbep_w;

            }

        }else if (B > 1 && B < 40){
            for (int i = 0; i < Q.length; i++) {
                Cq[i] = Math.pow(2.71,(-0.165*Math.pow(Math.log(B),3.15)));
                Ch[i] = 1 - (1 - Cq[i]) * Math.pow((Q[i]/Qbep_w),0.75);
                Cn[i] = Math.pow(B,(-0.0547 * Math.pow(B,0.69)));
            }

        }else {
            System.out.println("B值不在0-40之间，无法计算！");
        }
        //对应属性填进去
        this.Cq=Cq;
        this.Ch=Ch;
        this.Cefficiency=Cn;
        //当B不在范围内时应该返回错误信息


    }

    public double[] getCq() {
        return Cq;
    }

    public double[] getCh() {
        return Ch;
    }

    public double[] getCefficiency() {
        return Cefficiency;
    }
}
