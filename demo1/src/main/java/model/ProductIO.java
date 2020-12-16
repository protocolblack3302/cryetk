package model;

import java.io.*;

public class ProductIO {


    public static void addProduct(String path,String productCode) throws IOException {
        Product p=new Product();
        p.setCode("8601");
        p.setPrice(150);
        p.setDescription("bohemia");

        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(path+productCode+".ser"));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(p);
        objectOutputStream.close();
        bufferedOutputStream.close();

    }
    public static Product getProduct(String productCode, String path) throws FileNotFoundException {
        Product p = null;

        try(BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(path+productCode+".ser"));
            ObjectInputStream objectInputStream=new ObjectInputStream(bufferedInputStream);
        ) {
            p= (Product)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }



}
