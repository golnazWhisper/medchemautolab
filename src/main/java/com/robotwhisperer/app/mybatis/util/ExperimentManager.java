package com.robotwhisperer.app.mybatis.util;

import org.apache.ibatis.session.SqlSession;

import com.robotwhisperer.app.mybatis.bean.Experiment;
import com.robotwhisperer.app.mybatis.mapper.ExperimentMapper;

/**
 * Created by admin_golnaz on 6/17/2017.
 */
public class ExperimentManager {
    public static Experiment selectExperimentById(int id) {
        SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory()
                .openSession();
        try {
            ExperimentMapper experimentMapper = sqlSession
                    .getMapper(ExperimentMapper.class);
            return experimentMapper.selectExperimentById(id);
        } finally {
            sqlSession.close();
        }
    }
}
