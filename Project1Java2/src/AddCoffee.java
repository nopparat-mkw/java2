import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class AddCoffee {
	public void addCoffee() throws IOException{
		int c1=0,c2=1;
		boolean fn=false, write=false;
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("1.กรุณากรอกชื่อกาแฟ  : ");
		String name = input.next();
		System.out.print("2.กรุณากรอกราคากาแฟร้อน  : ");
		String hot = input.next();
		System.out.print("3.กรุณากรอกราคากาแฟเย็นขนาดเล็ก  : ");
		String small = input.next();
		System.out.print("4.กรุณากรอกราคากาแฟเย็นขนาดใหญ่  : ");
		String large = input.next();
		//เพิ่มส่วนผสม
		System.out.print("5.กรุณากรอกส่วนผสมที่ต้องการเพิ่ม  : ");
		int numrecipe = input.nextInt();
		int num=6;
		
		
		
		try{ 
			FileReader file = new FileReader("coffee.txt");
	         Scanner scanner = new Scanner(file);
			FileWriter writename = new FileWriter("coffee.txt",true);
            BufferedWriter out = new BufferedWriter(writename);
            //Add Recipe
    		FileReader file1 = new FileReader("recipe.txt");
    		Scanner scanner1 = new Scanner(file1);
    		FileWriter writename1 = new FileWriter("recipe.txt", true);
    		BufferedWriter out1 = new BufferedWriter(writename1);
	         
			if (numrecipe > 4) {
				out.close();
				writename.close();
				scanner.close();
				file.close();

				out1.close();
				writename1.close();
				scanner1.close();
				file1.close();
			}
    		
              if(scanner.hasNext()){
            	  while(scanner.hasNext()&&fn==false){
            	String data = scanner.nextLine();
				Scanner input1 = new Scanner(data);
				String Name = input1.next();
				String Hot = input1.next();
				String Small = input1.next();
				String Large = input1.next();
		            c2++;
				if(Name.equals(name)&&Hot.equals(hot)&&Small.equals(small)&&Large.equals(large)){
		        	System.out.println("ข้อมูลซ้ำไม่สามารถลงทะเบียนได้"); 
		        	fn=true;
		        	write=false;
				}else{ 
					write=true;
		         }
		         }
            	  if(write==true){
		         out.write(c2+" "+name);
		         out1.write(c2+" "+name+" ");
		         out.write(" "+hot+" "+small+" "+large);
		         out.newLine();
		         System.out.println("การเพิ่มชนิดกาแฟเสร็จสมบูรณ์");
		         } 
            }else{  
            	c1++;
            	out.write(c1+" "+name);
            	out1.write(c2+" "+name+" ");
		        out.write(" "+hot+" "+small+" "+large);
		        out.newLine();
		        System.out.println("การลงทะเบียนเสร็จสมบูรณ์");
            }
              //--------------------------------------------
              for (int i = 1; i <= numrecipe; i++) {
      			System.out.print(num + ".กรุณากรอกส่วนผสมที่ " + i + "  : ");		
      			if (write == true) {				
      				String mash1 = input.next();
      				out1.write(mash1 + " ");				
      			} 			
      			else {
      				String mash1 = input.next();
      				out1.write(mash1 + " ");
      			}
      			num++;
      		}
      		out1.newLine();
      		System.out.println("การเพิ่มชนิดกาแฟเสร็จสมบูรณ์");
              
              //---------------------------------------------------
			out.close();
			writename.close();
			scanner.close();
			file.close();

			out1.close();
			writename1.close();
			scanner1.close();
			file1.close();
	        
		}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (Exception e){		
		System.err.println("Error: " + e.getMessage());	
		}
	}
}