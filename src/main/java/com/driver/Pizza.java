package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;
    private Boolean extraToppings = false;
    private Boolean extraCheese = false;
    private int basePrice;
    private int cheesePrice;
    private int vegToppingPrice;
    private int nonVegToppingPrice;
    private int bagPrice;
    private Boolean bagAdded;
    private Boolean billGenerated;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        this.bill = "";
        this.price = 0;
        this.cheesePrice=80;
        this.vegToppingPrice=70;
        this.nonVegToppingPrice=120;
        this.bagPrice = 20;
        this.bagAdded = false;
        this.billGenerated = false;
        // your code goes here

        if(this.isVeg){
            this.basePrice = 300;
            this.price += basePrice;
        }else{
            this.basePrice = 400;
            this.price += basePrice;
        }
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese() {

        if(Boolean.TRUE.equals(this.extraCheese)) return;

        this.extraCheese = true;
        this.price += this.cheesePrice;
    }

    public void addExtraToppings(){

        if(Boolean.TRUE.equals(this.extraToppings)) return;

        this.extraToppings = true;
        if(this.isVeg){
            // add toppings acc to veg pizza price
            this.price += vegToppingPrice;
        }else{ // add toppings acc to non veg pizza price
            this.price += nonVegToppingPrice;
        }
    }

    public void addTakeaway(){
        // your code goes here
        this.bagAdded = true;
        this.price += this.bagPrice;
    }

    public String getBill(){
        // your code goes here
        if(Boolean.TRUE.equals(this.billGenerated)) return this.bill;
        this.billGenerated = true;
        this.bill += "Base Price Of The Pizza: " + this.basePrice+"\n";
        if(Boolean.TRUE.equals(this.extraCheese)){
            this.bill += "Extra Cheese Added: " + cheesePrice+"\n";
        }
        if(Boolean.TRUE.equals(this.extraToppings)){
            this.bill += "Extra Toppings Added: ";
            if(Boolean.TRUE.equals(this.isVeg)){
                this.bill += this.vegToppingPrice + "\n";
            }else{
                this.bill += this.nonVegToppingPrice + "\n";
            }
        }
        if(Boolean.TRUE.equals(this.bagAdded)){
            this.bill += "Paperbag Added: " + this.bagPrice + "\n";
        }
        this.bill += "Total Price: " + this.price + "\n";
        return this.bill;
    }
}
