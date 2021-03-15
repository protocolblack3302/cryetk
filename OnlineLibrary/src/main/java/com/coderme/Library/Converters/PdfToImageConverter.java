package com.coderme.Library.Converters;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@Data
public class PdfToImageConverter {

    private  PDDocument document;
    private  File sourceFile;

    public void OpenDocument(String pdfFilePath)  {
        sourceFile=new File(pdfFilePath);
        try {
            if (sourceFile.exists()) {
                document = PDDocument.load(sourceFile);
            }
        }catch (IOException e){
            log.info("could not open document check directory properties!");
        }
    }

    public boolean closeDocument(){
        try {
            document.close();
            return true;
        }catch (IOException e){
            log.info("could not close the book");
            return false;
        }

    }

    public BufferedImage convertToThumbnail() {


        File destinationFile = new File(sourceFile.getAbsolutePath().replace(".pdf",".png"));
        try {

                document = PDDocument.load(sourceFile);
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                BufferedImage image = pdfRenderer.renderImage(0);
                ImageIO.write(image,"png",destinationFile);
                log.info("writing image .... to " + destinationFile);
                return image;

        }catch (IOException file) {
            log.info("could not convert pdf to thumbnail");
            return null;

        }
    }


        public String getTitle(){

       return document.getDocumentInformation().getTitle()+"/n"+
        document.getDocumentInformation().getSubject();

    }
    public  String getAuthor(){
        return document.getDocumentInformation().getAuthor() + "\n" +
                document.getDocumentInformation().getProducer() + "/n" +
                document.getDocumentInformation().getCreator();
    }
    public  int getPages(){
        return document.getNumberOfPages();
    }

    public float getVersion(){
        return document.getVersion();

    }


}
