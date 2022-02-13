package com.sum.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sum.memorygame.databinding.ActivityMainBinding
import com.sum.memorygame.model.BoardSize
import com.sum.memorygame.model.MemoryCard
import com.sum.memorygame.model.MemoryGame


class MainActivity : AppCompatActivity() {

    companion object{
        private  const val TAG = "MainActivity"
    }

    private lateinit var memoryGame: MemoryGame
    private lateinit var adapter: MemoryBoardAdapter
    private lateinit var binding :ActivityMainBinding
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPair: TextView
    private val boardSize: BoardSize =BoardSize.HARD


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvBoard = binding.rvboard
        tvNumMoves =binding.tvNumMoves
        tvNumPair = binding.tvNumPairs


        memoryGame = MemoryGame(boardSize)

        adapter =MemoryBoardAdapter(this, boardSize,memoryGame.cards, object :MemoryBoardAdapter.CardClickListener{
            override fun onCardClicked(position: Int) {
                //Log.i(TAG, "card clicked $position")
                updateGameWithFlip(position)
            }

        })
        rvBoard.adapter =adapter
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager =GridLayoutManager(this, boardSize.getWidth())




    }

    private fun updateGameWithFlip(position: Int) {
        memoryGame.flipCard(position)
        adapter.notifyDataSetChanged()

    }
}