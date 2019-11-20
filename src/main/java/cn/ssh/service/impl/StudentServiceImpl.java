package cn.ssh.service.impl;

import cn.ssh.dao.StudentDao;
import cn.ssh.entity.Student;
import cn.ssh.service.StudentService;
import cn.ssh.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Page<Student> selectStudents(Integer currentPage, Map map) {
        // 1,定义每页展示的条数
        int pageSize = 3;
        // 2，动态获取数据总条数
        int count = (int)selectStudentCount(map);
        // 3，创建Page对象
        Page<Student> page = new Page<Student>(currentPage,pageSize,count);
        // 4，分页查询数据
            StringBuffer stringBuffer = new StringBuffer("from Student where 1=1 ");
            if(map.get("name")!=null && !"".equals(map.get("name"))){
                map.put("name","%"+map.get("name")+"%");
                stringBuffer.append(" and name like :name");
            }
            if(map.get("minage")!=null && !"".equals(map.get("minage"))){
                stringBuffer.append(" and age>= :minage");
            }
            if(map.get("maxage")!=null && !"".equals(map.get("maxage"))){
                stringBuffer.append(" and age<= :maxage");
            }

        map.put("startIndex",page.getStartIndex());
        map.put("pageSize",pageSize);
        List<Student> students = studentDao.selectStudents(stringBuffer.toString(), map);
        // 5，把数据放入到page对象中
        page.setDataList(students);
        return page;
    }

    @Override
    public long selectStudentCount( Map map) {
        StringBuffer stringBuffer = new StringBuffer("select count(1) from Student where 1=1 ");
        if(map.get("name")!=null && !"".equals(map.get("name"))){
            map.put("name","%"+map.get("name")+"%");
            stringBuffer.append(" and name like :name");
        }
        if(map.get("minage")!=null && !"".equals(map.get("minage"))){
            stringBuffer.append(" and age>= :minage");
        }
        if(map.get("maxage")!=null && !"".equals(map.get("maxage"))){
            stringBuffer.append(" and age<= :maxage");
        }
        long num = studentDao.selectStudentCount(stringBuffer.toString(), map);
        return num;
    }

    @Override
    //添加
    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Integer id) {
        studentDao.updateStudent(id);
    }



}
