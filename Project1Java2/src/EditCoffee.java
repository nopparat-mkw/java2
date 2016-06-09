import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class EditCoffee {
	
	private String id_coffee;
	@SuppressWarnings("unused")
	private String name,price_small, price_medium, price_big;

	private Vector<Coffee> coffeeVector = new Vector<Coffee>();
	
	public EditCoffee() {
		this.AddCoffee();
	}
	
	public void AddCoffee(){
		try {
			Scanner cofIn = new Scanner(new File("coffee.txt"));
			while (cofIn.hasNext()) {
				Coffee coff = new Coffee(cofIn.next(), cofIn.next(), cofIn.next(),
						cofIn.next(), cofIn.next());
				coffeeVector.add(coff);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
		}
	}
	
	
	// ** บรรทึกข้อมูล ลงในไฟล์ coffee.txt **
			public void writeCoffee() {
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter(
							"coffee.txt"));
					for (Coffee coff : coffeeVector) {
						out.write(coff.toString());
						out.newLine();
					}
					out.close();
				} catch (IOException e) {
					System.out.println("Input / Output Stream Error!!");
				}
			}
	
	
	public int findid_coffee(String coff){
		for (int i = 0; i < coffeeVector.size(); i++) {
			if(coff.equalsIgnoreCase(coffeeVector.get(i).getId_coffee())){
				return i;
			}
		}
		return -1;
	}
	
	// ** แก้ไขข้อมูล วิชาในไฟล์ student.txt **
	public boolean editCoffee() {
		int tmp = -1;
		String coff_Name = "";
		String small = "";
		String medium = "";
		String big = "";
		
		ShowCoffee show = new ShowCoffee();
		try {
			show.listCoffee();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-- แก้ไขชนิดกาแฟ --");
		System.out.println("  ");
		Scanner edit_coff = new Scanner(System.in);
		System.out.println("กรุณากรอกหมายเลขของสูตรกาแฟที่ต้องการแก้ไข : ");
		
		id_coffee = edit_coff.nextLine();
	

		tmp = findid_coffee(id_coffee);
		System.out.println("กรุณากรอกชื่อกาแฟ (coffee name) ที่ต้องการเพิ่มรายการ : ");
		coff_Name = edit_coff.nextLine();
		
		
		
		if (!coff_Name.equalsIgnoreCase(" ")) {
			coffeeVector.get(tmp).setName(coff_Name);
		}
		
		System.out.println("กรุณากรอกราคาของสูตรกาแฟ (recipe price) ร้อน : ");
		small = edit_coff.nextLine();
		
		
		if (!small.equalsIgnoreCase(" ")) {
			coffeeVector.get(tmp).setPrice_small(small);
		}
		System.out.println("กรุณากรอกราคาของสูตรกาแฟ (recipe price) เย็นขนาดเล็ก : ");
		medium = edit_coff.nextLine();
		
		
		if (!medium.equalsIgnoreCase(" ")) {
			coffeeVector.get(tmp).setPrice_medium(medium);
		}
		
		
		System.out.println("กรุณากรอกราคาของสูตรกาแฟ (recipe price) เย็นขนาดใหญ่ : ");
		big = edit_coff.nextLine();
		
		
		
		if (!big.equalsIgnoreCase(" ")) {
			coffeeVector.get(tmp).setPrice_big(big);
		}
		writeCoffee();
		System.out.println("การแก้ไขชนิดกาแฟเสร็จสมบูรณ์");
		return false;
	}

}