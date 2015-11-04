package leetcode;

public class TreeBuilder {

	TreeNode[] buffer;

	public TreeNode build(String data) {
		if ( data != null ) {
			return build(data.split(","));			
		} else {
			return null;
		}
	}
	
	TreeNode build(String[] data) {
		if (data != null && data.length != 0) {
			buffer = new TreeNode[data.length];

			for (int i = 0; i < data.length; i++) {
				TreeNode n = null;
				if (data[i] != null) {
					data[i] = data[i].trim();
					if (data[i].equals("#")) {
						n = null;
					} else {
						n = new TreeNode(Integer.parseInt(data[i]));
					}
				}

				buffer[i] = n;
				if ( i != 0 ) {
					if (i % 2 == 0) {
						if ( buffer[i/2-1] != null ) {
							buffer[i/2-1].right = n;							
						}
					} else {
						if ( buffer[i/2] != null ) {
							buffer[i/2].left = n;							
						}
					}					
				}

			}
		}
		return buffer != null ? buffer[0] : null;
	}

	public void print() {
		if (buffer != null) {
			for (int i = 0; i < buffer.length; i++) {
				String leftChild = getLeftChild(i);
				String rightChild = getRightChild(i);
				System.out.println(getValue(i) + " {" + leftChild + ","
						+ rightChild + "}");
			}
		}
	}
	
	private String getValue(int idx) {
		return buffer[idx] != null ? String.valueOf(buffer[idx].val) : null;
	}
	
	private String getLeftChild(int idx) {
		return getChild( idx*2 + 1 );
	}

	private String getRightChild(int idx) {
		return getChild( (idx+ 1)*2 );
	}

	private String getChild(int idx) {
		return (idx)< buffer.length ? getValue(idx) : null;
	}
	
	public static void main(String[] args) {
		TreeBuilder b = new TreeBuilder();
		b.build("1,#,3");
		b.print();
	}
}