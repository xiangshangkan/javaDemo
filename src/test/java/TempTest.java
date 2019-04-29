import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName TempTest
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/28 16:54
 * @Version 1.0
 */
public class TempTest {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User(2),new User(3),new User(1));
        Collections.sort(userList);
        userList.forEach(user -> System.out.println(user.getId()));

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
