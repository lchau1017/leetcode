

class `S212-Word-Search-II` {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        // Load the words that we want to find into a trie.
        val trie = Trie()
        for (word in words) {
            trie.insert(word)
        }

        // Search for the words, beginning at each position
        // in the board.
        val wordsFound = mutableListOf<String>()
        for ((i, row) in board.withIndex()) {
            for (j in 0 .. row.lastIndex) {
                trie.findAndRemoveWords(board, Position(i, j), wordsFound)
            }
        }

        return wordsFound
    }
}

private class Trie() {
    class TrieNode() {
        val children = mutableMapOf<Char, TrieNode>()
        // The word terminated by this node. A string is stored instead
        // of a boolean since we want to add the entire word to the
        // output list as soon as a match is found.
        var word: String? = null
    }

    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }

        node.word = word
    }

    // Searches for words present in the trie beginning at the given
    // position in the board. Any words found are added to the input
    // list and subsequently removed from the trie to prevent future
    // searches for the same words.
    fun findAndRemoveWords(
        board: Array<CharArray>,
        position: Position,
        wordsFound: MutableList<String>
    ) {
        findAndRemoveWords(board, position, wordsFound, mutableSetOf(), root)
    }

    private fun findAndRemoveWords(
        board: Array<CharArray>,
        position: Position,
        wordsFound: MutableList<String>,
        visited: MutableSet<Position>,
        parent: TrieNode
    ) {
        val char = board[position]
        val node = parent.children[char]

        // Base case - this character doesn't match any words
        // stemming from the parent node.
        node ?: return

        // Recursive case - continue searching from this character
        // in the board.
        visited.add(position)
        for (move in MOVES) {
            val nextPosition = position + move
            if (nextPosition.isValid(board) && !(nextPosition in visited)) {
                findAndRemoveWords(board, nextPosition, wordsFound, visited, node)
            }
        }

        visited.remove(position)

        // If this node terminates a word then we can add it to the list
        // of words found and remove it to prevent it from being added
        // again in the future.
        if (node.word != null) {
            wordsFound.add(node.word!!)
            node.word = null
        }

        // If this node doesn't have any remaining children then we can
        // also remove the parent's pointer to this node since we don't
        // need to search this path again.
        if (node.children.isEmpty()) {
            parent.children.remove(char)
        }
    }

    companion object {
        val MOVES = arrayOf(
            Position(-1, 0), // up
            Position(0, 1),  // right
            Position(1, 0),  // down
            Position(0, -1)  // left
        )
    }
}

private data class Position(val i: Int, val j: Int) {
    operator fun plus(other: Position) =
        Position(i + other.i, j + other.j)

    fun isValid(board: Array<CharArray>) =
        i >= 0 && i < board.size &&
                j >= 0 && j < board[i].size
}

private operator fun Array<CharArray>.get(position: Position) =
    this[position.i][position.j]