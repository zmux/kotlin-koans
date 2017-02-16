package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        var result = year.compareTo(other.year)
        if (result == 0) {
            result =  month.compareTo(other.month)
        }
        if (result == 0) {
            result = dayOfMonth.compareTo(other.dayOfMonth)
        }
        return result
    }
}

operator fun MyDate.rangeTo(end: MyDate): DateRange = DateRange(this, end)
operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) =
        addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.number)

operator fun DateRange.contains(date: MyDate): Boolean = date > start && date < endInclusive

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate: MyDate = start

            override fun hasNext(): Boolean {
                return currentDate <= endInclusive
            }

            override fun next(): MyDate {
                val next = currentDate
                currentDate = currentDate.nextDay()
                return next
            }
        }
    }
}