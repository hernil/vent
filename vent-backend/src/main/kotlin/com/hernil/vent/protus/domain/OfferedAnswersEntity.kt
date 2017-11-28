package com.hernil.vent.protus.domain

import javax.persistence.*

@Entity
@Table(name = "offered_answers", schema = "protus", catalog = "")
data class OfferedAnswersEntity (
        @get:Id
        @get:Column(name = "idoffered_answers")
        var idofferedAnswers: Int = 0,
        @get:Basic
        @get:Column(name = "task_id")
        var taskId: Int = 0,
        @get:Basic
        @get:Column(name = "testid")
        var testid: Int = 0,
        @get:Basic
        @get:Column(name = "answer_a")
        var answerA: String? = null,
        @get:Basic
        @get:Column(name = "answer_b")
        var answerB: String? = null,
        @get:Basic
        @get:Column(name = "answer_c")
        var answerC: String? = null,
        @get:Basic
        @get:Column(name = "answer_d")
        var answerD: String? = null,
        @get:Basic
        @get:Column(name = "answer_type")
        var answerType: String? = null,
        @get:Basic
        @get:Column(name = "correct_answer")
        var correctAnswer: String? = null
) {
}
