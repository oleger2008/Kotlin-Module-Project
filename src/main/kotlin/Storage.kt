object Storage {
    private val archives: MutableList<Archive> = mutableListOf()
    fun addArchive(name: String) {
        archives.add(Archive(name))
    }
    fun getArchive(index: Int): Archive {
        return archives[index]
    }
    fun getAllArchives(): MutableList<Archive> {
        return archives
    }
    fun size(): Int {
        return archives.size
    }
}