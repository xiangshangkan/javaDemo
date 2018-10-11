package javazh.langzh;

/**
 * @auther: Administrator
 * @date: 2018/9/25 15:15
 */
public class StringDemo {

    public void StringDemo1(){
        String id = "/0100001/0200003/0200009/";
        String idPath = "/0100001/0200003/0200009/0208144/3300078/0001596/3300200/5502153";
        String namePath = "贺玲J/吴小龙J/";
        System.out.println(namePath.indexOf("周辉"));
        int start = namePath.indexOf("/");
        System.out.println(namePath.indexOf("/"));
        int end = namePath.indexOf("/",namePath.indexOf("/")+1);
        System.out.println(namePath.indexOf("/",namePath.indexOf("/")+1));
        System.out.println(namePath.substring(start+1,end));
        System.out.println(namePath.indexOf("贺玲J/"));
        System.out.println(String.valueOf(133));


    }
}
