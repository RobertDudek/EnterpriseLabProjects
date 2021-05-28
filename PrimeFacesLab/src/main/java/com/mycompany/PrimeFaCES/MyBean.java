package com.mycompany.PrimeFaCES;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "myBean", eager = true)
@RequestScoped
public class MyBean {
    private Date date;    
    private int sumOut;
    private int x;
    private int y;
    
    public void sum() {
        this.setSumOut(this.getX() + this.getY());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The sum is:", String.valueOf(this.getX()) + " + " + String.valueOf(this.getY()) + " = " + String.valueOf(this.getSumOut())));
    }
    public Date getDate() {
        this.date = new Date();
        return date;
    }

    /**
     * @return the sumOut
     */
    public int getSumOut() {
        return sumOut;
    }

    /**
     * @param sumOut the sumOut to set
     */
    public void setSumOut(int sumOut) {
        this.sumOut = sumOut;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
}
