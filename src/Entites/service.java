/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author MSI
 */
public class service {
    private int IdService;
 private String Typeser;
 private String DescriptionSer;
 private String ImageService ;

    public service(int IdService, String Typeser, String DescriptionSer, String ImageService) {
        this.IdService = IdService;
        this.Typeser = Typeser;
        this.DescriptionSer = DescriptionSer;
        this.ImageService = ImageService;
    }

    public service() {
        
    }

    public service(int IdService, String DescriptionSer, String ImageService) {
        this.IdService = IdService;
        this.DescriptionSer = DescriptionSer;
        this.ImageService = ImageService;
    }

   

    

    

   

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int IdService) {
        this.IdService = IdService;
    }

    public String getTypeser() {
        return Typeser;
    }

    public void setTypeser(String Typeser) {
        this.Typeser = Typeser;
    }

    public String getDescriptionSer() {
        return DescriptionSer;
    }

    public void setDescriptionSer(String DescriptionSer) {
        this.DescriptionSer = DescriptionSer;
    }

    public String getImageService() {
        return ImageService;
    }

    public void setImageService(String ImageService) {
        this.ImageService = ImageService;
    }
     @Override
    public String toString() {
        return "service{" + "IdService=" + IdService + ", Typeser=" + Typeser + ", DescriptionSer=" + DescriptionSer + ", ImageService=" + ImageService + '}';
    }
}
