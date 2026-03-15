package at.aau.serg.controllers

import at.aau.serg.models.GameResult
import at.aau.serg.services.GameResultService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameResultControllerTests {

    @Test
    fun test_add_get_and_delete_gameResult() {

        val service = GameResultService()
        val controller = GameResultController(service)

        val result = GameResult(0L, "Tester", 50, 12.3)

        // add
        controller.addGameResult(result)

        val all = controller.getAllGameResults()
        assertEquals(1, all.size)

        val id = all[0].id

        // get
        val single = controller.getGameResult(id)
        assertNotNull(single)

        // delete
        controller.deleteGameResult(id)

        val afterDelete = controller.getGameResult(id)
        assertNull(afterDelete)
    }
}