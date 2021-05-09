package ua.kpi.comsys.io8107.ListPage


class Book(
    val image: String,
    val price: String,
    val isbn13: String,
    val subtitle: String,
    val title: String
) {

    var info: Info? = null

    override fun toString(): String {
        return "{title = ${this.title},\n subtitle = ${this.subtitle},\n isbn13 = ${this.isbn13},\n price = ${this.price},\n image = ${this.image}}\n\n\n"
    }

    class Info(
        val title: String,
        val subtitle: String,
        val authors: String,
        val publisher: String,
        val isbn13: String,
        val pages: String,
        val year: String,
        val rating: String,
        val desc: String,
        val price:String,
        val image: String
    ) {
        override fun toString(): String {
            return "{title=${title},\n subtitle=${subtitle},\n authors=${authors},\n publisher=${publisher},\n isbn13=${isbn13},\n pages=${pages},\n" +
                    "year=${year},\n rating=${rating},\n desc=${desc},\n price=${price},\n image=${image}}\n\n\n"
        }
    }

}