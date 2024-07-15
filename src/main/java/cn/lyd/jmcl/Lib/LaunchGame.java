//定义包
package cn.lyd.jmcl.Lib;
//导入依赖
import java.io.IOException;
import org.to2mbn.jmccc.auth.OfflineAuthenticator;
import org.to2mbn.jmccc.exec.GameProcessListener;
import org.to2mbn.jmccc.launch.LaunchException;
import org.to2mbn.jmccc.launch.Launcher;
import org.to2mbn.jmccc.launch.LauncherBuilder;
import org.to2mbn.jmccc.option.LaunchOption;
import org.to2mbn.jmccc.option.MinecraftDirectory;
import org.to2mbn.jmccc.option.WindowSize;
public class LaunchGame{
	public static void LaunchGame(String GameVersion, String PlayerName, String GameDirectory, int GameWindowWidth, int GameWindowHeight, int MaxMemory, int MinMemory) throws IOException,LaunchException   {
		//创建启动器,是个容器
		Launcher StartMinecraft = LauncherBuilder.buildDefault();
		//创建启动命令
		LaunchOption op = new LaunchOption(GameVersion,new OfflineAuthenticator(PlayerName),new MinecraftDirectory(GameDirectory));
		//设置最大内存
		op.setMaxMemory(MaxMemory);
		//设置最小内存
		op.setMinMemory(MinMemory);
		//设置窗口大小
		op.setWindowSize(new WindowSize(GameWindowWidth,GameWindowHeight));
		//设置游戏是否全屏
		op.setExtraJvmArguments(null);
		StartMinecraft.launch(op,new GameProcessListener() {
			//输出游戏日志
			@Override
			public void onLog(String Log) {
				System.out.println(Log);
			}
			
			@Override
			public void onExit(int ExitCode) {
				if(ExitCode==0) {
					System.out.println("Game Exit!");
				}
			}
			
			@Override
			public void onErrorLog(String ErrorLog) {
				System.out.println(ErrorLog);
			}
		});
	}
}