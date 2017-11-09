package com.almyy.classroomseater.domain

import com.almyy.classroomseater.relation.Condition
import com.almyy.classroomseater.relation.ConditionType
import org.chocosolver.solver.Model
import java.util.*


class Classroom(var desks: MutableList<MutableList<Desk?>> = mutableListOf(), var students: List<Student> = listOf(), var conditions: List<Condition> = listOf()) {

    init{
        this.desks = MutableList(2) { y -> MutableList<Desk?>(3) { x -> Desk(x, y, null) } }
        this.conditions = listOf(Condition(ConditionType.NOT, listOf("A", "B")))
        this.students = listOf(
                Student("A", listOf(Condition(ConditionType.NOT, listOf("B")))),
                Student("B", listOf(Condition(ConditionType.NOT, listOf("A")))),
                Student("C"),
                Student("D", listOf(Condition(ConditionType.NOT, listOf("A", "C")))))
    }

    fun getDesk(x: Int, y: Int): Desk? {
        return desks[x][y]
    }

    fun setDesk(x: Int, y: Int, value: Desk) {
        desks[x][y] = value
    }

    fun arrangeClassroom() {
        val model = Model("Classroom problem")

    }

    private fun findAvailableDesk(student: Student): Desk? {
        return desks
                .flatMap { it }
                .firstOrNull {
                    val rightDesk = getDeskToTheRightOf(it)
                    val leftDesk = getDeskToTheLeftOf(it)
                    it != null && it.student == null && (rightDesk?.student == null || (rightDesk.student.canSitNextTo(student) && student.canSitNextTo(rightDesk.student)))
                            && (leftDesk?.student == null || (leftDesk.student.canSitNextTo(student) && student.canSitNextTo(leftDesk.student)))
                }

    }

    private fun getDeskToTheRightOf(desk: Desk?): Desk? {
        if (desk != null) {
            return if (desk.x < desks[desk.y].size - 1) desks[desk.y][desk.x + 1] else null
        }
        return null
    }

    private fun getDeskToTheLeftOf(desk: Desk?): Desk? {
        if (desk != null) {
            return if (desk.x > 0) desks[desk.y][desk.x - 1] else null
        }
        return null
    }

    fun <E> Iterable<E>.shuffle(seed: Long? = null): MutableList<E> {
        val list = this.toMutableList()
        val random = if (seed != null) Random(seed) else Random()
        Collections.shuffle(list, random)
        return list
    }
}
