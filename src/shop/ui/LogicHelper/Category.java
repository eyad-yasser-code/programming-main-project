package shop.ui.LogicHelper;




public class Category {
    

private int id;
private String name;
private String imageName;    


public Category(int id,String name,String imageName){

    setId(id);
    setName(name);
    setImageName(imageName);
   
}




//getters 
public int getId(){return id;}
public String getName(){return name;}
public String getImageName(){return imageName;}



//setters
public void setId(int id){this.id = id;};
public void setName(String name){this.name=name;}
public void setImageName(String imageName){this.imageName=imageName;}



 
@Override 
public boolean equals(Object obj){

    if(this==obj)return true;
    if(!(obj instanceof Category) || obj == null) return false;

    Category other = (Category)obj;

    return this.getId() == other.getId();

}




}
