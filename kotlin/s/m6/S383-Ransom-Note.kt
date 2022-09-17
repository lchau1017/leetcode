
class `S383-Ransom-Note`{

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val counts = mutableMapOf<Char, Int>()
        for (c in magazine.toCharArray()) {
            counts[c] = counts.getOrDefault(c, 0) + 1
        }

        for (r in ransomNote.toCharArray()) {
            if (!counts.containsKey(r) || counts[r]!! <= 0) {
                return false
            }
            counts[r] = counts.getOrDefault(r, 0) - 1
        }

        return true
    }
}
