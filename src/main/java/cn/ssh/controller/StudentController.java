package cn.ssh.controller;

import cn.ssh.entity.Student;
import cn.ssh.service.StudentService;
import cn.ssh.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    // 分页查询的功能
    @RequestMapping("/selectStudents")
    public String selectStudents(Integer currentPage,Model model,String name,Integer minage,Integer maxage){
        if (currentPage==null) {
            currentPage = 1;
        }
        Map map = new HashMap();
        map.put("name",name);
        map.put("minage",minage);
        map.put("maxage",maxage);
        Page<Student> page = studentService.selectStudents(currentPage, map);
        model.addAttribute("page",page);
        model.addAttribute("map",map);
        return "list.jsp";
    }

    //添加
    @RequestMapping("/addStudent")
    public String addStudent(String name, Integer age, String sex, Date birthday){
        Student student=new Student(null,name,sex,age,birthday);
        studentService.addStudent(student);
        return "list.jsp";
    }

    //删除
    @RequestMapping("/deleteStudent")
    public String deleteStudent(Integer id){
        studentService.deleteStudent(id);
        return "list.jsp";
    }

    //修改
    @RequestMapping("/updateStudent")
    public String updateStudent(Integer id){
        studentService.deleteStudent(id);
        return "list.jsp";
    }


}
