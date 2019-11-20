package cn.ssh.dao.impl;

import cn.ssh.dao.StudentDao;
import cn.ssh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Student> selectStudents(String hql, Map map) {
        List<Student> list = sessionFactory.getCurrentSession()
                                .createQuery(hql)
                                .setFirstResult((int)map.get("startIndex"))
                                .setMaxResults((int)map.get("pageSize"))
                                .setProperties(map)
                                .list();
        return list;
    }

    @Override
    public long selectStudentCount(String hql, Map map) {
        long num = (long)sessionFactory.getCurrentSession()
                        .createQuery(hql)
                        .setProperties(map)
                        .uniqueResult();
        return num;
    }

    @Override
    //添加
    public void addStudent(Student student){
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    //删除
    public void deleteStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Student student =(Student) session.load(Student.class, id);
        session.delete(student);
    }

    @Override
    //修改
    public void updateStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Student student =(Student) session.load(Student.class, id);



    }

}
