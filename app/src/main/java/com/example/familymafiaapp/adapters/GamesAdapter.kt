package com.example.familymafiaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.familymafiaapp.R
import com.example.familymafiaapp.entities.Game
import com.example.familymafiaapp.holders.BaseBindableHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_game.view.*

class GamesAdapter : ListAdapter<Game, GamesAdapter.GameViewHolder>(
    object : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(
            oldItem: Game,
            newItem: Game
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Game,
            newItem: Game
        ): Boolean = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_game,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class GameViewHolder(item: View) : BaseBindableHolder<Game>(item) {

        override fun onBind(item: Game) {
            itemView.apply {
                txtWinner.text = "Выиграл " + item.winner
                txtPlayer1.text = item.players[0]
                txtPlayer2.text = item.players[1]
                txtPlayer3.text = item.players[2]
                txtPlayer4.text = item.players[3]
                txtPlayer5.text = item.players[4]
                txtPlayer6.text = item.players[5]
                txtPlayer7.text = item.players[6]
                txtPlayer8.text = item.players[7]
                txtPlayer9.text = item.players[8]
                txtPlayer10.text = item.players[9]

                txtPlayer1Role.text = item.roles[0]
                txtPlayer2Role.text = item.roles[1]
                txtPlayer3Role.text = item.roles[2]
                txtPlayer4Role.text = item.roles[3]
                txtPlayer5Role.text = item.roles[4]
                txtPlayer6Role.text = item.roles[5]
                txtPlayer7Role.text = item.roles[6]
                txtPlayer8Role.text = item.roles[7]
                txtPlayer9Role.text = item.roles[8]
                txtPlayer10Role.text = item.roles[9]
            }
        }

    }

}