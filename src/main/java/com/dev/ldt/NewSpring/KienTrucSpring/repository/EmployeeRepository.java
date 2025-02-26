package com.dev.ldt.NewSpring.KienTrucSpring.repository;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
//    public List<Employee> getEmployeeFromDB(){
//        return List.of(
//                new Employee(1L, "Tiendev", 18),
//                new Employee(2L, "ldv", 20),
//                new Employee(3L, "ldd", 55));
//    }
}
