/**
 * Created by admin_golnaz on 6/17/2017.
 */

package com.robotwhisperer.app.mybatis.bean;

import java.util.Date;

public class Experiment {
    private int experimentId;
    private String chemist;
    private String compunds;
    private Date importTimeStamp;

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getChemist() {
        return chemist.trim();
    }

    public void setChemist(String chemist) {
        this.chemist = chemist;
    }

    public String getCompunds() {
        return compunds;
    }

    public void setCompunds(String compunds) {
        this.compunds = compunds;
    }

    public Date getImportTimeStamp() {
        return importTimeStamp;
    }

    public void setImportTimeStamp(Date importTimeStamp) {
        this.importTimeStamp = importTimeStamp;
    }
}
