package com.almyy.classroomseater.controller

import com.almyy.classroomseater.domain.Classroom
import com.almyy.classroomseater.domain.Student
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController() {

    @RequestMapping("/student", method = arrayOf(RequestMethod.GET))
    fun student(): List<Student> {
        val classroom = Classroom()
        return classroom.students
    }
}