import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


		//main console 
        
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6. exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Product name: ");
                    String name = scanner.next();
                    System.out.println("Product price: ");
                    int price = scanner.nextInt();
                    System.out.println("Product description: ");
                    String description = scanner.next();
                    System.out.println("Product quantity: ");
                    int quantity = scanner.nextInt();
                    
                    add(name, price, description, quantity);
                    break;  

				case 2:
				System.out.println("Enter the product name to remove : ");
				String remove_name = scanner.next();
				remove(remove_name);
				break;

				case 3:
				System.out.println("Enter the product unique id to update the description : ");
				int update_id = scanner.nextInt();
				System.out.println("Enter the updated the description : ");
				String update_description = scanner.next();
				update(update_id,update_description);
				break;
				
				case 4:
				System.out.println("Enter the product unique id: ");
				int search_id = scanner.nextInt();
				search(search_id);
				break;

				case 5:
                    printList();
                    break;  
                
                case 6:
                    System.out.println("Exiting...");
                    return; 
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    

	///print all elements in the list
    private static void printList() {
        if (listOfProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        
        for (Product product : listOfProducts) {
            System.out.println("product unique id: " + product.getProductId());
            System.out.println("product name: " + product.getProductName());
            System.out.println("product price: " + product.getProductPrice());
            System.out.println("product description: " + product.getProductDescription());
            System.out.println("product quantity: " + product.getProductQuantity());
			System.out.println("printed");
        }
    }


	//addd a product
    public static void add(String name, int price, String description, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size() + 1);
        listOfProducts.add(product);
    }


	///seaerfc using id
	public static void search(int id){
		for (Product product : listOfProducts) {
			if (product.getProductId() == id) {
				System.out.println("Product name : " + product.getProductName() + "product Id: " + product.getProductId());
			}
		}
	}
	

	//remove the element
	public static void remove(String productName){
		for(int i=0; i< listOfProducts.size(); i++){
			Product currentProductName = listOfProducts.get(i);
			if(currentProductName.getProductName().toLowerCase().equals(productName.toLowerCase())){
				listOfProducts.remove(i);
			}
		}
	}


	//update the product quanity
	public static void update(int id, String updatedDescription){
		for (Product product : listOfProducts) {
			if(product.getProductId()== id){
				product.setProductDescription(updatedDescription);
			}
		}
	}
}
