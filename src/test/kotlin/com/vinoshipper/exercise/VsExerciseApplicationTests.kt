package com.vinoshipper.exercise

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class VsExerciseApplicationTests {

	@Test
	fun testValidateAge1() {
		val today: LocalDate = LocalDate.now()
		val ec: VSExerciseController = VSExerciseController()
		assert(!ec.validateAge(today.toString()))
	}

	@Test
	fun testValidateAge2() {
		val today: LocalDate = LocalDate.now()
		val ec: VSExerciseController = VSExerciseController()
		assert(ec.validateAge(today.minusYears(21).toString()) )
	}

	@Test
	fun testValidateAge3() {
		val today: LocalDate = LocalDate.now()
		val ec: VSExerciseController = VSExerciseController()
		assert(!ec.validateAge(today.plusDays(2).toString()))
	}

	@Test
	fun testCalculateBusinessHours1() {
		val ec: VSExerciseController = VSExerciseController()
		assert(ec.calculateBusinessHours("2021-12-10", "2021-12-10") == 8)
	}

	@Test
	fun testCalculateBusinessHours2() {
		val ec: VSExerciseController = VSExerciseController()
		assert(ec.calculateBusinessHours("2021-12-06", "2021-12-10") == 40)
	}

	@Test
	fun testCalculateBusinessHours3() {
		val ec: VSExerciseController = VSExerciseController()
		assert(ec.calculateBusinessHours("2021-12-01", "2021-12-31") == 184)
	}

	@Test
	fun testCalculateBusinessHours4() {
		val ec: VSExerciseController = VSExerciseController()
		assert(ec.calculateBusinessHours("2021-12-01", "2021-11-30") == 0)
	}
}
