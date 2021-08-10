package cn.cup.edu.demo202120801.Service;


import cn.cup.edu.demo202120801.Model.Pump_test;
import cn.cup.edu.demo202120801.mapper.Pump_testMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @descriptions
 * @author：jsp
 * @date: 2021/8/3 9:26
 * @Version: 1.0
 */
@Service

public class Pump_testService {
    @Autowired
    Pump_testMapper pump_testMapper;

    public List<Pump_test> getAllPump_testByIdAndType(Integer pump_sta_name_id, String pump_type){
        return pump_testMapper.getAllPump_testByIdAndType(pump_sta_name_id,pump_type);
    }
}
