import java.io.PrintStream
import java.text.DateFormatSymbols
import java.text.MessageFormat
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale

internal fun PrintStream.printCalendar(year: Int, nCols: Byte, locale: Locale?) { // using the output stream to show the calandar
    if (nCols < 1 || nCols > 12)
        throw IllegalArgumentException("Illegal column width.") // watches for outputtting error
    val w = nCols * 24
    val nRows = Math.ceil(12.0 / nCols).toInt()

    val date = GregorianCalendar(year, 0, 1) // uses the gregorian caldendar import
    var offs = date.get(Calendar.DAY_OF_WEEK) - 1

    val days = DateFormatSymbols(locale).shortWeekdays.slice(1..7).map { it.slice(0..1) }.joinToString(" ", " ") // setting up the days/week
    val mons = Array(12) { Array(8) { "" } } // creates the months array
    DateFormatSymbols(locale).months.slice(0..11).forEachIndexed { m, name -> 
        val len = 11 + name.length / 2
        val format = MessageFormat.format("%{0}s%{1}s", len, 21 - len)
        mons[m][0] = String.format(format, name, "")
        mons[m][1] = days
        val dim = date.getActualMaximum(Calendar.DAY_OF_MONTH) // adjust the days according to the year
        for (d in 1..42) {
            val isDay = d > offs && d <= offs + dim
            val entry = if (isDay) String.format(" %2s", d - offs) else "   "
            if (d % 7 == 1)
                mons[m][2 + (d - 1) / 7] = entry
            else
                mons[m][2 + (d - 1) / 7] += entry
        }
        offs = (offs + dim) % 7
        date.add(Calendar.MONTH, 1)
    }

    printf("%" + (w / 2 + 10) + "s%n", "[3055u]")
    printf("%" + (w / 2 + 4) + "s%n%n", year)

    for (r in 0 until nRows) {
        for (i in 0..7) {
            var c = r * nCols
            while (c < (r + 1) * nCols && c < 12) {
                printf("   %s", mons[c][i])
                c++
            }
            println()
        }
        println()
    }
}

fun main(args: Array<String>) {
    System.out.printCalendar(2018, 3, Locale.CANADA)
}
