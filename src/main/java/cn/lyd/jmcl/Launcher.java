package cn.lyd.jmcl;

// 导入所需的类
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
import java.io.IOException;

public class Launcher extends Application {
    // 重写start方法，用于启动应用程序
    @Override
    public void start(Stage stage) throws IOException {
        // 加载FXML文件
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("Launcher.fxml"));
        // 创建场景
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // 设置窗口标题
        stage.setTitle("JMCL");
        //设置窗口是否可以改变大小
        stage.setResizable(false);
        // 设置窗口图标
        stage.getIcons().add(new javafx.scene.image.Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("icon.png"))));
        // 设置场景
        stage.setScene(scene);
        // 显示窗口
        stage.show();
        //添加键盘事件监听器
        scene.setOnKeyPressed(event -> {
            //获取按下的键
            String keyName = event.getCode().getName();
            //判断按下的键
            if (keyName.equals("Esc")) {
                // 关闭窗口
                stage.close();
                Platform.exit();

            }
        });
    }

    // 主方法，用于启动应用程序
    public static void main(String[] args) {
        launch();
    }
}