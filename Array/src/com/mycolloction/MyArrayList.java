package com.mycolloction;

/**
 * 模拟实现JDK中的ArrayList
 * @author hsj
 *
 */
public class MyArrayList {
	/**
     * The value is used for object storage.
     */
    private Object[] value;

    /**
     * The size is the number of object used.
     */
    private int size;
    
    public int getSize() {
		return size;
	}
	public MyArrayList() {
    	value = new Object[10];
    }
    public MyArrayList(int size) {
    	if(size < 0) {
    		try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	value = new Object[size];
    }
    
    public void add(Object obj) {
    	value[size] = obj;
    	size++;
    	if(size >= value.length) {
    		//需要扩容
    		int newCapactity = value.length * 2;
    		Object[] newlist = new Object[newCapactity];
    		for(int i=0; i<value.length; i++) {
    			newlist[i] = value[i];
    		}
    		value = newlist;
    	}
    }
    public Object get(int index) {
    	if(index < 0 || index > size-1) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		return value[index];
    }
    public int indexOf(Object obj) {
    	if(obj == null) {
    		return -1;
    	}else {
    		for(int i=0; i<value.length; i++) {
    			if(obj == value[i]) {
    				return i;
    			}
    		}
    		return -1;
    	}
    }
    public Object set(int index, Object obj) {
    	if(index < 0 || index > size-1) {
    		try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	Object old = value[index];
    	value[index] = obj;
    	return old;
    }
    
    public static void main(String[] args) {
    	MyArrayList list = new MyArrayList();
    	list.add("abc");
    	System.out.println(list.get(0));
    	
    	Person p = new Person("hsj");
    	list.add(p);
    	Person p1 = (Person)list.get(1);
    	System.out.println(p1.getName());
    	
    	System.out.println(list.size);
    	list.add("hhh");
    	System.out.println(list.get(2));
    	System.out.println(list.size);
    }
}

class Person {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		this.name = name;
	}
}








