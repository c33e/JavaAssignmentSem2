
public class Control extends fileProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileProcessor fp = new fileProcessor();
		fp.openFile();
		fp.cleanFile();
		fp.readFile(null, null);
		fp.Compare();
		fp.top10();
	}

}
