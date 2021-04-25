package ua.kpi.comsys.io8107.ListPage


class Book(
    val image: String,
    val price: String,
    val isbn13: String,
    val subtitle: String,
    val title: String
) {

    override fun toString(): String {
        return "{title = ${this.title},\n subtitle = ${this.subtitle},\n isbn13 = ${this.isbn13},\n price = ${this.price},\n image = ${this.image}}\n\n\n"
    }

}