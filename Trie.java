class TrieNode
{
    public TrieNode[] nodes;
    public boolean endsHere;

    public TrieNode()
    {
        nodes = new TrieNode[26];
        endsHere = false;
    }
}

public class Trie
{
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word)
    {
        if (word == null)
        {
            return;
        }

        if (word.length() == 0)
        {
            root.endsHere = true;
            return;
        }

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (curr.nodes[index] == null)
            {
                curr.nodes[index] = new TrieNode();
            }

            curr = curr.nodes[index];
        }

        curr.endsHere = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word)
    {
        if (word == null)
        {
            return false;
        }

        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if (curr.nodes[index] == null)
            {
                return false;
            }

            curr = curr.nodes[index];
        }

        return curr.endsHere;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix)
    {
        if (prefix == null)
        {
            return false;
        }

        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            int index = prefix.charAt(i) - 'a';

            if (curr.nodes[index] == null)
            {
                return false;
            }

            curr = curr.nodes[index];
        }

        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");