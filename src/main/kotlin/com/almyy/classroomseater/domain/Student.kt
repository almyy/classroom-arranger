package com.almyy.classroomseater.domain

import com.almyy.classroomseater.relation.Condition
import com.almyy.classroomseater.relation.ConditionType

data class Student(val name: String = "", val conditions: List<Condition> = listOf()) {

    fun canSitNextTo(otherStudent: Student?): Boolean {
        return !conditions.filter { it.conditionType == ConditionType.NOT }.flatMap { it.subjects }.contains(otherStudent?.name)
    }
}