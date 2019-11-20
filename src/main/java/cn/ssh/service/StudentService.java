package cn.ssh.service;

import cn.ssh.entity.Student;
import cn.ssh.utils.Page;

import java.util.List;
import java.util.Map;

public interface StudentService {
    // 分页查询
    public Page<Student> selectStudents(Integer currentPage, Map map);
    // 查询总条数
    public long selectStudentCount(Map map);

    //添加
    public void addStudent(Student student);
    //删除
    public void deleteStudent(Integer id);
    //修改
    public void updateStudent(Integer id);

}
