package ua.kpi.comsys.io8107

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import ua.kpi.comsys.io8107.ListPage.Book
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

const val FILE_NAME: String = "BookList.txt"

class ListFragment : Fragment(R.layout.list_fragment) {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_fragment, container, false)

        val list: ListView = view.findViewById(R.id.list)

        val imagesMap = mutableMapOf<String, Int>()
        imagesMap["Image_01.png"] = R.mipmap.image1_foreground
        imagesMap["Image_02.png"] = R.mipmap.image2_foreground
        imagesMap["Image_03.png"] = R.mipmap.image3_foreground
        imagesMap["Image_05.png"] = R.mipmap.image5_foreground
        imagesMap["Image_06.png"] = R.mipmap.image6_foreground
        imagesMap["Image_07.png"] = R.mipmap.image7_foreground
        imagesMap["Image_08.png"] = R.mipmap.image8_foreground
        imagesMap["Image_10.png"] = R.mipmap.image10_foreground


        val books = parseJson(FILE_NAME)
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

        val simpleAdapter = context?.let {
            SimpleAdapter(it, arrList, R.layout.list_item, from, to)
        }

        list.adapter = simpleAdapter
        return view
    }



    fun parseJson(fileName: String): Array<Book> {

        val scanner = Scanner(InputStreamReader(context?.assets?.open(fileName)))
        val sb = StringBuilder()
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine())
        }

        val gson = Gson()

        val books = gson.fromJson(
            sb.toString(),
            BooksContainer::class.java
        )

        return books.books
    }

}

