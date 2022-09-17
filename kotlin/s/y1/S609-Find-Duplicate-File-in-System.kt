

class `S609-Find-Duplicate-File-in-System` {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (path in paths) {
            val segments = path.split(" ")
            val root = segments[0]

            // println(segments.toList())
            for (i in 1 until segments.size) {
                val segment = segments[i]
                val content = segment.substring(segment.indexOf('('), segment.length)
                map.putIfAbsent(content, mutableListOf())

                map[content]?.add("$root/${segment.substring(0, segment.indexOf("("))}")
            }
        }


        // println(map)
        return map.map { it.value }.filter { it.size > 1 }

    }
}
