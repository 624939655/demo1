package EmployeeServlet;

public class qqq {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
        
        boolean flag=true;
	    outer:
        while(flag){
	    	for(int i=0;i<3;i++){
	    		 System.out.println("Hello");
	    		 if(i==3){
	    			 System.out.println("3");
	    			 
	    			 break outer;
	    		 }
	    	}
	    	System.out.println("ʧ��");
	    	flag=false;
	    }
	}

}
