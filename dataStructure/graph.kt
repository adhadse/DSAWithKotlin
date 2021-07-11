/**
 *  @author Anurag Dhadse
 *  The below code is in Koltin (JVM)
 */
package kotlin

import java.util.*

class Graph(private var initialNodes:Int) {
    // make adjacency list with hashtable and list
    private val adjacency =  Hashtable<Int, MutableSet<Int>>()
    init{
        for (node in 0..initialNodes) {
            adjacency[node] = mutableSetOf()
        }
    }
    private fun toBool(s: Char): Boolean {
        // this function is required to yes/no of input to bool for loop
        if (s.isDigit()) { return true }
        return when (s) {
            'y' -> true
            'Y' -> true
            'n' -> false
            'N' -> false
            else -> true
        }
    }
    private fun result(s: Boolean): String {
        // this function just convert
        // true/false to human readable output
        return when (s) {
            true -> "Connected"
            false -> "Not Connected"
        }
    }
    //function to ask for connection between two node
    // either using bfs or dfs
    fun ask(method: String) {
        var input = true
        while (input) {
            print("Enter Nodes to check for connection (Using ${method.toUpperCase()}): ")
            val (a, b) = readLine()!!.split(' ').map(String::toInt)
            when (method) {
                "dfs" -> print("The node $a & node $b is ${result(this.dfs(a, b, mutableListOf<Int>()))}")
                "bfs" -> print("The node $a & node $b is ${result(this.bfs(a, b))}")
            }
            val scanner = Scanner(System.`in`)
            print("Ask more?(y/n)")
            input = toBool(scanner.next()[0])
        }
    }

    //Function to add edge into the graph
    fun addEdge() {
        print("Add edge (Node1 Node2): ")
        var input = true
        while (input) {
            val (node1, node2) = readLine()!!.split(' ').map(String::toInt)

            adjacency[node1] = adjacency[node1] ?: mutableSetOf()
            adjacency[node1]?.add(node2)

            adjacency[node2] = adjacency[node2] ?: mutableSetOf()
            adjacency[node2]?.add(node1)

            val scanner = Scanner(System.`in`)
            print("Add more edge?(y/n)")
            input = toBool(scanner.next()[0])
        }
    }

   //Function to Check BFS of graph
   private fun bfs(source: Int, destination: Int ): Boolean {
       //Queue to ask next node for their adjacency
       val queue: Queue<Int> = LinkedList<Int>()
       // Set to tel which nodes are visited,
       // if they are visited we will not check it adjacency (line 42)
       val visited = hashSetOf<Int>()

       for (node in adjacency) {
            print(node)
       }
       queue.add(source)
       visited.add(source)    // Mark current node as visited

//       Check Adjancency list
//       for (i in 1..7) {
//               print(adjacency[i]!!)
//       }

       while (queue.isNotEmpty()) {
           print("-------------------")
           print("Queue: $queue")
           val currNode = queue.remove()
           print("Checking $currNode")
           if (currNode == destination) {
               return true
           }
           visited.add(currNode)

           // Add all nodes which are adjacent to currNode BUT are not visited yet
           adjacency[currNode]?.forEach { nextNode ->
               if (!visited.contains(nextNode)) {
                   queue.add(nextNode)
               }
           }
       }
       return false
   }
    //function for DFS
    private fun dfs(source: Int, destination: Int, asked: MutableList<Int>): Boolean {
        if (asked.contains(source)) return false
        asked.add(source)
        println(asked)
        if (source == destination) return true      // Stoppinig Condition
        for (childNode in adjacency[source]!!) {
            if (dfs(childNode, destination, asked)) return true
        }
        return false
    }
}

fun main() {
    // Make a graph object with certain amount of
    // nodes in adjacency list
    var graph: Graph? = null
    while (graph == null) {
        print("Enter Initial no of nodes: ")
        graph = readLine()?.toIntOrNull()?.let { Graph(it) }
    }
    graph.addEdge()
    graph.ask("dfs")
    graph.ask("bfs")
}


