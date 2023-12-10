package model;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a data model for the DB table</p>
 */
public class Client {
    private Integer id;
    private String name;
    private String email;
    private String phoneNr;
    private String address;

    public Client(){

    }

    public Client(Integer id, String name, String email, String phoneNr, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNr = phoneNr;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
