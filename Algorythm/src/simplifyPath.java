import java.util.Stack;


public class simplifyPath {
	/*
	 * /home/
	 * "/a/./b/../../c/"
	 * "/.."
	 */
	
    public String simplifyPath(String path) {
    	if(path == null) return null;
    	if(path.equals("")) return path;
    	
    	String splited[] = path.split("/");
    	Stack<String> stack = new Stack<String>();
    	
    	for(int i = 0; i < splited.length; ++i) {
    		if(splited[i].equals("") || splited[i].equals(".")) continue;
    		else if(splited[i].equals("..")) {
    			if(!stack.isEmpty()) stack.pop();
    		} else {
    			stack.push(splited[i]);
    		}
    	}
    	if(stack.size() == 0) return "/";
    	String ret = "";
    	for(int i = 0; i < stack.size();++i) {
    		ret += "/" + stack.get(i);
    	}
    	return ret;
    }
	public static void main(String[] args) {
		String path = "/home//foo/";
		String[] pathes = path.split("/");
		for(int i = 0; i < pathes.length; ++i) {
			System.out.println(pathes[i]);
		}
	}
}
