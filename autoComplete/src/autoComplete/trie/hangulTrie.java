package autoComplete.trie;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class hangulTrie {
	public class trieNode{
		private char data;
		private boolean isLeaf;
		private HashMap<Character, trieNode> children;
		private trieNode parentNode;
		public trieNode(char ch) {
			this.data = ch;
			isLeaf = false;
			children = new HashMap<Character, trieNode>();
			parentNode = this;
		}
		
		public trieNode getParentNode() {
			return parentNode;
		}

		public void setParentNode(trieNode parentNode) {
			this.parentNode = parentNode;
		}

		public char getData() {
			return data;
		}
		public void setData(char data) {
			this.data = data;
		}
		public boolean isLeaf() {
			return isLeaf;
		}
		public void setLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}
		public HashMap<Character, trieNode> getChildren() {
			return children;
		}
		public void setChildren(HashMap<Character, trieNode> children) {
			this.children = children;
		}
		public trieNode putChild(char ch) {
			trieNode temp = new trieNode(ch);
			getChildren().put(ch, temp);
			return temp;
		}
		public trieNode getChild(char ch) {
			return getChildren().get(ch);
		}
		public Collection<? extends trieNode> getAllLeaf() {
			ArrayList<trieNode> list = new ArrayList<trieNode>();
			for(trieNode currNode : getChildren().values()) {
				if(currNode.isLeaf()) {
					list.add(currNode);
				}
				list.addAll(currNode.getAllLeaf());
			}
			return list;
		}
		public String getCurrString() {
			trieNode currNode = this;
			String str = "";
			while(currNode.parentNode.getData() != ' ') {
				char ch = currNode.getData();
				str += Character.toString(ch);
				currNode = currNode.getParentNode();
			}
			StringBuffer sb = new StringBuffer(str);
			String tempStr = sb.reverse().toString();
			str = Normalizer.normalize(tempStr,Normalizer.Form.NFC);
			return str;
		}
	}
	trieNode rootNode;
	public hangulTrie(){
		rootNode = new trieNode(' ');
	}
	public void insert(String word) {
		trieNode currNode = rootNode;
		word = Normalizer.normalize(word, Normalizer.Form.NFD);
		for(char ch : word.toCharArray()) {
			if(currNode.getChild(ch) != null) {
				currNode = currNode.getChild(ch);
			} else {
			    trieNode nextNode = currNode.putChild(ch);
			    nextNode.setParentNode(currNode);
				currNode = nextNode;
			}
		}
		currNode.setLeaf(true);
	}
	public boolean search(String word) {
		trieNode currNode = rootNode;
		word = Normalizer.normalize(word, Normalizer.Form.NFD);

		for(char ch : word.toCharArray()) {
			if(currNode.getChild(ch) != null) {
				currNode = currNode.getChild(ch);
			} else {
				return false;
			}
		}
		return currNode.isLeaf();
	}
	public ArrayList<trieNode> findAllLeafs(String word){
		ArrayList<trieNode> list = new ArrayList<trieNode>();
		word = Normalizer.normalize(word, Normalizer.Form.NFD);

		trieNode currNode = rootNode;
        for(char c : word.toCharArray()) {
            if(currNode.getChild(c)!=null) {
                currNode = currNode.getChild(c);
            }
            else {
                list.clear();
                return list;
            }
        }
        if(currNode.isLeaf()) {
            list.add(currNode);
        }
        list.addAll(currNode.getAllLeaf());
		return list;
	}
}
