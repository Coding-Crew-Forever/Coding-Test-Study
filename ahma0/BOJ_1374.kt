import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = Array<Lecture?>(n) { null }

    var st: StringTokenizer
    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())

        arr[i] = Lecture(
            num = st.nextToken().toInt(),
            start = st.nextToken().toInt(),
            end = st.nextToken().toInt()
        )
    }

    arr.sortWith(compareBy({ it?.start }, { it?.end }))

    val pq = PriorityQueue<Int>()
    for (i in 0 until n) {
        val newEnd = arr[i]!!.end

        if (pq.isEmpty()) {
            pq.add(newEnd)
            continue
        }

        val end = pq.peek()
        if (arr[i]!!.start < end) {
            pq.add(newEnd)
        } else {
            pq.poll()
            pq.add(newEnd)
        }
    }
    println(pq.size)
}

data class Lecture(
    val num: Int,
    val start: Int,
    val end: Int
)