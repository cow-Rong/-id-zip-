package zipPrase;

import java.util.List;

public class DeviceUtil {
	private String name;
	private String id;
	private String type;
	private String version;
	private int[] cfcard;
	private int[] sdram;
	
	private int sumPort;
	private int sumGE;
	private int sumtenGE;
	private int sumETH;
	private int sumPos;
	private int sumCPos;
	
	private List<String> allPort;
	private List<String> allGE;
	private List<String> alltenGE;
	private List<String> allETH;
	private List<String> allPos;
	private List<String> allCPos;
	
	private List<String> upPort;
	private List<String> upGE;
	private List<String> uptenGE;
	private List<String> upETH;
	private List<String> upPos;
	private List<String> upCPos;
	
	// 如果是新机框，我们取两者结合算数量
	// 如果是老机框，我们就不看上面槽位直接去下面算数量
	private int sumBord;
	

}
