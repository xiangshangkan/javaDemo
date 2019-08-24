import java.util.Comparator;

/**
 * @ClassName TempTest
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/28 16:54
 * @Version 1.0
 */
public class TempTest {

    public static void main(String[] args) {
        String some = "1,2,3,4,5,,,,,";
        System.out.println(some.split(",").length);
    }
}

class User implements Comparable<User> {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public User(Integer id) {
        this.id = id;
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

    @Override
    public int compareTo(User o) {
        return this.id - o.id;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o2.getId() - o1.getId();
    }
}
