package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.PromotionsDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Promotions extends ModelBase<PromotionsDto> {
    private String namePromotion;
    private Integer discountPromotion;
    private Date startproDatePro;
    private Date expiredproDatePro;


    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }


    public Integer getDiscountPromotion() {
        return discountPromotion;
    }

    public void setDiscountPromotion(Integer discountPromotion) {
        this.discountPromotion = discountPromotion;
    }


    public Date getStartproDatePro() {
        return startproDatePro;
    }

    public void setStartproDatePro(Date startproDatePro) {
        this.startproDatePro = startproDatePro;
    }


    public Date getExpiredproDatePro() {
        return expiredproDatePro;
    }

    public void setExpiredproDatePro(Date expiredproDatePro) {
        this.expiredproDatePro = expiredproDatePro;
    }

}
