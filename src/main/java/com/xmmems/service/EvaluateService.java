package com.xmmems.service;

import com.xmmems.domain.Evaluate;
import com.xmmems.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EvaluateService {
    @Autowired
    EvaluateMapper evaluateMapper;

    public int add(String uName, Integer uId, String role, List<Integer> checkedCities, String opinion) {

        Evaluate evaluate = new Evaluate();
        evaluate.setUId(uId);
        evaluate.setUName(uName);
        evaluate.setRole(role);
        evaluate.setOpinion(opinion);
        int num = 0;
        String grade = null;
        for (Integer str : checkedCities) {
            num = num + str;
        }
        evaluate.setSore(num);
        if (num > 90) {
            grade = "优秀";
        } else if (num >= 90 || num <= 80) {
            grade = "良好";
        } else if (num >= 80 || num <= 70) {
            grade = "合格";
        } else if (num < 70) {
            grade = "不及格";
        }
        evaluate.setGrade(grade);

        evaluate.setAuditTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return evaluateMapper.add(evaluate);
    }


    public Evaluate findById(Integer uId){
        return evaluateMapper.findbyUid(uId);
    }
}
