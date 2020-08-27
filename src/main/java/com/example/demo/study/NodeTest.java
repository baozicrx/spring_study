package com.example.demo.study;

/**
 * @Author: crx
 * @Create: 9:25 2019/11/6
 */
public class NodeTest {
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    static Node reverseByLoop(Node head) {
        if (head == null || head.next == null){
            return head;
        }

        Node preNode = null;
        Node nextNode = null;
        while (head != null){
            nextNode = head.next;

            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}
