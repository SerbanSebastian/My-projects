package Model;

public class Client {
    private Integer id;
    private Integer arrivalTime;
    private Integer simulationTime;

    public Client(){

    }

    public Client(Integer id, Integer arrivalTime, Integer simulationTime){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.simulationTime = simulationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(Integer simulationTime) {
        this.simulationTime = simulationTime;
    }

    @Override
    public String toString(){
        return "(" + id + "," + arrivalTime + "," + simulationTime + ")" ;
    }
}
