import java.io.Serializable;

/**
 * Created by logan on 2017/4/5.
 */

    public class Person implements Serializable {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
            return name;
        }

    }

