package shop.ui.LogicHelper;

import java.io.File;

public class Product
{
    
    private int id;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private File[] selectedFiles;
    
    
    public Product(int id,String name,File[] selectedFiles,String description,double price,int categoryId) {
       setId(id);
       setName(name);
       setDescritption(description); 
       setPrice(price); 
       setCategoryId(categoryId);
       setSelectedFiles(selectedFiles);
    }
    
    
    //getters 
    public int getId(){return id;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    public int getCategoryId(){return categoryId;}
    public File[] getselectedFiles(){return selectedFiles;}
    
    //setters
    public void setId(int id){this.id = id;};
    public void setName(String name){this.name=name;}
    public void setDescritption(String description){this.description=description;}
    public void setPrice(double price){this.price=price;}
    public void setCategoryId(int categoryId){this.categoryId = categoryId;}
    public void setSelectedFiles(File[] selectedFiles){this.selectedFiles= selectedFiles;}
    
    
    @Override 
    public boolean equals(Object obj){

        if(this==obj)return true;
        if(!(obj instanceof Product) || obj == null) return false;

        Product other = (Product)obj;

        return this.getId() == other.getId();

       }



}