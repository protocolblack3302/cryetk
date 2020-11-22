

/**
 *
 * @author protocolblack
 */

package wow.models;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.io.Serializable;

public class DBase implements Serializable {
    
    private int id;
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private int age;

   static Connection conn1=null;
      
    public DBase(){
    }
    public DBase(String name,String email,int age){
        
       createconnection();
        this.name=name;
        this.email=email;
        this.age=age;
    }
    
    int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    void setId(int id){
        this.id=id;
    }
    void setName(String name){
        this.name=name;
    }
    void setAge(int age){
        this.age=age;
    }

  
private static final String url1="jdbc:mysql://localhost:3306/demo";

public void add(){
    try{
        addUser();
        conn1.close();

    }
    catch(Exception e){
        e.printStackTrace();
    }
}


public static DBase getUser(String email){
    createconnection();
    String query="SELECT * FROM people WHERE EMAIL="+"'"+email+"'";
    PreparedStatement stmt= null;
    DBase user=null;

    try {
         stmt = conn1.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet res=stmt.executeQuery();

            res.first();
            String name=res.getString("NAME");
            email=  res.getString("EMAIL");
            int age=res.getInt("AGE");

            user=new DBase(name,email,age);


    }
    catch (SQLException e){
        System.err.println("User unreachable");
    }

    return user;

}
private void addUser() throws Exception{
    String query ="CREATE TABLE IF NOT EXISTS people ("  +
            "ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "NAME VARCHAR(20) NOT NULL," +
            "EMAIL VARCHAR(254) NOT NULL ,"+
            "AGE INT NOT NULL)";
    
    
    Statement s=conn1.createStatement();
    s.execute(query);
     

    PreparedStatement stmt = conn1.prepareStatement("select * from people",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet res=stmt.executeQuery();
    
   
   
     res.moveToInsertRow();
     res.updateString(2,this.getName());
     res.updateString(3, this.getEmail());
     res.updateInt(4, this.getAge());
   
     res.insertRow();
     s.close();
     stmt.close();
     
}



    public static void createconnection (){
        try{
       Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        }
        catch (ClassNotFoundException |NoSuchMethodException |InstantiationException | IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }

        Properties prop=new Properties();
        prop.put("user","root");
        prop.put("password","Pirate3301!");

        try{
                conn1=DriverManager.getConnection(url1,prop);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
            
        
    }
    
}
