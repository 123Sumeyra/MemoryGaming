package com.sum.memorygame.model

import com.sum.memorygame.DEFAULT_ICONS

class MemoryGame(private val boardSize: BoardSize) {
    var cards: List<MemoryCard>

    val numPairsFound = 0
    init{
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizeImages = (chosenImages +chosenImages).shuffled()
       cards = randomizeImages.map{ MemoryCard(it) }

    }

    fun flipCard(position: Int) {
        val card = cards[position]
        card.isFaceUp = !card.isFaceUp



    }
}
