package com.emilabdurahmanli.recyclerviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.emilabdurahmanli.recyclerviewtask.adapters.RecyclerViewHorizontalAdapter
import com.emilabdurahmanli.recyclerviewtask.adapters.RecyclerViewVerticalAdapter
import com.emilabdurahmanli.recyclerviewtask.databinding.ActivityMainBinding
import com.emilabdurahmanli.recyclerviewtask.model.Country
import com.emilabdurahmanli.recyclerviewtask.model.Person
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var adapter : RecyclerViewVerticalAdapter
    lateinit var adapter2 : RecyclerViewHorizontalAdapter

    var personList : List<Person> = mutableListOf<Person>(
        Person("Ibrahim", "Eliyev", 18),
        Person("Nihat", "Mammadli", 17),
        Person("Emil", "Abdurahmanli", 17),
        Person("Ceyhune", "Sevdiyeva", 17)
    )

    var countryList : List<Country> = mutableListOf<Country>(
        Country("Azerbaijan", "Baku", R.drawable.azerbaijan),
        Country("Turkey", "Ankara", R.drawable.turkey),
        Country("Canada", "Ottawa", R.drawable.canada),
        Country("Sweden", "Stockholm", R.drawable.sweden)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RecyclerViewVerticalAdapter(countryList)
        adapter2 = RecyclerViewHorizontalAdapter(personList)
        recyclerView()
        listeners()
    }

    private fun recyclerView(){

        binding.recyclerViewVertical.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        binding.recyclerViewVertical.itemAnimator = SlideInLeftAnimator()
        binding.recyclerViewHorizontal.itemAnimator = SlideInUpAnimator(OvershootInterpolator(1f))

        binding.recyclerViewVertical.adapter = adapter
        binding.recyclerViewHorizontal.adapter = adapter2

    }
    fun listeners(){
        binding.button.setOnClickListener {
            personList = personList + Person("Emil", "Abdurahmanli", 17)


        }
    }
}