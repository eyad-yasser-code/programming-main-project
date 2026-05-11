package shop.ui.LogicHelper;

import java.io.File;

public class Category
 {

private int id;
private String name;
private File selectedFile;


public Category(int id,String name,File selectedFile)
{

    setId(id);
    setName(name);
    setSelectedFile(selectedFile);
   
}


//getters 
public int getId(){return id;}
public String getName(){return name;}
public File getSelectedFile(){return selectedFile;}


//setters
public void setId(int id){this.id = id;};
public void setName(String name){this.name=name;}
public void setSelectedFile(File selectedFile){this.selectedFile=selectedFile;}

 

@Override 
public boolean equals(Object obj)
{

    if(this==obj)return true;
    if(!(obj instanceof Category) || obj == null) return false;

    Category other = (Category)obj;

    return this.getId() == other.getId();

  }


}
