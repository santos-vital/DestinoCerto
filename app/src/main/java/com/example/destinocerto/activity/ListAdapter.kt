package com.example.destinocerto.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.destinocerto.R
import com.example.destinocerto.model.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>() // Aqui criei uma lista de usuários

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {} // viewholder para receber os dados passados para o banco

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
        // Método responsável por inflar o layout para criar um usuário
    }

    override fun getItemCount(): Int {
        return userList.size // Método para retornar o numero de usuarios na lista
    }

    // define os atributos de exibição com base nos dados
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val users = userList[position]
        holder.itemView.comment_txt.text = users.comment
        holder.itemView.name_txt.text = users.nickName
    }

    // Função restponsável por inserir um novo usuário na lista
    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}
