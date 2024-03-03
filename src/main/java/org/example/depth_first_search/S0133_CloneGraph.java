package org.example.depth_first_search;


import com.google.common.collect.Lists;
import org.example.bo.Node;
import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/29 20:44
 **/
public class S0133_CloneGraph {

    @Test
    public void test() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Lists.newArrayList(node2, node4);
        node2.neighbors = Lists.newArrayList(node1, node3);
        node3.neighbors = Lists.newArrayList(node2, node4);
        node4.neighbors = Lists.newArrayList(node1, node3);

        S0133_CloneGraph exe = new S0133_CloneGraph();
        exe.cloneGraph(node1);
    }

    Map<Node, Node> visitMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (null == node) {
            return node;
        }
        if (visitMap.containsKey(node)) {
            return visitMap.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList());
        visitMap.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(this.cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
