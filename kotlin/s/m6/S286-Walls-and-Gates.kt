

import java.util.ArrayDeque

class `S286-Walls-and-Gates` {
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val dirs = setOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val INF = 2147483647
        // Add the gates to the queue. Do not visit them yet.
        for (row in rooms.indices) {
            for (col in rooms[row].indices) {
                if (rooms[row][col] == 0) queue.offer(row to col)
            }
        }
        // Visit from gate to closest neighbors. We will visit from each gate to it's closest neighbors.
        while (queue.isNotEmpty()) {
            val (r, c) = queue.poll()
            for ((dr, dc) in dirs) {
                // These are our new directions, we will check the boundaries and make sure we are visiting new rooms only.
                val nr = r + dr
                val nc = c + dc
                if (nr < 0 || nc < 0 || nr > rooms.lastIndex || nc > rooms[nr].lastIndex || rooms[nr][nc] != INF) continue
                queue.offer(nr to nc)
                // Next room is valid and can be visited so increment the value of the room we are currently in.
                rooms[nr][nc] = rooms[r][c] + 1
            }
        }
    }
}
