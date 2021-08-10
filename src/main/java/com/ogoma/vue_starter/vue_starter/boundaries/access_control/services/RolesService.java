package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role_;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User_;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.RolesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Optional<Role> findRoleById(long id) {
        return rolesRepository.findById(id);
    }

    public List<Role> getAllRoles() {
        List<Role> roles = rolesRepository.findAll();
        return roles;
    }

    public Page<Role> getAllRoles(Pageable pageable) {
        Page<Role> roles = rolesRepository.findAll(
                new Specification<Role>() {
                    @Override
                    public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        if(Long.class!=criteriaQuery.getResultType()){
                             root.fetch(Role_.createdBy, JoinType.LEFT);
                                     //.fetch(User_.employee,JoinType.LEFT);
                             criteriaBuilder.equal(root.get(Role_.DELETED),true);
                        }
                        return criteriaBuilder.conjunction();
                    }
                },
                pageable);
        return roles;
    }

    public Role addRole(Role roleRequest) {
        return rolesRepository.save(roleRequest);
    }

    public void removeRole(Long roleId) {
        this.rolesRepository.deleteById(roleId);
    }

    public Optional<Role> updateRole(Long id, Role role) {
        Optional<Role> optionalRole = this.rolesRepository.findById(id);
        optionalRole.ifPresent(r -> {
            r.setName(role.getName());
            r.setDescription(role.getDescription());
            rolesRepository.save(r);
        });
        return optionalRole;
    }

    public ByteArrayInputStream generateReport() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        List<Role> roleList = this.rolesRepository.findAll();
        XSSFSheet spreadsheet = (XSSFSheet) workbook.createSheet("Roles");
        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell;
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Description");
        int rowId = 1;
        for (Role role  : roleList) {
            row = spreadsheet.createRow(rowId++);
            cell = row.createCell(1);
            cell.setCellValue(role.getName());
            cell = row.createCell(2);
            cell.setCellValue(role.getDescription());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }
}
