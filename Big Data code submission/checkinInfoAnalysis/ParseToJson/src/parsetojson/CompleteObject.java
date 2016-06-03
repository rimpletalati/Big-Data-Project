/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsetojson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dishu Jindal
 */
public class CompleteObject {

    private String business_id;
    private CheckinInfo checkinInfo = new CheckinInfo();

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public CheckinInfo getCheckinInfo() {
        return checkinInfo;
    }

    public void setCheckinInfo(CheckinInfo checkinInfo) {
        this.checkinInfo = checkinInfo;
    }
    
    @Override
    public String toString() {
        return "CompleteObject{" + "business_id=" + business_id + ", checkinInfo=" + checkinInfo + '}';
    }
}
