package com.example.CaptainsLogClient

import org.junit.Assert.*
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

// Simple fake repo for testing ViewModel without Room
class FakeRepository {
    private val shakes = mutableListOf<MaracasData>()

    fun addShake(shake: MaracasData) {
        shakes.add(shake)
    }

    fun getShakes(): List<MaracasData> = shakes

    fun deleteShakesOlderThan(cutoff: Date) {
        shakes.removeAll { it.timestamp.before(cutoff) }
    }
}

class MaracasTests {

    @Test
    fun maracasData_equalityAndCopy() {
        val now = Date()
        val data1 = MaracasData(timestamp = now, magnitude = 20.0F)
        val data2 = data1.copy()

        assertEquals(data1, data2)
        assertEquals(20.0F, data2.magnitude, 0.01F)
    }

    @Test
    fun deleteShakesOlderThan_removesOldShakes() {
        val repo = FakeRepository()
        val cutoff = SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2025-09-01 00:00")!!

        repo.addShake(MaracasData(Date(cutoff.time - 1000), 10.0F)) // old
        repo.addShake(MaracasData(Date(cutoff.time + 1000), 15.0F)) // new

        repo.deleteShakesOlderThan(cutoff)

        val shakes = repo.getShakes()
        assertEquals(1, shakes.size)
        assertEquals(15.0F, shakes.first().magnitude, 0.01F)
    }

    @Test
    fun dateFormat_outputsCorrectTime() {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val parsed = sdf.parse("2025-09-11 12:34")
        assertNotNull(parsed)
        assertEquals(12, parsed!!.hours)
        assertEquals(34, parsed.minutes)
    }

    // Example of extracted shake detection math test
    private fun detectShake(x: Float, y: Float, z: Float, gravity: FloatArray): Double {
        val alpha = 0.8f
        gravity[0] = alpha * gravity[0] + (1 - alpha) * x
        gravity[1] = alpha * gravity[1] + (1 - alpha) * y
        gravity[2] = alpha * gravity[2] + (1 - alpha) * z
        val nx = x - gravity[0]
        val ny = y - gravity[1]
        val nz = z - gravity[2]
        return (nx * nx + ny * ny + nz * nz).toDouble()
    }

    @Test
    fun detectShake_computesMagnitude() {
        val gravity = floatArrayOf(0f, 0f, 0f)
        val mag = detectShake(10f, 0f, 0f, gravity)
        assertTrue("Expected magnitude above threshold", mag > 15.0)
    }
}
