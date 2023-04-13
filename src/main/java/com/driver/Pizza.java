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

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        this.bill = "";
        this.price = 0;
        this.cheesePrice=80;
        this.vegToppingPrice=70;
        this.nonVegToppingPrice=120;
        this.bagPrice = 20;
        this.bagAdded = false;
        // your code goes here

        if(this.isVeg){
            this.basePrice = 300;
            this.price += basePrice;
            this.bill += "Base Price Of The Pizza: " + this.basePrice+"\n";
        }else{
            this.basePrice = 400;
            this.price += basePrice;
            this.bill += "Base Price Of The Pizza: " + this.basePrice + "\n";
        }
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese() {

        if(Boolean.TRUE.equals(this.extraCheese)) return;

        this.extraCheese = true;
        if(Boolean.FALSE.equals(extraToppings)){
            // just add cheese -
            this.bill += "Extra Cheese Added: " + cheesePrice+"\n";
        }else{
            // regenerate the bill with first extra cheese and then extra toppings -
            this.bill = "Base Price Of The Pizza: " + this.basePrice+"\n " +
                    "Extra Cheese Added: " + cheesePrice+"\n";
            if(this.isVeg){
                // add toppings acc to veg pizza price
                this.bill += "Extra Toppings Added: " + this.vegToppingPrice + "\n";
            }else{ // add toppings acc to non veg pizza price
                this.bill += "Extra Toppings Added: " + this.nonVegToppingPrice + "\n";
            }
        }
        this.price += this.cheesePrice;
    }

    public void addExtraToppings(){

        if(Boolean.TRUE.equals(this.extraToppings)) return;

        this.extraToppings = true;
        if(this.isVeg){
            // add toppings acc to veg pizza price
            this.bill += "Extra Toppings Added: " + this.vegToppingPrice + "\n";
            this.price += vegToppingPrice;
        }else{ // add toppings acc to non veg pizza price
            this.price += nonVegToppingPrice;
            this.bill += "Extra Toppings Added: " + this.nonVegToppingPrice + "\n";
        }
    }

    public void addTakeaway(){
        // your code goes here
        this.bagAdded = true;

        return;
    }

    public String getBill(){
        // your code goes here
        if(Boolean.TRUE.equals(this.bagAdded)){
            this.price += this.bagPrice;
            this.bill += "Paper bag Added: " + this.bagPrice + "\n";
        }
        this.bill += "Total Price: " + this.price + "\n";
        return this.bill;
    }
}
