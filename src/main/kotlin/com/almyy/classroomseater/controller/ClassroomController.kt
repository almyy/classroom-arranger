package com.almyy.classroomseater.controller

import com.almyy.classroomseater.domain.Classroom
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController

@RestController
class ClassroomController {

    @RequestMapping("/classroom", method = arrayOf(GET))
    fun classroom(): Classroom {
        val classroom = Classroom()
        classroom.arrangeClassroom()
        return classroom
    }
}

