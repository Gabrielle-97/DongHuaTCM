package sg.edu.rp.c346.id19020303.donghuatcm;

public class User {

        //3 properties
        private int id;
        private String name;
        private String password;

        //Constructor


        public User(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        //Getter and setter

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        //toString, for printing contents of a class to an object


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
