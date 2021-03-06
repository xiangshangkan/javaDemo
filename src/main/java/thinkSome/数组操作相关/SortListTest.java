package thinkSome.数组操作相关;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName TempTest
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/28 16:54
 * @Version 1.0
 */
public class SortListTest {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User(2),new User(3),new User(1));
        Collections.sort(userList);
        userList.forEach(user -> System.out.println(user.getId()));


        userList.sort((User o1, User o2)->o2.getId() - o1.getId());
        userList.forEach(user -> System.out.println(user.getId()));

        userList.sort(new UserComparator());
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

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getId() - o2.getId();
    }
}
