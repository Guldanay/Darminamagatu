package guldana.demo.models;


import javax.persistence.*;
import java.util.Set;

    @Entity
    public class magazin {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String mesto;
        private String rabotniki;
        private String odezhda;
        private Set<tovar> tovar;


        public magazin() {
        }

        public magazin(String firstName, String lastName, String email) {
            this.mesto = mesto;
            this.rabotniki = rabotniki;
            this.odezhda = odezhda;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getmesto() {
            return mesto;
        }

        public void setmesto(String mesto) {
            this.mesto = mesto;
        }

        public String getrabotniki() {
            return rabotniki;
        }

        public void setrabotniki(String rabotniki) {
            this.rabotniki = rabotniki;
        }

        public String getodezhda() {
            return odezhda;
        }

        public void setodezhda(String odezhda) {
            this.odezhda = odezhda;
        }

        @OneToMany(mappedBy = "magazin", cascade = CascadeType.ALL)
        public Set<tovar> getFood() {
            return tovar;
        }

        public void settovar(Set<tovar> tovar) {
            this.tovar = tovar;
        }

        @Override
        public String toString() {
            String result = String.format( "Category[id=%d, firstName='%s', lastName='%a', email='%e']%n", id, mesto, rabotniki, odezhda );
            if (tovar != null) {
                for (tovar tovar : tovar) {
                    result += String.format( "tovar[tovar_id=%d, food_name='%s', food_finishtime='%g',time='%y']%n", tovar.gettovar_id(), tovar.gettovar_name(), tovar.gettovar_finishtime(), tovar.getTime() );
                }
            }

            return result;
        }

        public void save(magazin magazin) {
        }

        public Iterable<magazin> findAll() {
            return null;
        }

        public void deleteById(long idd) {
        }

        public Object findById(long id) {
            return null;
        }
    }


