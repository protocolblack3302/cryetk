import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class firstconnection {

static Connection conn1=null;
private static final String url1="jdbc:mysql://localhost:3306/demo";


static void createlargeob(Connection conn){


    Scanner in =new Scanner(System.in);

    String query ="CREATE TABLE IF NOT EXISTS person (" +
            "ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "NAME VARCHAR(20) NOT NULL," +
            "EMAIL VARCHAR(60) NOT NULL," +
            "image MEDIUMBLOB NOT NULL)";
    try {
        Statement stmt1=conn.createStatement();
        stmt1.executeUpdate(query);

        PreparedStatement stmt = conn.prepareStatement("select * from person",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet res=stmt.executeQuery();

        Blob b=conn.createBlob();
        String url="";
        byte[] buffer;
        int count=4;
        ByteArrayOutputStream bais=new ByteArrayOutputStream();
int imageno=1;

        while(count!=0){
            OutputStream out=b.setBinaryStream(1);

        res.moveToInsertRow();
        System.out.print("enter the name : ");
        res.updateString(2,in.nextLine());
        System.out.print("enter your email : ");
        res.updateString(3,in.nextLine());

        url=imageno+".png";
        ++imageno;
            BufferedImage img= ImageIO.read(new File(url));
            ImageIO.write(img,"png",bais);
            buffer=bais.toByteArray();
            out.write(buffer);
        res.updateBlob(4,b);
        res.insertRow();
        count--;
            out.close();

        }

        bais.close();

        stmt.close();
    }
    catch (SQLException  | IOException e){
        e.printStackTrace();
    }


}



//
//static void insertrow(Connection conn){
//    String str="INSERT INTO EMPLOYEE(name,age) VALUES (?,?)";
//    try {
//
//        PreparedStatement pstmt=conn.prepareStatement(str);
//        pstmt.setString(1,"chachu");
//        pstmt.setInt(2,55);
//        pstmt.execute();
//pstmt.close();
//        str="select * from employee";
//        pstmt=conn.prepareStatement(str,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//        ResultSet resultSet=pstmt.executeQuery();
//        int scrolltype=resultSet.getType();
//        if(scrolltype==ResultSet.TYPE_SCROLL_INSENSITIVE){
//            resultSet.last();
//            System.out.println("total number of rows "+resultSet.getRow());
//
//            resultSet.beforeFirst(); //set cursor to result set row 0
//           // resultSet.next(); //increment result set cursor by 1
//          // resultSet.afterLast();
//
//            int flag=0; //flag to make sure only one value in inserted that also after row 2
//
//            while(resultSet.next()) {
//                if(flag==0) {
//                    resultSet.absolute(2);
//
//                    //check if cursor is on first row then insert a new row after with follwing values
//resultSet.moveToInsertRow();
//                    resultSet.updateString(2, "dada");
//                    resultSet.updateInt(3, 60);
//                    resultSet.insertRow(); //append changes to database
//                    resultSet.moveToCurrentRow(); //go back to previously pointed cursor before  insertin row
//                    flag=1;
//                }
//            }
//        }
//        else{
//
//            System.out.println("rows not bidirectional");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//
//    }
//}

//
//    static void doQuery(Statement stmt,String command) throws SQLException{
//
//            ResultSet res = stmt.executeQuery(command);
//
//            ResultSetMetaData mtdt=res.getMetaData();
//            int columns=mtdt.getColumnCount();
//            int total_width=0;
//
//            for(int i=1;i<=columns;++i){
//                String label=mtdt.getColumnLabel(i);
//                int width=mtdt.getColumnDisplaySize(i);
//                total_width+=width;
//                System.out.format("%"+"-"+width+"s",label);
//            }
//            System.out.println();
//
//            for(int i=0;i<total_width;++i){ //for creating dashes
//                System.out.print("-");
//            }
//                System.out.println(); //for new line after dashes
//
//            while (res.next()) {  //row loop
//
//            for(int i=1;i<=columns;++i) {  //column loop
//                  String columnlabel = mtdt.getColumnName(i);
//                  int fieldtype = mtdt.getColumnType(i);
//                  int width=mtdt.getColumnDisplaySize(i);
//
//                  String format="%-"+width;
//                  if(fieldtype==Types.VARCHAR){
//                      String name= res.getString(columnlabel); //fetch by column name of the row
//                      System.out.format(format+"s",name);
//
//                  }
//                  else{
//                      int age=res.getInt(i); //fetch by column number of the row
//                      System.out.format(format+"d",age);
//                  }
//
//            }
//            System.out.println();    //for new line between rows ;
//            }
//            if (conn1 != null) {
//                System.out.println("mysql connected");
//            }
//
//    }

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
              //  Statement stmt =conn1.createStatement();
               // doQuery(stmt,"select * from employee");
//            insertrow(conn1);
            createlargeob(conn1);
            conn1.close();
           // stmt.close();


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

    createconnection();


    }
}
