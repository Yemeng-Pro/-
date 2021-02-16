package day12_Graph;

import java.util.*;

/**
 * @author Yemeng
 * @create 2021-01-05-21:29
 */

    import java.util.*;

    public class Test3 {

        // 深度
        public void DFS(HashMap<String, String> map, String startNode) {
            // 定义一个访问数组，判断当前节点是否访问过
            ArrayList<String> visited = new ArrayList<>();
            // 使第一个节点入栈
            Stack<String> stack = new Stack<>();
            stack.push(startNode);
            while (!stack.isEmpty()) {
                // 出栈
                String node = stack.pop();
                // 判断当前节点是否访问过
                if (!visited.contains(node)) {
                    visited.add(node);
                    String[] linkNode = map.get(node).split(",");
                    // 使当前节点的后继入队列
                    for (String n : linkNode) {
                        stack.push(n);
                    }
                }
            }
            // 输出
            System.out.println(visited.toString());

        }

        // 广度
        public void BFS(HashMap<String, String> map, String startNode) {
            // 定义一个访问数组，判断当前节点是否访问过
            ArrayList<String> visited = new ArrayList<>();
            // 使需要访问的第一个节点入队列
            Queue<String> queue = new LinkedList<String>();
            queue.offer(startNode);
            // 直到队列为空，广度优先遍历结束
            while (!queue.isEmpty()) {
                // 出队列
                String node = queue.poll();
                // 判断当前节点是否访问过
                if (!visited.contains(node)) {
                    visited.add(node);
                    String[] linkNode = map.get(node).split(",");
                    // 使当前节点的后继入队列
                    for (String n : linkNode) {
                        queue.offer(n);
                    }
                }
            }
            // 输出
            System.out.println(visited.toString());
        }

        public static void main(String[] args) {
            // 邻接表形式存图
            HashMap<String, String> map = new HashMap<String, String>() {
                {
                    put("A", "B,C");
                    put("B", "A,C,D,E");
                    put("C", "A,B");
                    put("D", "B");
                    put("E", "B");
                }
            };
            System.out.println("深度优先遍历");
            new Test3().DFS(map, "A");
            System.out.println("广度优先遍历");
            new Test3().BFS(map, "A");
        }
    }

