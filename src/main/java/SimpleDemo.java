import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: Administrator
 * @date: 2018/12/28 09:39
 */
public class SimpleDemo{

    static class OOMObject {

    }

    public static void main(String[] args) throws ParseException, ClassNotFoundException {

        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] chars = str.toCharArray();
        System.out.println(chars[0] == '*');

        ConcurrentHashMap map = new ConcurrentHashMap();
        StringBuilder ssdfd = new StringBuilder();
        Class c = Class.forName("String");
        ClassLoader dfd = null;

    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        return null;
    }


    private boolean bfs(String beginWord,String endWord, Set<String> wordSet,Map<String,Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        //获取单词长度
        int wordLen = beginWord.length();
        //当前层访问过的节点，当前层全部遍历完成以后，再添加到总的visited集合里
        Set<String> nextLevelVisited = new HashSet<>();

        while(!queue.isEmpty()) {
            //获取队列中单词个数
            int currenSize = queue.size();
            for(int i = 0; i < currenSize; i++) {
                //获取队列中下一个单词
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for(int j =0; j < wordLen; j++) {
                    //缓存被替换掉的字母
                    char originChar = charArray[j];
                    for (char k ='a'; k <= 'z'; k++ ) {
                        if (charArray[j] == k) {
                            continue;
                        }
                        //找到单词中与当前字母不同的字母，并替换掉
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.endsWith(endWord)) {
                                    found = true;
                                }
                                nextLevelVisited.add(nextWord);
                                queue.offer(nextWord);

                                //维护 successors 的定义
                                successors.computeIfAbsent(currentWord,a->new HashSet<>());
                                successors.get(currentWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }

            if (found) {
                break;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }

    private void dfs(String beginWord, String endWord,Map<String,Set<String>> successors, Deque<String> path, List<List<String>> res){
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!successors.containsKey(beginWord)){
            return;
        }
        Set<String> successorWords = successors.get(beginWord);
        for (String nextWord : successorWords) {
            path.addLast(nextWord);
            dfs(nextWord,endWord,successors,path,res);
            path.removeLast();
        }
    }
}




