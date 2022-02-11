package com.sum.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sum.memorygame.databinding.ActivityMainBinding
import com.sum.memorygame.model.BoardSize


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPair: TextView
    private val boardSize: BoardSize =BoardSize.EASY


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvBoard = binding.rvboard
        tvNumMoves =binding.tvNumMoves
        tvNumPair = binding.tvNumPairs

        rvBoard.adapter =MemoryBoardAdapter(this, boardSize)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager =GridLayoutManager(this, boardSize.getWidth())




    }
}