package kr.sys4u.filedir;


public class FileTreeStringBuilderConveter implements Convertable<StringBuilder,FileTree> {

	private static final String CRNL = "\r\n";
	private static final String SPACE = "    ";
	private static final String CHILD_SYMBOL = "└";

	private final StringBuilder converted;

	public FileTreeStringBuilderConveter() {
		this.converted = new StringBuilder();
	}
	
	@Override
	public StringBuilder convert(FileTree source) {
		converted.append("StringBuilderConverter : ").append(source.getRootNode().getFile().getAbsolutePath()).append(CRNL);
		convertFileNodeToStringBuilderRecursively(source.getRootNode());
		return converted;
	}
	

	private void convertFileNodeToStringBuilderRecursively(final FileNode parentNode) {
		
		for (FileNode childNode : parentNode.getChildren()) {
			converted.append(getDepthSpace(childNode.getDepth()))
				.append(childNode.getFile().getName())
				.append(CRNL);
			convertFileNodeToStringBuilderRecursively(childNode);
		}
	}

	private String getDepthSpace(final int depth) {
		StringBuilder spaceBuilder = new StringBuilder();

		for (int i = 0; i < depth; i++) {
			spaceBuilder.append(SPACE);
		}
		return spaceBuilder.append(CHILD_SYMBOL).toString();
	}



}
