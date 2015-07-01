package com.hbd.retrieval.common.util;
/**
 * ���������в�λ��ö������
 * @author Edward
 *
 */
public enum Location{
	  HEAD("ͷ��", 1), FACE("����", 2), NECK("����", 3), UPPERLIMB("��֫", 4), HAND("�ֲ�", 5), CHEST("�ز�", 6),
	  BELLY("����", 7), WAIST("����", 8), HIP("�β�", 9), GENITALS("��ֳ��", 10), LOWERLIMB("��֫", 11), FOOT("�㲿",12);
	    // ��Ա����  
	    private String name;  
	    private int index;  
	    // ���췽��  
	    private Location(String name, int index) {  
	        this.name = name;  
	        this.index = index;  
	    }  
	    // ��ͨ����  
	    public static String getName(int index) {  
	        for (Location c : Location.values()) {  
	            if (c.getIndex() == index) {  
	                return c.name;  
	            }  
	        }  
	        return null;  
	    }  
	    // get set ����  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public int getIndex() {  
	        return index;  
	    }  
	    public void setIndex(int index) {  
	        this.index = index;  
	    } 
}
