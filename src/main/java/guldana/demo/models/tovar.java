package guldana.demo.models;


import javax.persistence.*;

@Entity
public class tovar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tovar_id;
    private String tovar_name;
    private String tovar_finishtime;
    private int time;
    private magazin magazin;


    public tovar() {
    }
    public tovar(String tovar_name, String tovar_finishtime, int time) {
        this.tovar_name = tovar_name;
        this.tovar_finishtime = tovar_finishtime;
        this.time = time;
    }

    public long getTovar_id_id() {
        return tovar_id;
    }

    public void setTovar_id(long tovar_id) {
        this.tovar_id = tovar_id;
    }

    public String getTovar_name() {
        return tovar_name;
    }

    public void settovar_name(String tovar_name) {
        this.tovar_name = tovar_name;
    }

    public String gettovar_finishtime() {
        return tovar_finishtime;
    }

    public void settovar_finishtime(String tovar_finishtime) {
        this.tovar_finishtime = tovar_finishtime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public magazin getmagazin() {
        return magazin;
    }

    public void setmagazin(magazin magazin) {
        this.magazin = magazin;
    }

    public long gettovar_id() {
        return tovar_id;
    }

    public String gettovar_name() {
        return tovar_name;
    }
}
