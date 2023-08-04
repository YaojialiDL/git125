package com.yc.git.test3.user;

import com.yc.git.test3.system.ContainerFilter;
import org.springframework.stereotype.Component;

/**
 * Bmi筛选器
 */
@Component("bmiFilter")
public class StudentBmiFilter implements ContainerFilter {
    //Logger logger = Logger.getLogger(StudentBmiFilter.class);

    @Override
    public boolean doFilter(Object obj) {
        if(obj == null){
            throw new RuntimeException("待测数据异常...");
        }
        if( !(obj instanceof Student) ){
            throw new RuntimeException("待测数据异常...");
        }
        Student s = (Student) obj;
        if(s.getName() == null || "".equalsIgnoreCase(s.getName())){
            return false;
        }
        if(s.getHeight() < 1 || s.getHeight() > 2.7){
            //logger.error("身高数据异常..." + obj.toString());
            //System.out.println("身高数据异常..." + obj.toString());
            return false;
        }
        if(s.getWeight() < 30 || s.getWeight() > 500){
            //logger.error("体重数据异常..." + obj.toString());
            //System.out.println("体重数据异常..." + obj.toString());
            return false;
        }
        return true;
    }
}
