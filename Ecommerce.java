package nithish_221047018;

import java.io.FileWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


class addProduct{
	private int id;
	private String product;
	

	private int numProduct;
	
	addProduct(int id,String p,int nP) {
		this.id = id;
	    this.product = p;
	    this.numProduct = nP;
	}
	
	public String toString(){
		return id+"\t"+product+"\t\t"+numProduct;
	}
	
	public int getId() {
		return id;
	}
	
	public String getProduct() {
		return product;
	}
}

public class Ecommerce{
	
	public static void main(String[] args) {
		
		
		List<addProduct> c = new ArrayList<addProduct>();
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.Add product details");
			System.out.println("2.Upadte product details");
			System.out.println("3.Display product details");
			System.out.print("Enter your choice  : ");
			ch = s.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("Enter Product ID                : ");
				int id = s.nextInt();
				System.out.println("Enter Product Name              : ");
				String name = s1.nextLine();
				System.out.println("Enter number of product : ");
				int numProduct = s.nextInt();
				
				c.add(new addProduct(id,name,numProduct));
				break;
			case 2:
				boolean found = false;
				System.out.println("Enter Product ID to Update: ");
				id = s.nextInt();
				System.out.println("---------------------------");
				ListIterator<addProduct> li = c.listIterator();
				while(li.hasNext()) {
					addProduct p = li.next();
					if(p.getId() == id){
						System.out.println("Enter number of Products: ");
						name = p.getProduct();
						numProduct = s.nextInt();
						li.set(new addProduct(id,name,numProduct));
						found = true;
					}
				}
				
				if(!found) {
					System.out.println("Product Not Found");
				}
				else {
					System.out.println("Record upadted Successfully..!");
				}
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				Iterator<addProduct> i = c.iterator();
				LocalTime t;
				t =java.time.LocalTime.now();
				try {
					FileWriter wr = new FileWriter("data.txt", true);
					wr.write("\n");
					wr.write(t.toString());
					wr.write("\n\n");
					System.out.println("ID\tProduct\t\tQuantity");
					String a = "ID\tProduct\tQuantity";
					wr.write(a);
					wr.write("\n\n");
					while(i.hasNext()) {
						addProduct p = i.next();
						System.out.println(p);
						String st = String.valueOf(p);
						wr.write(st);
						wr.write("\n");
					}
		            wr.close();
				}
				catch(Exception e){
			    		System.out.println("File dosnt exist ");
			    	}
				System.out.println("---------------------------");
				break;
			}
		}while(ch!=0);

	}

}
