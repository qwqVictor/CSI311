/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class TreeException extends RuntimeException {
	static final long serialVersionUID = 114514;
	public TreeException(String message) {
		super("TreeException: " + message);
	}
} 
