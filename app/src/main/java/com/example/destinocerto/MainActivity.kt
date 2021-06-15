package com.example.destinocerto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.destinocerto.model.Country
import com.example.destinocerto.activity.CountryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val countries = ArrayList<Country>()
    private val displayList = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        countries.add(Country("Alemanha", "País localizado no oeste da Europa e é uma das maiores potências mundiais.", R.drawable.flag_germany))
        countries.add(Country("Estados Unidos", "Estados Unidos da América (EUA), é um país localizado na América do Norte).", R.drawable.flag_eua))
        countries.add(Country("China", "A China, uma das maiores potências mundiais, oficialmente chamada República Popular da China.", R.drawable.flag_china))
        countries.add(Country("França", "A França está entre os países mais ricos e desenvolvidos do mundo.", R.drawable.flag_france))
        countries.add(Country("Inglaterra", "Inglaterra (em inglês: England) é uma das nações constituintes do Reino Unido.", R.drawable.flag_england))
        displayList.addAll(countries)

        val adapter = CountryAdapter(displayList, this);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {

            val  searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {

                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        countries.forEach {

                            if (it.CountryName.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }

                        recyclerView.adapter!!.notifyDataSetChanged()

                    } else {

                        displayList.clear()
                        displayList.addAll(countries)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}