package jvm;

/**
 * -Xss128k
 * 设置栈内存容量
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public  static void main(String args[]) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        oom.stackLeak();
    }
}
