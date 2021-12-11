package com.vinoshipper.exercise

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate
import java.time.Month
import java.time.DayOfWeek

val DRINKING_AGE: Long = 21

val HOURS_IN_A_WEEKDAY: Int = 8

@RestController
class VSExerciseController() {

    @GetMapping("/validate-age")
    fun validateAge(@RequestParam(value = "birthday", defaultValue = "") birthday: String): Boolean {
        val birthdayDate: LocalDate = LocalDate.parse(birthday)
        var drinkingDate: LocalDate = birthdayDate.plusYears(DRINKING_AGE)
        if (birthdayDate.isLeapYear() && birthdayDate.getMonth() == Month.FEBRUARY && birthdayDate.getDayOfMonth() == 29 && drinkingDate.getMonth() == Month.FEBRUARY) {
            drinkingDate = drinkingDate.plusDays(1)
        }
        val currentDate: LocalDate = LocalDate.now()
        return !currentDate.isBefore(drinkingDate)
    }

    @GetMapping("/hours")
    fun calculateBusinessHours(@RequestParam(value = "start", defaultValue = "") start: String,
    @RequestParam(value = "end", defaultValue = "") end: String): Int {
        var startDate: LocalDate = LocalDate.parse(start)
        val endDate: LocalDate = LocalDate.parse(end)
        var hours: Int = 0
        while (!startDate.isAfter(endDate)) {
            val todaysDay: DayOfWeek = startDate.getDayOfWeek()
            if (!todaysDay.equals(DayOfWeek.SUNDAY) && !todaysDay.equals(DayOfWeek.SATURDAY)) {
                hours += HOURS_IN_A_WEEKDAY
            }
            startDate = startDate.plusDays(1)
        }
        return hours
    }
}