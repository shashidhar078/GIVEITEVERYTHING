class Solution {
    public Node flatten(Node root) {
        if (root == null) return null;

        Node tempNext = root;

        // Use a dummy node to help with merging
        Node dummy = new Node(0);
        Node current = dummy;

        // Process all the levels (columns)
        while (tempNext != null) {
            Node tempBottom = tempNext;

            // Merge current column with already merged nodes
            current = merge(current, tempBottom);

            // Move to the next column (next pointer)
            tempNext = tempNext.next;
        }

        // Return the flattened list (start from the first merged node)
        return dummy.bottom;
    }

    // Efficient merge function
    public static Node merge(Node left, Node right) {
        Node temp = new Node(0); // Temporary node to hold the merged result
        Node res = temp;

        // Merge the nodes in sorted order based on bottom pointers
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.bottom = left;
                left = left.bottom;
            } else {
                temp.bottom = right;
                right = right.bottom;
            }
            temp = temp.bottom;
        }

        // If there are remaining nodes in either left or right, append them
        if (left != null) {
            temp.bottom = left;
        } else {
            temp.bottom = right;
        }

        return res.bottom; // Return the merged list
    }
}
