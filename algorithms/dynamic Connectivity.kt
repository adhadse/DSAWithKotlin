package algorithms

class QuickFindUF_eager(private val n: Int){
    private val id = mutableListOf<Int>()
    init {
        for (i in 0 until n){
            id.add(i)
        }
    }

    /**
     *  Connected Or Not? function
     */
    fun connected(p:Int, q:Int):Boolean{
        return id[p]==id[q]
    }
    /**
     *  unite two elements to each other
     */
    fun unite(p:Int, q: Int){
        val pid = id[p]
        val qid = id[q]
        for (i in 0 until n){
            if (id[i]== pid){
                id[i] = qid
            }
        }
    }
}

class QuickFindUF_lazy(private val n: Int){
    private val id = mutableListOf<Int>()
    private val sz = mutableListOf<Int>()
    init {
        for (i in 0 until n){
            id.add(i)
            sz.add(1)
        }
    }
    private fun root(p: Int):Int{
        var num = p
        do {
            id[num] = id[id[num]]                 //path compression
            num = id[num]
        } while (num!=id[num])
        return num
    }
    fun connected(p: Int,q: Int): Boolean {
        if (root(p) == root(q)){
            println("Connected")
            return true
        }
        else
            println("Not Connected")
        return false
    }
    fun unite(p: Int, q: Int){
        val rootTreeQ = root(p)
        val rootTreeP = root(q)
        if (rootTreeP == rootTreeQ) return
        if (sz[rootTreeQ] < sz[rootTreeP]){        //Weighted Quick Union | smaller tress under bigger tree
            id[rootTreeQ] = rootTreeP
            sz[rootTreeP] += sz[rootTreeQ]
        }
        else{
            id[rootTreeP] = rootTreeQ
            sz[rootTreeQ] += sz[rootTreeP]
        }
    }
}

fun main(){
    val run = QuickFindUF_lazy(5)
    run.connected(4,3)
}