package com.robotwhisperer.app.mybatis.mapper;

import com.robotwhisperer.app.mybatis.bean.Experiment;

/**
 * Created by admin_golnaz on 6/17/2017.
 */
public interface ExperimentMapper {
    public Experiment selectExperimentById(int id);
}
