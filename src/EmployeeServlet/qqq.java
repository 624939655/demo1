package EmployeeServlet;

public class qqq {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        
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
	    	System.out.println("失败");
	    	flag=false;
	    }
	}

}
