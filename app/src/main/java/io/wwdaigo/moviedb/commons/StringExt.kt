package io.wwdaigo.moviedb.commons

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by daigomatsuoka on 16/07/17.
 */

fun String.formatDate(from: DateFormats, to: DateFormats): String {
    val simpleDateFormatFrom = SimpleDateFormat(from.format, Locale.getDefault())
    val simpleDateFormatTo = SimpleDateFormat(to.format, Locale.getDefault())
    val parsedDate = simpleDateFormatFrom.parse(this)
    return simpleDateFormatTo.format(parsedDate)
}