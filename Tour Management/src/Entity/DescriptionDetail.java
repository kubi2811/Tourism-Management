/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Service.DescriptionService;
import Service.TourService;

/**
 *
 * @author hieut
 */
public class DescriptionDetail {
    
    private int idDescriptionDetail;
    private int idDescription;
    private String nameDescription;
    private int adults;
    private int childs;
    private double inccurred;
    private double total;
    private TourService tourService = new TourService();
    private DescriptionService descriptionService = new DescriptionService();

    public DescriptionDetail(int idDescription, String nameDescription, int adults, int childs, double inccurred, double total) {
        this.idDescription = idDescription;
        this.nameDescription = nameDescription;
        this.adults = adults;
        this.childs = childs;
        this.inccurred = inccurred;
        this.total = tourService.getCostAdoByName(descriptionService.getNameTourByIdDes(idDescription)) * 0.5 + tourService.getCostChildByName(descriptionService.getNameTourByIdDes(idDescription)) + inccurred;
    }

    public DescriptionDetail(int idDescriptionDetail, int idDescription, String nameDescription, int adults, int childs, double inccurred, double total) {
        this.idDescriptionDetail = idDescriptionDetail;
        this.idDescription = idDescription;
        this.nameDescription = nameDescription;
        this.adults = adults;
        this.childs = childs;
        this.inccurred = inccurred;
        this.total = tourService.getCostAdoByName(descriptionService.getNameTourByIdDes(idDescription)) * 0.5 + tourService.getCostChildByName(descriptionService.getNameTourByIdDes(idDescription)) + inccurred;

    }

    public int getIdDescriptionDetail() {
        return idDescriptionDetail;
    }

    public void setIdDescriptionDetail(int idDescriptionDetail) {
        this.idDescriptionDetail = idDescriptionDetail;
    }

    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChilds() {
        return childs;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }

    public double getInccurred() {
        return inccurred;
    }

    public void setInccurred(double inccurred) {
        this.inccurred = inccurred;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
