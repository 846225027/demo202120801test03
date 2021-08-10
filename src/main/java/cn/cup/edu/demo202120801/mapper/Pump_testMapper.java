package cn.cup.edu.demo202120801.mapper;

import cn.cup.edu.demo202120801.Model.Pump_test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Pump_testMapper {
    List<Pump_test> getAllPump_testByIdAndType(Integer pump_sta_name_id, String pump_type);
}
