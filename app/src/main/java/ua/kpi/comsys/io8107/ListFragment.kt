package ua.kpi.comsys.io8107

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import ua.kpi.comsys.io8107.ListPage.DAO
import kotlin.collections.ArrayList

class ListFragment : Fragment(R.layout.list_fragment) {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val dao = context?.let { DAO(it) }

        val view = inflater.inflate(R.layout.list_fragment, container, false)

        val list: ListView = view.findViewById(R.id.list)

        val simpleAdapter = dao?.let { createAdapter(it) }

        list.adapter = simpleAdapter

        Log.d("ADAPTER", simpleAdapter?.count.toString())
        val inputField = view.findViewById<EditText>(R.id.search)

        inputField.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                simpleAdapter?.filter?.filter(s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        return view
    }

    fun createAdapter(dao: DAO): SimpleAdapter? {

        val imagesMap = mutableMapOf<String, Int>()
        imagesMap["Image_01.png"] = R.mipmap.image1_foreground
        imagesMap["Image_02.png"] = R.mipmap.image2_foreground
        imagesMap["Image_03.png"] = R.mipmap.image3_foreground
        imagesMap["Image_05.png"] = R.mipmap.image5_foreground
        imagesMap["Image_06.png"] = R.mipmap.image6_foreground
        imagesMap["Image_07.png"] = R.mipmap.image7_foreground
        imagesMap["Image_08.png"] = R.mipmap.image8_foreground
        imagesMap["Image_10.png"] = R.mipmap.image10_foreground


        val books = dao.getBooks()
        val titles = mutableListOf<String>()
        val subtitles = mutableListOf<String>()
        val prices = mutableListOf<String>()
        val images = mutableListOf<Int>()
        for (book in books) {
            titles.add(book.title)
            subtitles.add(book.subtitle)
            prices.add(book.price)

            if (imagesMap[book.image] == null) {
                images.add(R.mipmap.image0_foreground)
            } else {
                imagesMap[book.image]?.let { images.add(it) }
            }
        }


        val from = arrayOf("title", "subtitle", "price", "image")
        val to = intArrayOf(R.id.title, R.id.subtitle, R.id.price, R.id.image)


        val arrList = ArrayList<Map<String, Any>>()
        var map: MutableMap<String, Any>

        for (i in titles.indices) {
            map = mutableMapOf()
            map["title"] = titles[i]
            map["subtitle"] = subtitles[i]
            map["price"] = prices[i]
            map["image"] = images[i]
            arrList.add(map)
        }

        return context?.let {
            SimpleAdapter(it, arrList, R.layout.list_item, from, to)
        }
    }


    class Adapter(context: Context?,
                  data: MutableList<out MutableMap<String, *>>?, resource: Int,
                  from: Array<out String>?, to: IntArray?
    ) : SimpleAdapter(context, data, resource, from, to){

        private val list = data
        override fun getCount(): Int {
            if (list == null) {return 0}
            return super.getCount()
        }
    }



}

