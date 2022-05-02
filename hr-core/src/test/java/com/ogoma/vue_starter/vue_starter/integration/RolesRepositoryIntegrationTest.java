//package com.ogoma.vue_starter.vue_starter.integration;
//
//import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
//import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.RolesRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ActiveProfiles("test")
//public class RolesRepositoryIntegrationTest {
//
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @Test
//    public void can_save_role(){
//        //Given
//        Role role= new Role("test","test");
//        //when
//        rolesRepository.save(role);
//        Iterable<Role> roles = rolesRepository.findAll();
//        //then
//        assertThat(roles).hasSize(1);
//
//    }
//
//}
