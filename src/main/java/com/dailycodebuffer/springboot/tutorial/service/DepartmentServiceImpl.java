package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        //TODO: handle "message": "No value present",
/*
        if (departmentRepository.findById(departmentId).isEmpty()){
            //case where there is no record in db? -> "message": "No value present",
        }
*/
        Department departmentRecordInDb= departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !department.getDepartmentName().isBlank()) {
            departmentRecordInDb.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !department.getDepartmentCode().isBlank()) {
            departmentRecordInDb.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !department.getDepartmentAddress().isBlank()) {
            departmentRecordInDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentRecordInDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        //TODO handle not unique results: javax.persistence.NonUniqueResultException: query did not return a unique result: 2
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
