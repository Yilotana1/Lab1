package ua.kpi.comsys.io8107.ListPage

import android.content.Context
import com.google.gson.Gson
import ua.kpi.comsys.io8107.BooksContainer
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

const val FILE_NAME: String = "BookList.txt"

val FILE_NAMES = arrayOf(
    "9780321856715.txt",
    "9780321862969.txt",
    "9781118841471.txt",
    "9781430236054.txt",
    "9781430237105.txt",
    "9781430238072.txt",
    "9781430245124.txt",
    "9781430260226.txt",
    "9781449308360.txt",
    "9781449342753.txt"
)


class DAO(val context: Context) {

    fun parseJsonBookArray(fileName: String): Array<Book> {

        val scanner = Scanner(InputStreamReader(context?.assets?.open(fileName)))
        val sb = StringBuilder()
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine())
        }

        val gson = Gson()

        val container = gson.fromJson(
            sb.toString(),
            BooksContainer::class.java
        )

        return container.books
    }

    fun parseBookInfo(fileName: String): Book.Info {
        val scanner = Scanner(InputStreamReader(context?.assets?.open(fileName)))
        val sb = StringBuilder()
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine())
        }

        val gson = Gson()

        return gson.fromJson(
            sb.toString(),
            Book.Info::class.java
        )
    }

    fun getBookInfoArray(fileNames: Array<String>): ArrayList<Book.Info> {
        val list: ArrayList<Book.Info> = ArrayList()
        for (name in fileNames) {
            list.add(parseBookInfo(name))
        }
        return list
    }

    private fun fillBookWithInfo(books: Array<Book>, bookInfo: ArrayList<Book.Info>) {
        for (book in books) {
            for (info in bookInfo) {
                if (book.title == info.title) {
                    book.info = info
                }
            }
        }
    }


    fun getBooks(): Array<Book> {
        val books = parseJsonBookArray(FILE_NAME)
        val bookInfo = getBookInfoArray(FILE_NAMES)
        fillBookWithInfo(books, bookInfo)
        return books
    }

}