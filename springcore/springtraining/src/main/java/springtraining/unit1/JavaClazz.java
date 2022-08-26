package springtraining.unit1;


import org.springframework.beans.factory.DisposableBean;

import java.util.Map;

public class JavaClazz implements DisposableBean {
    private Map<String,Integer> students;
    public Map<String,Integer> getStudents(){
        return students;
    }

    public void setStudents(Map<String, Integer> students) {
        this.students = students;
    }

    @Override
    public void destroy() throws Exception {
        if(students==null){
            System.out.println("students is null");
        }
    }
}
