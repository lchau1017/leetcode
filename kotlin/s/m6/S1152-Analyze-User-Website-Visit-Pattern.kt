

class `S1152-Analyze-User-Website-Visit-Pattern` {
    fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        val userList = mutableListOf<User>()

        for (i in 0..username.lastIndex) {
            userList.add(User(username[i], timestamp[i], website[i]))
        }

        userList.sortBy { it.timestamp }

        val paths = HashMap<String, MutableList<String>>()
        userList.forEach {
            val path = paths.getOrDefault(it.userName, mutableListOf())
            path.add(it.webSite)
            paths.put(it.userName, path)
        }

        var maxCount = 0
        var maxPattern = ""

        val counts = HashMap<String, Int>()
        paths.forEach { name, path ->

            val hashSet = HashSet<List<String>>()

            for (i in 0..path.lastIndex - 2) {

                for (j in i + 1..path.lastIndex - 1) {

                    for (k in j + 1..path.lastIndex) {
                        val list = mutableListOf<String>()
                        list.add(path[i])
                        list.add(path[j])
                        list.add(path[k])
                        hashSet.add(list)
                    }
                }
            }

            hashSet.forEach { list ->
                val pattern = list.joinToString("/")
                val count = counts.getOrDefault(pattern, 0)
                val newCount = count + 1
                counts.put(pattern, newCount)

                if (newCount == maxCount && pattern.compareTo(maxPattern) < 0) {
                    maxPattern = pattern
                } else if (newCount > maxCount) {
                    maxCount = newCount
                    maxPattern = pattern
                }
            }

        }

        return maxPattern.split("/")
    }

    data class User(val userName: String, val timestamp: Int, val webSite: String)

}
