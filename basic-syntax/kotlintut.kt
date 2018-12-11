
// created a caesar cypher using basic syntax
object Caesar {
    fun encrypt(s: String, key: Int): String {
        val offset = key % 26
        if (offset == 0) return s
        var d: Char
        val chars = CharArray(s.length)
        for ((index, c) in s.withIndex()) // uses offset to encrypt data
         {
            if (c in 'A'..'Z') {
                d = c + offset
                if (d > 'Z') d -= 26
            }
            else if (c in 'a'..'z') {
                d = c + offset
                if (d > 'z') d -= 26
            }
            else
                d = c
            chars[index] = d
        }
        return chars.joinToString("")
    }

    fun decrypt(s: String, key: Int): String {
        return encrypt(s, 26 - key)
    }
}

fun main(args: Array<String>) {
    val encoded = Caesar.encrypt("Ken pu is the best prof.", 8)
    println(encoded)
    val decoded = Caesar.decrypt(encoded, 8)
    println(decoded)
}
