// PalindromeCheckerLinkedList.java
// UC8: Linked List Based Palindrome Checker

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Add character to linked list
    void add(char ch) {
        if (head == null) {
            head = new Node(ch);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(ch);
        }
    }

    // Find middle using fast & slow pointer
    Node findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse a linked list starting from given node
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Check if linked list is palindrome
    boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node middle = findMiddle();
        Node secondHalfStart = reverse(middle.next);

        Node firstHalf = head;
        Node secondHalf = secondHalfStart;

        boolean palindrome = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Restore original list
        middle.next = reverse(secondHalfStart);

        return palindrome;
    }

    // Display linked list (optional)
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}

public class PalindromeCheckerLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = sc.nextLine();

        LinkedList list = new LinkedList();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        System.out.print("Linked List Representation: ");
        list.display();

        if (list.isPalindrome()) {
            System.out.println("Result: The string is a palindrome ✅");
        } else {
            System.out.println("Result: The string is NOT a palindrome ❌");
        }

        sc.close();
    }
}