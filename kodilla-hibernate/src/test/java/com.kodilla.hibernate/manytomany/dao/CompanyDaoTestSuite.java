package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.taskList.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
//                /try {
            //    companyDao.delete(softwareMachineId);
            //    companyDao.delete(dataMaestersId);
            //    companyDao.delete(greyMatterId);
            //} catch (Exception e) {
            //    //do nothing
            //}
        }

    @Test
    public void FindEmployeeByNameTestSuite() {
        //Given
        Employee employee1 = new Employee("John ", "S");
        Employee employee3 = new Employee("karl ", "c");
        Employee employee2 = new Employee("wlad ", "b");

        Company cmd1 = new Company(new String("malbork"));
        Company cmd2 = new Company(new String("pasy"));
        Company cmd3 = new Company(new String("gdudzien"));

        employee1.getCompanies().add(cmd1);
        employee2.getCompanies().add(cmd2);
        employee3.getCompanies().add(cmd3);

        cmd1.getEmployees().add(employee1);
        cmd2.getEmployees().add(employee2);
        cmd3.getEmployees().add(employee3);

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        companyDao.save(cmd1);
        companyDao.save(cmd2);
        companyDao.save(cmd3);

        //When
        List<Company> companies = companyDao.retrieveComapniesWithThreeWordsForParam("pas%");

        //Then
        Assert.assertEquals(2, companies.size());

        companyDao.delete(cmd1.getId());
        companyDao.delete(cmd2.getId());
        companyDao.delete(cmd3.getId());

//        employeeDao.delete(employee1.getId());
//        employeeDao.delete(employee2.getId());
//        employeeDao.delete(employee3.getId());


    }
}
