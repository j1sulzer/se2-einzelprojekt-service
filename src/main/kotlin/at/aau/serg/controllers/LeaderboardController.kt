package at.aau.serg.controllers

import at.aau.serg.models.GameResult
import at.aau.serg.services.GameResultService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/leaderboard")
class LeaderboardController(
    private val gameResultService: GameResultService
) {
    @GetMapping
    fun getLeaderboard(): List<GameResult> =
        gameResultService.getGameResults()
            // sort: score desc (higher better) then timeInSeconds asc (shorter better)
            .sortedWith(
                compareByDescending<GameResult> { it.score }
                    .thenBy { it.timeInSeconds }
            )
}
/*gameResultService.getGameResults()
.sortedWith(compareBy({ -it.score }, { it.timeInSeconds }))*/