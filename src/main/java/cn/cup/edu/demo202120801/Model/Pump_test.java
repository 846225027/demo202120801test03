package cn.cup.edu.demo202120801.Model;

/**
 * @descriptions 泵原厂数据
 * @author：jsp
 * @date: 2021/8/3 8:49
 * @Version: 1.0
 */
public class Pump_test {

    private Integer id;
    private Double version;
    private Double efficiency;
    private Double flow;
    private Double head;
    private Double power;
    private Integer pump_sta_name_id;
    private String pump_type;
    private Double speed = Double.valueOf(2980);

    @Override
    public String toString() {
        return "Pump_test{" +
                "id=" + id +
                ", version=" + version +
                ", efficiency=" + efficiency +
                ", flow=" + flow +
                ", head=" + head +
                ", power=" + power +
                ", pump_sta_name_id=" + pump_sta_name_id +
                ", pump_type='" + pump_type + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getHead() {
        return head;
    }

    public void setHead(Double head) {
        this.head = head;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Integer getPump_sta_name_id() {
        return pump_sta_name_id;
    }

    public void setPump_sta_name_id(Integer pump_sta_name_id) {
        this.pump_sta_name_id = pump_sta_name_id;
    }

    public String getPump_type() {
        return pump_type;
    }

    public void setPump_type(String pump_type) {
        this.pump_type = pump_type;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
