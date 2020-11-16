package autoComplete.trie;

/*
방법1. 배열을 통해 엄격한 초,중,종성 분리하여 구성하기
	장점1. 명확하게 코드 구현 가능
	
	단점1. idx 관리 및 초,종,중성의 trieNode만큼 메모리를 차지하므로 비효율적

방법2. 해쉬맵을 통해 부드럽게 초,중,종성 분리하여 구성하기
	장점1. 방법1에 비해 해쉬맵을 사용하므로 비교적 메모리를 덜 사용함
	
	단점1. 해쉬맵을 사용하므로 어떤식으로 구현해야할지 감이 안잡힘 


*/
//방법1.
public class hangulTrieForSearch {
	public class trieNode{
		private char data;
		private boolean isLeaf;
		private trieNode[] next;
		private trieNode parentNode;
		public trieNode(char ch) {
			data = ch;
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
		public trieNode[] getNext() {
			return next;
		}
		public void setNext(trieNode[] next) {
			this.next = next;
		}
		public trieNode getParentNode() {
			return parentNode;
		}
		public void setParentNode(trieNode parentNode) {
			this.parentNode = parentNode;
		}
		
	}
	private trieNode rootNode;
	public hangulTrieForSearch() {
		rootNode = new trieNode(' ');
	}
	
	
}
