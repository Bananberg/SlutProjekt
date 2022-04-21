package com.mekn.slutprojekt.service;

import com.mekn.slutprojekt.dao.CourseRepository;
import com.mekn.slutprojekt.model.Course;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class CourseServiceTest {
    private final CourseService courseService;

    public CourseServiceTest() {
        courseService = new CourseService();


        CourseRepository mockedRepo = mock(CourseRepository.class);
        Mockito.when(mockedRepo.findAll())
                .thenReturn(List.of(new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("VEG-pizza", 123d, true),
                        new Course("KÖTT-pizza", 987d, false),
                        new Course("KÖTT-pizza", 987d, false),
                        new Course("KÖTT-pizza", 987d, false)));

        ReflectionTestUtils.setField(courseService, "courseRepository", mockedRepo);
    }

    @BeforeTest
    public void setup() {

    }

    /*
     * Mål med metoden. vegetarianCourses ska randoma fram X antal rätter som är vegetariska.

     * kanske bevisa att randomiseringen fungerar också.
     */
    @Test
    void vegetarianCourses() {
        List<Course> list = courseService.vegetarianCourses();


        list.forEach(course -> assertTrue(course.isVegetarian()));
        assertEquals(7, list.size());
    }
}