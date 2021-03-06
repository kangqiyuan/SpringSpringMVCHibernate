package com.hc.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="tb_dept")
public class Dept {
    @Id
    private int deptno;
    @Column(unique = true,length = 25)
    private String dname;
    private String loc;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }

    public Dept() {
    }

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    /////////////////////////////////////////////////////////////
//cascade = CascadeType.ALL 级联操作（级联可以同时更新或者删除几张表的数据，用于多张表中数据的维护!）
//fetch = FetchType.LAZY 支持延迟
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
    private Set<Emp> emps = new HashSet<Emp>();
    public Set<Emp> getEmps() {
        return emps;
    }
    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
