
class `S784-Letter-Case-Permutation` {

    fun letterCasePermutation(S: String): List<String> {
        var result : ArrayList<String> = ArrayList<String>()
        var builder : StringBuilder = StringBuilder(S)
        dfs(builder, 0, result)
        return result
    }

    fun dfs(builder: StringBuilder, index: Int, result: ArrayList<String>) {

        if(index == builder.length) {
            result.add(builder.toString())
            return
        }

        var c : Char = builder.get(index);

        if(!c.isDigit()) {
            builder.setCharAt(index, c.toLowerCase())
            dfs(builder, index + 1, result)
            builder.setCharAt(index, c.toUpperCase())
            dfs(builder, index + 1, result)
        } else {
            dfs(builder, index + 1, result)
        }

    }
}
