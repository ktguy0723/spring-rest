// package com.example.demo.student;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.time.LocalDate;
// import java.time.Month;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// @DataJpaTest
// public class StudentRepositoryTest {
  
//   @Autowired
//   private StudentRepository underTest;

//   @Test
//   void itShouldCheckIfStudentExistsEmail() {
//     // given
//     String email = "marian2.jamal@gmail.com";
//     Student student = new Student(
//       "Marian2",
//       email,
//       LocalDate.of(2001, Month.JANUARY, 5)
//     );
//     underTest.save(student);

//     // when
//     boolean expected = underTest.selectExistsEmail(email);

//     // then
//     assertThat(expected).isTrue();
    
//   }
// }

package com.example.demo.student;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
        String email = "jamila@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                LocalDate.of(2001, Month.JANUARY, 5)
        );
        underTest.save(student);

        // when
        boolean expected = underTest.selectExistsEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // given
        String email = "jamila@gmail.com";

        // when
        boolean expected = underTest.selectExistsEmail(email);

        // then
        assertThat(expected).isFalse();
    }
}