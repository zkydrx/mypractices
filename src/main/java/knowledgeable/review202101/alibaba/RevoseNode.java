package knowledgeable.review202101.alibaba;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-04
 * Time: 21:47:52
 * Description:
 * 1 写一个函数将一个单向链表进行反向。要求自行编写反向的过程和设计数据结构，不要外部包和辅助函数来处理。
 */
public class RevoseNode
{

    class Node<K, V>
    {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node()
        {
            this.prev = this.next = null;
        }

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }


    Node reverseList(Node headNode)
    {
        if (headNode == null || headNode.next == null)
        {
            return headNode;
        }
        Node preNode = headNode;
        Node newHeadNode = null;
        while (preNode != null)
        {
            Node tmp = preNode.next;
            preNode.next = newHeadNode;
            newHeadNode = preNode;
            preNode = tmp;
        }
        return newHeadNode;
    }

}
