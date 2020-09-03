package org.monan.algorithm;

public class List {

    public static class Node {

        private Integer val ;

        private Node next ;

        public Node(Integer val) {
            this.val = val;
        }
    }

    private Node head ;

    private Node tail ;

    private List() {
    }

    public static List newList(){
        List list = new List() ;
        return list ;
    }

    public void add(Node node){
        if (head == null){
            head = node ;
            tail = head ;
        } else {
            tail.next = node ;
            tail = node ;
        }
    }

    public void reverse(){
        Node newhead = null ;
        Node newtail = null ;
        Node cur = head ;
        Node next = null ;
        while(cur != null ){
            next = cur.next ;
            if (newhead == null){
                newhead = cur ;
                newtail = newhead ;
                newtail.next = null ;
            } else {
                cur.next = newhead;
                newhead = cur ;
            }

            cur = next ;
        }

        this.head = newhead ;
        this.tail = newtail ;
    }


    public void print(){
        Node tmp = head ;
        while(tmp != null){
            System.out.print(tmp.val +" -->") ;
            tmp = tmp.next ;
        }
        System.out.println() ;
    }

    public static void main(String[] args) {
        List list = newList() ;
        list.add(new Node(2));
        list.add(new Node(5));
        list.add(new Node(10));
        list.print();

        list.reverse();
        list.print();
    }
}
