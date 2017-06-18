package com.robotwhisperer.app.mybatis;

import org.junit.Test;

import com.robotwhisperer.app.mybatis.bean.Experiment;
import com.robotwhisperer.app.mybatis.util.ExperimentManager;

/**
 * Created by admin_golnaz on 6/17/2017.
 */
public class ExperimentManagerTest {


    @Test
    public void testUpdateUser() {
        Experiment experiment = ExperimentManager.selectExperimentById(1);
        assert(experiment != null);
        assert(experiment.getChemist().equals("Michael"));
    }

}
