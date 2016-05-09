/**
 * @createtime: May 7, 2016 11:08:03 AM
 * @owner: kevin
 */
package kevin.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kevin
 * @version 1.1
 */
public class NestedIterator341 implements Iterator<Integer> {

    private List<Integer> list;
    
    private int inter;
    
    public NestedIterator341(List<NestedInteger> nestedList) {
    	this.list = new ArrayList<Integer>();
        this.initList(nestedList);
        this.inter = 0;
    }
    
    private void initList(List<NestedInteger> nestedList){
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger integer = nestedList.get(i);
            if(integer.isInteger()){
            	list.add(integer.getInteger());
            }else{
            	initList(integer.getList());
            }
        }
    }

    //@Override
    public Integer next() {
        return list.get(this.inter++);
    }

   // @Override
    public boolean hasNext() {
       if(this.inter < this.list.size()){
    	   return true;
       }else{
    	   return false;
       }
    }
}

interface NestedInteger {
	 public boolean isInteger();
	 public Integer getInteger();
	 public List<NestedInteger> getList();
}
