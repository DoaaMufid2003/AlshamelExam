package com.example.alshamelexam.javaQuestion;

import java.util.List;

public class Cart {
    List<Cloth> cloths;

    public Cart(List<Cloth> cloths) {
        this.cloths = cloths;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cloths=" + cloths +
                '}';
    }
    public double totalPriceValue(){
        int total=0;
        for (int i = 0; i < cloths.size(); i++) {
           total +=cloths.get(i).price*cloths.get(i).quantity;

        }
        return total;
    }
    public void addCloth(Cloth cloth){
        cloths.add(cloth);
    }
    public void removeCloth(int id){
        for (int i = 0; i <cloths.size() ; i++) {
           if( cloths.get(i).getId()==id){
               cloths.remove(id);
           }
        }
    }
}
