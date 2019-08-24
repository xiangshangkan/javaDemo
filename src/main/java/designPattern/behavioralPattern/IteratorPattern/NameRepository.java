package designPattern.behavioralPattern.IteratorPattern;

/**
 * @ClassName NameRepository
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 11:31
 * @Version 1.0
 */
public class NameRepository implements Container{

    public String names[] = {"Robert","Julie","John","Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
