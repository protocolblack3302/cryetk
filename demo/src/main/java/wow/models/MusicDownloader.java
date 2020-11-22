package wow.models;

import java.io.*;
import java.util.ArrayList;

public class MusicDownloader {
    private static ArrayList<String> list;
    static final String path="/Users/protocolblack/IdeaProjects/demo/src/main/webapp/albums";

    public static String getFullpath(String productCode){
        return path+"/"+productCode+"/"+productCode+".ser";
    }

    public static ArrayList<String> createList(String productCode){
        list=new ArrayList<>();
        WriteObjectToFile(list,getFullpath(productCode));
        return  list;
    }

    public static void add(String productCode,String link) throws IOException, ClassNotFoundException {

        list=myReadObject(getFullpath(productCode));
        list.add(link);
        WriteObjectToFile(list,getFullpath(productCode));
    }

public static ArrayList<String> getList(String productCode) throws IOException, ClassNotFoundException {
    list=myReadObject(getFullpath(productCode));
    return list;
}


    public static ArrayList<String> myReadObject(String path) throws IOException, ClassNotFoundException {
        FileInputStream in=new FileInputStream(path);
        BufferedInputStream buff=new BufferedInputStream(in);
        ObjectInputStream ois=new ObjectInputStream(buff);
        ArrayList<String> list=(ArrayList<String>) ois.readObject();
        ois.close();
        return list;
    }

    public static void WriteObjectToFile(Object serObj,String path) {
try{

            FileOutputStream fileOut = new FileOutputStream(path);
    BufferedOutputStream buff=new BufferedOutputStream(fileOut);

    ObjectOutputStream objectOut = new ObjectOutputStream(buff);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       ArrayList<String> list= createList("bohemia");
        ArrayList<String> list2= createList("imranKhan");
        ArrayList<String> list3= createList("honeySingh");

        ArrayList<String> list4= createList("kaka");

        add("honeySingh","http://dns2.vippendu.com/download/320k-dtqjk/Loca.mp3");

    }


}
