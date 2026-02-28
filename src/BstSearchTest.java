import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BstSearchTest {
    @Test
    void testBstSearch_nullRoot() {
        BinaryTreeNode<Integer> root = null;
        int target = 5;
        boolean expected = false; // If tree is null, sum of leaf nodes should be 0
        assertEquals(expected, BstSearch.contains(root, target));
    }
    @Test
    void testBstSearch_trueReturn() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(
            13,
            new BinaryTreeNode<>(
                -5,
                new BinaryTreeNode<>(9),
                new BinaryTreeNode<>(
                    9,
                    new BinaryTreeNode<>(31),
                    new BinaryTreeNode<>(7)
                )
            ),
            new BinaryTreeNode<>(
                42,
                new BinaryTreeNode<>(100),
                null
            )
        );
        int target = 9;
        boolean expected = true; // If tree is null, sum of leaf nodes should be 0
        assertEquals(expected, BstSearch.contains(root, target));
    }
     @Test
    void testBstSearch_falseReturn() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(
            13,
            new BinaryTreeNode<>(
                -5,
                new BinaryTreeNode<>(9),
                new BinaryTreeNode<>(
                    9,
                    new BinaryTreeNode<>(31),
                    new BinaryTreeNode<>(7)
                )
            ),
            new BinaryTreeNode<>(
                42,
                new BinaryTreeNode<>(100),
                null
            )
        );
        int target = 10;
        boolean expected = false; // If tree is null, sum of leaf nodes should be 0
        assertEquals(expected, BstSearch.contains(root, target));
    }
    @Test
    void testBstSearch_StringTreeTrueReturn() {
        /*
         *            "A1"
         *           /    \
         *        "Bb2"   "C3C"
         *        /   \       \
         *   "Xx9"   "Kk1"    "ZzZ"
         *
         */
        BinaryTreeNode<String> root = new BinaryTreeNode<>(
            "A1",
            new BinaryTreeNode<>(
                "Bb2",
                new BinaryTreeNode<>("Xx9"),
                new BinaryTreeNode<>("Kk1")
            ),
            new BinaryTreeNode<>(
                "C3C",
                null,
                new BinaryTreeNode<>("ZzZ")
            )
        );
        String target = "ZzZ";
        boolean expected = true;
        assertEquals(expected, BstSearch.contains(root, target));
    }
    @Test
    void testBstSearch_StringTreeFalseReturn() {
        /*
         *            "A1"
         *           /    \
         *        "Bb2"   "C3C"
         *        /   \       \
         *   "Xx9"   "Kk1"    "ZzZ"
         *
         */
        BinaryTreeNode<String> root = new BinaryTreeNode<>(
            "A1",
            new BinaryTreeNode<>(
                "Bb2",
                new BinaryTreeNode<>("Xx9"),
                new BinaryTreeNode<>("Kk1")
            ),
            new BinaryTreeNode<>(
                "C3C",
                null,
                new BinaryTreeNode<>("ZzZ")
            )
        );
        String target = "abc";
        boolean expected = false;
        assertEquals(expected, BstSearch.contains(root, target));
    }
    @Test
    void testBstSearch_NullTarget() {
        /*
         *            "A1"
         *           /    \
         *        "Bb2"   "C3C"
         *        /   \       \
         *   "Xx9"   "Kk1"    "ZzZ"
         *
         */
        BinaryTreeNode<String> root = new BinaryTreeNode<>(
            "A1",
            new BinaryTreeNode<>(
                "Bb2",
                new BinaryTreeNode<>("Xx9"),
                new BinaryTreeNode<>("Kk1")
            ),
            new BinaryTreeNode<>(
                "C3C",
                null,
                new BinaryTreeNode<>("ZzZ")
            )
        );
        String target = null;
        assertThrows(NullPointerException.class, () -> {
            BstSearch.contains(root, target);
        });
    }
}
