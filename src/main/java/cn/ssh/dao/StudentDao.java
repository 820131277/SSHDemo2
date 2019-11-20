package cn.ssh.dao;

import cn.ssh.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    // 分页查询
    public List<Student> selectStudents(String hql, Map map);
    // 查询总条数
    public long selectStudentCount(String hql, Map map);

    //添加
    public void addStudent(Student student);
    //删除
    public void deleteStudent(Integer id);
    //修改
    public void updateStudent(Integer id);

}
