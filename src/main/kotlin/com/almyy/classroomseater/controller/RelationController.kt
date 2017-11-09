package com.almyy.classroomseater.controller

import com.almyy.classroomseater.relation.Condition
import com.almyy.classroomseater.relation.ConditionType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RelationController {

    @RequestMapping("/relation")
    fun relation(): Condition {
        return Condition(ConditionType.NOT, listOf("A", "B"))
    }
}