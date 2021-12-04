public class Yuying {

	public static void YuyingToSpeech(String yuying) {
		// TODO Auto-generated constructor stub
		ActiveXCompontent ax=null;
		try {
			ax= new ActiveXCompontent("Sapi.SpVoice");
			
			//运行时输出语言内容
		Dispatch spVoice= ax.getObject();
		
		ax.setProperty("Volume",new Variant(100));
		//音量0-100
		ax.setProperty("Rate",new Variant(-2));
		//语音朗读速度-10到+10
		Dispatch.call(spVoice,"Speak",new Variant(yuying));
		  //执行朗读
		
		ax=new ActiveXComponent("Sapi.SpFileStream");
		Dispatch spFileStram=ax.getObject();
		
		ax = new ActiveXComponent("Sapi.SpAudioFormat");
		Dispatch spAudioFormat = ax.getObject();
		//构建文件流生成语音文件
		Dispatch.put(spAudioFormat, "Type", new Variant(22));
		ActiveXCompontent spFileStream;
		//设音频流格式
		Dispatch.putRef(spFileStream, "Format", spAudioFormat);
		//设置文件输出流格式
		Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
		
		Dispatch.put(spVoice,"Volume",new Variant(100));
		//设置音量
		Dispatch.put(spVoice,"Rate",new Vaarianr(-2));
		//设置朗读速度
		Dispatch.call(spVoice,"Speak",new Variant(yuying));
		//开始朗读
		Dispatch.call(spFileStream,"Close");
		//关闭输出文件
		Dispatch.putRef(spVoice,"AUDioOutPutStream",null);
		spAudioFormat.safeRelease();
		spFileStream.safeRelease();
		spVoice.safeRelease();
		ax.safeRelease();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String s = "今天天气多云转晴，气温9到18度，近三天都是晴天";
		YuyingToSpeech(s);
		File file = new File("result.mp3"); // 打开mp3文件即可播放
		String fileName = "Operator.doc".toString();
		try {
			InputStream inStream =new FileInputStream("");//路径
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}
		}
}