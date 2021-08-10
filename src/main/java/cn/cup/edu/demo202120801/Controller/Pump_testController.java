package cn.cup.edu.demo202120801.Controller;

import cn.cup.edu.demo202120801.Model.Nihe;
import cn.cup.edu.demo202120801.Model.Pump_test;
import cn.cup.edu.demo202120801.Model.Vis_convert;
import cn.cup.edu.demo202120801.Service.Pump_testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @descriptions
 * @author：jsp
 * @date: 2021/8/3 9:29
 * @Version: 1.0
 */
@RestController
public class Pump_testController {
    @Autowired
    Pump_testService pump_testService;

    @GetMapping("/pump_testOps")
    public void pump_testOps(){

        List<Pump_test> pump_tests = pump_testService.getAllPump_testByIdAndType(3,"CP003");
        double Q[] = new double[pump_tests.size()];
        double H[] = new double[pump_tests.size()];
        double efficiency[] = new double[pump_tests.size()];
        double power[] = new double[pump_tests.size()];
        double speed = 2980;
        System.out.println("pump_tests.size() = " + pump_tests.size());

        int count = 0;
        for (Pump_test pump_test:pump_tests) {
            Q[count] = pump_test.getFlow();
            H[count] = pump_test.getHead();
            efficiency[count] = pump_test.getEfficiency();
            power[count] = pump_test.getPower();
            System.out.println("pump_test"+count+" = " + pump_test);
            //System.out.println("H["+i+"] = " +H[i]);
            count++;
            speed = pump_test.getSpeed();

        }
        for (int j = 0; j < Q.length; j++) {
            System.out.print("H["+j+"] = " +H[j] +" ");
            System.out.println("Q["+j+"] = " +Q[j]);
            System.out.println("efficiency["+j+"] = " +efficiency[j]);
        }
        int a = 2;
        String nihefangfa = "Duoyuanfangcheng";

        //粘性换算，课本数据测试
        double N = 2980;
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
            System.out.println(Q[i]);
            //System.out.print("H["+i+"] = " + H[i] +" ");
            //System.out.println("efficiency["+i+"] = " + efficiency[i] +" ");
        }


        //比例定律
        double new_speed = 2000;
        for (int i = 0; i < Q.length; i++) {
            Q[i] = Q[i] * new_speed / speed;
            H[i] = H[i] * Math.pow((new_speed / speed),2);
            power[i] = power[i] * Math.pow((new_speed / speed),2);
        }
        System.out.println("----------");
        for (int i = 0; i < Q.length ; i++) {

            System.out.println(H[i]);
           /* System.out.print("Q["+i+"] = " + Q[i] +" ");
            System.out.print("H["+i+"] = " + H[i] +" ");
            System.out.println("power["+i+"] = " + power[i] +" ");*/
        }
        System.out.println("----------");

        Nihe nihe = new Nihe();
        double[] coeff = nihe.nihe(Q, H, a);


    }
}
