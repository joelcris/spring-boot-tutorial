package com.dailycodebuffer.springboot.tutorial.repository;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Department entities.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Finds a department by its name.
     *
     * @param departmentName the name of the department to find
     * @return the Department with the given name, or null if not found
     */
    public Department findByDepartmentName(String departmentName);

    /**
     * Finds a department by its name, ignoring case.
     *
     * @param departmentName the name of the department to find
     * @return the Department with the given name, or null if not found
     */
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
