package zama.training.springboot;

/**
 * 
 * @author zama
 *
 */
public class Greeting {

	private long id;
	private String ipAddress;
	private String content;

	public Greeting(long id, String content, String ipAddress) {
		this.id = id;
		this.content = content;
		this.ipAddress = ipAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", ipAddress=" + ipAddress + ", content=" + content + "]";
	}
}