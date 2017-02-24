//Author: Shane Asel

public class ProductPart1 {

    public int itemNumber;
    public String productName;
    public int inStock;
    public double price;

    public ProductPart1(){

        itemNumber = 0;
        productName = "";
        inStock = 0;
        price = 0.0;

    }


    public ProductPart1(int itemNumber, String productName, int inStock, double price){
        this.itemNumber = itemNumber;
        this.productName = productName;
        this.inStock = inStock;
        this.price = price;
    }



    public int getItemNumber() {
        return itemNumber;
    }



    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }



    public String getProductName() {
        return productName;
    }



    public void setProductName(String productName) {
        this.productName = productName;
    }



    public int getInStock() {
        return inStock;
    }



    public void setInStock(int inStock) {
        this.inStock = inStock;
    }



    public double getPrice() {
        return price;
    }



    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString(){  
        String des = itemNumber+". We have "+inStock+" copies of "+productName+ " in stock which are priced at $"+price+" each.";
        return des;
    }

}




class ProductTesterPart1 {

  

public static void main(String args[]){

  

    ProductPart1 product1 = new ProductPart1();

    ProductPart1 product2 = new ProductPart1();

    product1.setItemNumber(1);

    product2.setItemNumber(2);

    product1.setProductName("Avatar");

    product2.setProductName("The Complete Matrix Trilogy");

    product1.setInStock(15);

    product2.setInStock(4);

    product1.setPrice(9.99);

    product2.setPrice(29.99);



    ProductPart1 product3 = new ProductPart1(3,"Nineteen Eighty-Four",2,15.99);

    ProductPart1 product4 = new ProductPart1(4,"Minority Report",10,14.99);

    ProductPart1 product5 = new ProductPart1(5,"Star Wars: The Force Awakens",4,19.99);

    ProductPart1 product6 = new ProductPart1(6,"Gattaca",7,4.99);



    System.out.println(product1.toString());

    System.out.println(product2.toString());

    System.out.println(product3.toString());

    System.out.println(product4.toString());

    System.out.println(product5.toString());

    System.out.println(product6.toString());
}
}

