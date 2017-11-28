package com.hernil.vent.protus.domain

import javax.persistence.*

@Entity
@Table(name = "learners_answers", schema = "protus", catalog = "")
data class LearnersAnswersEntity(
    @get:Id
    @get:Column(name = "idlearners_answers")
    var idlearnersAnswers: Int = 0,
    @get:Basic
    @get:Column(name = "idtask")
    var idtask: Int = 0,
    @get:Basic
    @get:Column(name = "submitted_answer")
    var submittedAnswer: String? = null,
    @get:Basic
    @get:Column(name = "is_correct")
    var isCorrect: Int? = null
) {

}
