package moduls;


import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String codeId;
    String name;
    int age;
    @ManyToOne
    @JoinColumn(name = "phongBanId")
    private  PhongBan phongBan;

    public Employee() {
    }

    public Employee(int id, String codeId, String name, int age, PhongBan phongBan) {
        this.id = id;
        this.codeId = codeId;
        this.name = name;
        this.age = age;
        this.phongBan = phongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}

