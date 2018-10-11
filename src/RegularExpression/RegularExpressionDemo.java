package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.CodingErrorAction.REPLACE;

/**  正则表达式
 * @auther: zhouhui
 * @date: 2018/9/26 14:28
 */
public class RegularExpressionDemo {

    public void RegularExpressionDemo1(){
        String region = "SZ李莉大区hj";
        //匹配字母与数字
        String REGEX1 = "^[A-Za-z0-9]+$";
        String REGEX2 = "SZ";
        //匹配26个字母
        String REGEX3 = "[A-Za-z]+";


        //Pattern 是一个正则表达式的编译表示，调用公共静态编译方法返回Patternd对象，该方法接收一个正则表达式作为参数
        Pattern p = Pattern.compile(REGEX3);
        //Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。
        // 你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象
        Matcher m = p.matcher(region);
         String result = m.replaceAll("");
        System.out.println(result + ("李莉大区".equals(result)));
    }
}
